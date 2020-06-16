package test.Frame2;

import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MyFrame extends JFrame{

	//생성자
	public MyFrame(String title) {
		super(title);
		setBounds(100,100,500,500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		//레이 아웃 매니저를 FlowLayout 으로 지정한다
		//setLayout(new FlowLayout(0));				//가독성의 차이
		setLayout(new FlowLayout(FlowLayout.LEFT)); //가독성의 차이
		
		JButton btn1 = new JButton("버튼1");
		add(btn1);
		
		JButton btn2 = new JButton("버튼2");
		//btn2.setSize(100, 30);
		add(btn2);
		
		JButton btn3 = new JButton("버튼3");
		//btn3.setSize(100, 30);
		add(btn3);
		
		JButton btn4 = new JButton("버튼4");
		//btn4.setSize(100, 30);
		add(btn4);
		
		setVisible(true);
	}
	
	public static void main(String[] args){
		new MyFrame ("나의 프레임");
	}
}
