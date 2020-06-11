package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass01 {
	public static void main(String[] args) {
		//JFrame 객체 생성하고
		JFrame f = new JFrame("Hello Frame");
		//초기 위치와 크기 지정
		f.setBounds(100, 100, 500, 500);
		//프레임을 닫았을때 자동으로 프로세스 종료 되도록
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //하나만 닫아도 나머지 창이 전부 닫히는 이유는 이 코드때문
		//레이앙ㅅ 매니저를 사용하지 않도록 설정
		f.setLayout(null);
		//버튼
		JButton btn = new JButton("눌러보셈");
		btn.setBounds(10, 10, 100, 40);
		//프레임에 버튼 추가하기
		f.add(btn);
		
		//프레임이 보이도록 한다.
		f.setVisible(true);
		
		JFrame a = new MyFrame("나만의 프레임");
	}
	
	public static class MyFrame extends JFrame{
		public MyFrame(String title) {
			super(title);
			//초기화 작업
			setBounds(200, 200, 500, 500);
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setVisible(true);	//this없어도 괜찮음
			
//			this.setBounds(200, 200, 500, 500);
//			this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//			this.setVisible(true);
		}
	}
}
