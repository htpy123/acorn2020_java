package example5;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/*
 * 	JSON
 * 
 * 	-	Java Script Object Notation (자바스크립트 객체 표기법을 따르는 문자열)
 * 
 * 	-	데이터의 type
 * 		1. { }
 * 		2. [ ]
 * 		3. "xxx"
 * 		4.	10 or 10.1
 * 		5.	true or false
 * 		6.	null
 * 
 * 	-	JSON 예제
 * 
 * 		{"num":1,	"name":"김구라",	"isMan":true,	"phone":null} //key값은 항상 더블 따옴표로 감싸야한다.
 * 
 * 		[10, 20, 30, 40, 50]
 * 
 * 		["김구라", "해골", "원숭이"]
 * 
 * 		[{}, {}, {}]
 * 
 * 		{"name":"kim", "friends":["김구라", "해골", "원숭이"]}
 * 
 * 
 * 		메세지의 종류
 * 	1. 일반 대화 메시지
 * 		{"type" : "msg", "name" : "김구라", "content" : "안녕하세요"}	//JSONObject
 * 	2. 누가 들어왔다는 메시지
 * 		{"type" : "enter", "name":"김구라" }
 * 	3. 누가 나갔다는 메시지
 * 		{"type" : "out","name" : "원숭이" }
 * 	4. 참여자 목록 메시지
 * 		{"type":"members", "list" : ["김구라","해골","원숭이"]}		//JSONArray
 */


public class ClientMain extends JFrame implements ActionListener, KeyListener{
	//필드
	JTextField tf_msg;
	//서버와 연결된 Socket 객체의 참조값을 담을 필드
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	//대화명
	String chatName;
	//참여자 목록
	JList<String> jList;
	
	//생성자                                                                           동작의 준비와 구성은 생성자에서 한다
	public ClientMain() {
		
		chatName = 
				JOptionPane.showInputDialog(this,"대화명을 입력하세요");
		
		setTitle("대화명: "+chatName);
		
		//서버에 소켓 접속을 한다
		try {
			//접속이 성공되면 Socket 객체의 참조값이 반환된다.
			//반환되는 객체의 참조값을 필드에 저장해 놓는다
			socket=new Socket("192.168.0.30",5000);
			//서버에 문자열을 출력할
			//BufferedWriter 객체의 참조값을 얻어내서 필드에 저장해 놓는다
			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);
			//내가 입장한다고 서버에 메세지를 보낸다.
			//{"type":"enter","name" : "대화명"}
//			String msg = "{\"enter\":\""+chatName+"\"}";
//			
			//서버로 부터 메세지를 받을 스레드도 시작을 시킨다.
			new ClientThread().start();
			
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg = jsonObj.toString();
			
			//BufferedWriter 객체를 이용해서 보내기
			bw.write(msg);
			bw.newLine();
			bw.flush();
//			System.out.println(msg + " | " + msg2);
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
		//레이아웃을 BorderLayout 으로 지정하기
		setLayout(new BorderLayout());
		
		//페널 객체
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);
		//입력창
		tf_msg=new JTextField(10);
		//버튼
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		
		JButton resetBtn = new JButton("닉네임변경");
		resetBtn.setActionCommand("reset");
		
		JButton joinBtn = new JButton("채팅방인원");
		joinBtn.setActionCommand("join");
		
		//페널에 입력창과 버튼을 추가
		panel.add(tf_msg);
		panel.add(sendBtn);
		panel.add(resetBtn);
		panel.add(joinBtn);
		//프레임의  아래쪽에 페널 배치하기
		add(panel, BorderLayout.SOUTH);
		
		//버튼에 리스너 등록
		sendBtn.addActionListener(this);
		
		resetBtn.addActionListener(this);
		
