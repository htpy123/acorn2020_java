package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.plaf.metal.MetalLookAndFeel;
import javax.swing.plaf.metal.OceanTheme;

public class ProblemSolving_Quiz03 extends JFrame implements ActionListener{
	//필드
	JTextArea area;
	
	//생성자
	public ProblemSolving_Quiz03() {
		//프레임의 제목 설정 
		setTitle("나의 파일");
		//프레임의 레이아웃 지정 
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기 
		JMenuItem item_new=new JMenuItem("New");
		JMenuItem item_open=new JMenuItem("Open");
		//default 생성자를 호출해서 객체를 생성한후
		JMenuItem item_save=new JMenuItem();
		//아이템 text 를 메소드를 이용해서 전달도 가능하다 
		item_save.setText("Save");
		
		//아이템에 액션  command  지정하기 
		item_new.setActionCommand("new");
		item_open.setActionCommand("open");
		item_save.setActionCommand("save");
		//아이템에 액션 리스터 등록하기 
		item_new.addActionListener(this);
		item_open.addActionListener(this);
		item_save.addActionListener(this);
		
		//메뉴에 아이템 추가 
		JMenu menu1=new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		
		JMenu menu2=new JMenu();
		menu2.setText("도움말");
		
		//메뉴바에 메뉴 추가 
		JMenuBar mb=new JMenuBar();
		mb.add(menu1);
		mb.add(menu2);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area 를 프레임의 가운데에 배치 
		area=new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
		area.setVisible(false);
	}
	// run 했을때 실행순서가 시작 되는 메인 메소드 
	public static void main(String[] args) {
		//프레임을 만들어서 화면에 띄우는 작업을 한다. 
		ProblemSolving_Quiz03 f=new ProblemSolving_Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	// File > 메뉴아이템을 클릭하면 호출되는 메소드 
	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 아이템의 액션 command 를 읽어온다.
		String command=e.getActionCommand();
		if(command.equals("new")) { // 아이템 New 를 눌렀을때
			area.setText("");	//문자열 삭제
			area.setVisible(true); //JTextArea 를 보이게 하고 
			area.grabFocus(); //포커스를 준다. 깜빡깜빡하는 커서
		}else if(command.equals("open")) {// 아이템 Open 을 눌렀을때
			area.setText("");
			openContent();
		}else if(command.equals("save")) {// 아이템 Save 를 눌렀을때 
			saveContent();
			//JTextArea 에 입력한 문자열을 읽어 온다.
//			String content = area.getText();
//			JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
//			int result = fc.showSaveDialog(this);	//저장을 눌렀는지 취소를 눌렀는지 창을 닫았는지에 대한 int값이 저장된다.
//			//↑↑↑↑위 코드만으로는 파일이 생성되지 않는다. 그리고 코딩이 길어질경우 메소드를 만들어서 불러내는 식으로 코딩하는게 좋다
		}
	}
	//파일에 있는 문자열을 읽어와서 출력하는 작업을 하는 메소드
	public void openContent() {
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result  = fc.showOpenDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			//open 할 예정인 파일 객체의 참조값 얻어오기
			File file = fc.getSelectedFile();
			try {
				FileReader fr = new FileReader(file);	//Reader r = new FileReader(file);
				BufferedReader br = new BufferedReader(fr);
				while(true) {	//String으로 불러오는건 좋은데 몇줄인줄 모르니 일단 계속 반복해
					//문자열을 줄단위로 한줄씩 읽어낸다.
					String line = br.readLine();
					if(line == null) {	//더이상 읽을 문자열이 없다면 String은 null 정수는 -1
						break;	//반복문 탈출
					}
					//JTextArea 에 문자열을 개행기호와 함께 append (누적 출력) 하기
					area.append(line);
					area.append("\r\n");
				}
				//JTextArea가 화면에 보이도록
				area.setVisible(true);
				br.close();
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	//파일에 저장하는 작업을 하는 메소드
	public void saveContent() {
		//JTextArea에 입력한 문자열을 읽어온다.
		String content = area.getText();
		JFileChooser fc = new JFileChooser("c:/acorn2020/myFolder");
		int result = fc.showSaveDialog(this);
		if(result == JFileChooser.APPROVE_OPTION) {
			//새로 만들 예정인 File 객체의 참조값 얻어오기
			File file = fc.getSelectedFile();
			//파일에 문자열을 출력할수 있는 객체 생성
			try {
				FileWriter fw = new FileWriter(file);
				fw.write(content);
				fw.flush();
				fw.close();
				JOptionPane.showMessageDialog(this, file.getName()+"에 저장했습니다");//그냥 file만 입력하면 경로 전체를 출력
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}

		



