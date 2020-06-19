package example5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ServerMain {
	//static 필드
	static List<ServerThread> threadList = new ArrayList<>();
	
	public static void main(String[] args) {
		//필요한 객체를 저장할 지역변수 미리 만들기
		ServerSocket serverSocket = null;
		try {
			//5000번 통신 port 를 열고 클라이언트의 접속을 기다린다.
			serverSocket = new ServerSocket(5000);
			
			/*
			 * 	accept() 메소드는 클라이언트가 실제 접속을 할때 까지 리턴하지 않고
			 * 	블록킹 되는 메소드이다.
			 * 	클라이언트가 접속을 해오면 Socket 객체의 참조값을 반환하면서 리턴된다.
			 */
			while(true) {
				System.out.println("클라이언트의 Socket 연결 요청을 대기합니다");
				//클라이언트의 소켓 접속을 기다린다.
				Socket socket = serverSocket.accept();	//이쪽에 
				System.out.println("클라이언트가 접속을 했습니다");
				//방금 접속한 클라이언트를 응대할 스레드를 시작 시킨다. //접속할때마다 스레드 생성
				ServerThread thread = new ServerThread(socket);//static 클래스에서는 static 클래스만 사용가능 내부 클래스는 static 클래스 안에서 사용하려면 static을 붙여야한다.
				thread.start();
				//생성하고 시작한 스레드의 참조값을 List 에 저장하기
				ServerMain.threadList.add(thread);	//ServerMain 같은 static 자원이기떄문에 생략 가능 
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(serverSocket!=null)
					serverSocket.close();
			}catch(Exception e) {}
		}
	}
	//내부 클래스로 스레드 객체를 생성할 클래스를 정의한다.
	//static main() 메소드에서 클래스를 사용하기 위해 static 예약어를 붙여서 정의한다.
	public static class ServerThread extends Thread{
		//필드
		Socket socket;//Socket socket; 선언만 하면 null값이 들어있다.
		
		//클라이언트에게 문자열을 출력할수 있는 객체
		BufferedWriter bw;
		
		//클라이언트의 대화명을 저장할 필드
		String chatName; //선언만 하면 null 
		
		//생성자의 인자로 Socket 객체를 전달받도록 한다.
		public ServerThread(Socket socket) {
			//생성자의 인자로 전달 받은 Socket 객체의 참조값을 필드에 저장한다.
			this.socket=socket;
		}
		//인자로 전달된 문자열을 Socket을 통해서 출력하는 메소드
		public void sendMessage(String msg) throws IOException {
			//반복문 돌면서 모든 스레드의 BufferedWriter 객체를 이용해서
			//문자열을 전송한다.
			for(ServerThread tmp:threadList) {
				tmp.bw.write(msg);	// 문자열 출력
				tmp.bw.newLine();	// 개행기호 출력
				tmp.bw.flush();		// 방출
				
			}
		}
		//참여자 목록을 얻어내서 Client 에게 출력해주는 메소드
		public void sendChatNameList() {
			JSONObject jsonObj = new JSONObject();
			JSONArray jsonArr = new JSONArray();
			jsonArr.put(0,"김구라");
			jsonArr.put(1,"해골");
			jsonArr.put(2,"원숭이");
			
			for(int i = 0; i<threadList.size();i++){
				ServerThread tmp = threadList.get(i);
				jsonArr.put(i, tmp.chatName);
			};
			
			jsonObj.put("type", "members");
			jsonObj.put("list", jsonArr);
			
			try {
				sendMessage(jsonObj.toString());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		//새로운 작업 단위가 시작되는 run() 메소드
		@Override
		public void run() {
			try{
				String clientIp = socket.getInetAddress().getHostAddress();
				System.out.println("접속한 클라이언트의 아이피 : "+clientIp);
				
				//클라이언트로 부터 읽어들일(Input) 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				
				//클라이언트에게 출력할수 있는 객체
				OutputStream os = socket.getOutputStream();
				OutputStreamWriter osw = new OutputStreamWriter(os);
				//BufferedWriter 객체의 참조값을 필드에 저장하기
				bw=new BufferedWriter(osw);
				
				while(true) {
					/*
					 * 	클라이언트가 무자열을 한줄 (개행기호와 함께) 보내면
					 * 	readLine() 메소드가 리턴 하면서 보낸 문자열을 가지고 온다
					 * 	보내지 않으면 계속 블로킹 되어서 대기하고 있다가
					 * 	접속이 끊키면 Exception 이 발생하거나 혹은 null 이
					 * 	리턴 된다
					 * 	따라서 null 이 리턴되면 반복문을 빠져 나가게 break 문을 만나도록
					 * 	한다
					 * 	실행순서가 try 블럭을 벗어나면 run() 메소드가 리턴하게 되고
					 * 	run() 메소드가 리턴되면 해당 스레드는 종료가 된다.
					 */
					//클라이언트가 전송하는 문자열을 읽어낸다.
					String msg = br.readLine();
					//전송된 JSON 문자열을 사용할 준비를 한다.
					JSONObject jsonObj = new JSONObject(msg);
//					System.out.println("메세지 : "+ msg);
					//type을 읽어낸다.
					String type = jsonObj.getString("type");
					if(type.equals("enter")) {
						//현재 스레드가 대응하는 클라이언트의 대화명을 필드에 저장한다
						String chatName = jsonObj.getString("name");
						this.chatName = chatName;
					}else if(type.equals("msg")) {
						
					}
					
					//클라이언트에게 동일한 메세지를 보내는 메소드를 호출한다.
					sendMessage(msg);
					if(msg==null) {	//클라이언트의 접속이 끊켰기 떄문에
						break;	//반복문(while) 을 빠져 나오도록 한다
					}
				}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				//접속이 끊켜서 종료되는 스레드는 List에서 제거한다.
				threadList.remove(this);
				
				try {
					//this 가 퇴장 한다고 메세지 보낸다.
					JSONObject jsonObj=new JSONObject();
					jsonObj.put("type", "out");
					jsonObj.put("name", this.chatName);
					sendMessage(jsonObj.toString());
					//대화명 목록을 보내준다.
					sendChatNameList();
					if(socket!=null)socket.close();
				}catch(Exception e) {}
			}
		}
	}
}
