package test.main;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
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
import javax.swing.JTextField;
import javax.swing.UIManager;

public class Quiz03 extends JFrame implements ActionListener{
	JTextArea area;
	public Quiz03() {
		
		setTitle("나의 파일");
		setLayout(new BorderLayout());
		//메뉴 아이템 3개 만들기
		JMenuItem item_new = new JMenuItem("New");
		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_save = new JMenuItem("Save");
		JMenuItem item_close = new JMenuItem("Close");
		
		item_new.setActionCommand("new");
		item_new.addActionListener(this);
		
		item_open.setActionCommand("open");
		item_open.addActionListener(this);
		item_save.setActionCommand("save");
		item_save.addActionListener(this);
		
		item_close.setActionCommand("close");
		item_close.addActionListener(this);
		
		//메뉴에 아이템 추가
		JMenu menu1 = new JMenu("File");
		menu1.add(item_new);
		menu1.add(item_open);
		menu1.add(item_save);
		menu1.add(item_close);
		//메뉴바에 메뉴 추가
		JMenuBar mb = new JMenuBar();
		mb.add(menu1);
		//프레임에 메뉴바 장착
		setJMenuBar(mb);
		
		//텍스트 area 를 프레임의 가운데에 배치
		area = new JTextArea();
		add(area, BorderLayout.CENTER);
		area.setBackground(Color.YELLOW);
		area.setVisible(false);
	}
	
	
	public static void main(String[] args) {	
		Quiz03 f=new Quiz03();
		f.setBounds(100, 100, 500, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String command = arg0.getActionCommand();
		if(command.equals("open")) {
			Open();
		}else if(command.equals("new")) {
			New();
		}else if(command.equals("save")) {
			Save();
		}else if(command.equals("close")) {
			Close();
		}
	}
	public void Close() {
		area.setText("");
		area.setVisible(false);
		
	}
	
	public void New() {
		area.setVisible(true);
	}
	
	public void Save() {
		//JTextField 에 입력한 문자열을 읽어와야한다.
		String str=area.getText();
		
		//2. memo.txt 파일에 저장하기
		File file1 = new File("c:/acorn2020/myFolder/save.txt");

		try {
			boolean isExist = file1.exists();
			if(!isExist) {
				file1.createNewFile();
			}
			
			FileWriter fw = new FileWriter(file1, true);
			
			fw.write(str);
			
			fw.close();
			
			System.out.println("문자열을 저장했습니다.");
			JOptionPane.showMessageDialog(this, "저장했습니다");
			
			}catch(IOException ie) {
			ie.printStackTrace();
		}
	}
	public void Open() {
		File memoFile = new File("c:/acorn2020/myFolder/save.txt");
		try {
			if(!memoFile.exists()) {
				System.out.println("파일이 존재 하지 않습니다.");
				return;
			}
			FileReader fr = new FileReader(memoFile);
			BufferedReader br = new BufferedReader(fr);
			
			while(true) {
				String line = br.readLine();
				if(line == null) { 
					break; 
				}
				
				area.append(line);
				area.append("\r\n");
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
}