		joinBtn.addActionListener(this);
		//JTextArea의 참조값을 필드에 저장하기
		area = new JTextArea();
		//문자열 출력 전용으로 사용하기 위해 편집 불가능하도록 설정
		area.setEditable(false);
		//배경색
		area.setBackground(Color.PINK);
		//스크롤 가능하도록
		JScrollPane scroll = new JScrollPane(area,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		//프레임 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
//		area.setVisible(true);
		
		//엔터키로 메세지 전송 가능하게 하기 위해
		tf_msg.addKeyListener(this);
		
		//String[] 에 JList 공간 확보를 위해 임시 문자열을 넣는다.
		String[] title = {"참여자 목록"};
		jList=new JList<String>(title);
		jList.setBackground(Color.PINK);
		
		//페널에 JList 를 배치하고
		JPanel rightPanel = new JPanel();
		rightPanel.add(jList);
		//페넬을 프레임의 동쪽에 배치
		add(rightPanel, BorderLayout.EAST);
		
		//대화명을 입력 받아서 필드에 저장한다.
		chatName=JOptionPane.showInputDialog(this, "대화명을 입력하세요");
		
		
	}//생성자
	
	
	
	public static void main(String[] args) {
		//프레임 객체 생성
		ClientMain f = new ClientMain();
//		f.setTitle("채팅창");
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}	
		
	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str == "reset") {
			chatName = 
					JOptionPane.showInputDialog(this,"대화명을 입력하세요");
			setTitle("대화명: "+chatName);
			new ClientThread().start();
			
			
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("name", chatName);
			String msg = jsonObj.toString();
			
			//BufferedWriter 객체를 이용해서 보내기
			try {
				bw.write(msg);
				bw.newLine();
				bw.flush();
			} catch (Exception e1) {
				e1.printStackTrace();
			}
			
		}else if(str=="join"){
			
		}else {
			sendMessage();
		}
	}	
			
	//메세지를 전송하는 메소드
	public void sendMessage() {
		String msg = tf_msg.getText();
		
		try {
			//JSONObject 객체를 생성해서 정보를 구성하고
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "msg");
			jsonObj.put("name", chatName);
			jsonObj.put("content", msg);
			//JSON 문자열을 얻어낸다.
			String jsonString = jsonObj.toString();
			
			bw.write(jsonString);
			bw.newLine();	//개행기호도 출력 (서버에서 줄단위로 읽어낼 예정)
			bw.flush();
//			쓰고나서 지우기
			tf_msg.setText("");
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}

	//서버에서 불특정 시점에 도착하는 메세지를 받을 스레드
	public class ClientThread extends Thread{
		
		
		@Override
		public void run() {
			try {
				//서버로 부터 입력 받을수 있는 객체의 참조값 얻어오기
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					//서버로부터 문자열이 전송되는지 대기한다.
					String msg = br.readLine();
					
					updataTextArea(msg);
	
					//최근 추가된 글 내용이 보일수 있도록
					int docLength = area.getDocument().getLength();
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}//run()
		
		//JTextArea 에 문자열을 출력하는 메소드
		public void updataTextArea(String msg) {
			try {

				JSONObject jsonObj = new JSONObject(msg);
				String type = jsonObj.getString("type");
				if(type.equals("enter")){ //입장 메세지라면
					//누가 입장했는지 읽어낸다.
					String name = jsonObj.getString("name");
					area.append("["+name+"] 님이 입장했습니다.");
					area.append("\r\n");
				}else if(type.equals("msg")) { //대화 메시지 라면
					//누가
					String name = jsonObj.getString("name");
					//어떤 내용을
					String content = jsonObj.getString("content");
					//출력하기
					area.append(name+" : "+content);
					area.append("\r\n");
				}else if(type.equals("out")) {
					//누가
					String name = jsonObj.getString("name");
					//출력하기
					area.append("[["+name+"]] 님이 퇴장했습니다.");
					area.append("\r\n");
				}else if(type.equals("members")) { //대화 참여자 목록이 도착
					//list 라는 키값으로 저장된 JSONArray 객체를 업어ㅓ
					JSONArray arr = jsonObj.getJSONArray("list");
					//참여자 목록을 저장할 Vector
					Vector<String> list = new Vector<>();
					list.add("참여자 목록");
					//반복문 돌면서 참여자 목록을 다시 넣어준다.
					for(int i=0;i<arr.length();i++){
						String tmp = arr.getString(i);
						list.add(tmp);
					}
					//JList 에 참여자 목록 연결하기
					jList.setListData(list);
				}
			}catch(JSONException je) {
				je.printStackTrace();
			}
		}
	}// class client Thread

	@Override
	public void keyPressed(KeyEvent e) {
		//눌러진 키의 코드값
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER)//if(code == 10); 으로 해도된다 VK_ENTER의 반환값은 10이기 때문이다 마우스 올려보면안다
			sendMessage();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
