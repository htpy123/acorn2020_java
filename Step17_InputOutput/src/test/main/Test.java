package test.main;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Test extends JFrame{
	public Test() {
		setLayout(new FlowLayout());
		
		JButton b1 = new JButton("전송");
		JButton b2 = new JButton("삭제");
		
		add(b1);
		add(b2);
		
		ActionListener lis = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Test.this, "전송해용");
			}
		};
		ActionListener lis2 = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(Test.this, "삭제해용");
			}
		};
		b1.addActionListener(lis);
		b2.addActionListener(lis2);
	}
	
	public static void main(String[] args) {
		Test frame = new Test();
		frame.setTitle("Test");
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.setBounds(100, 100, 500, 500);
		frame.setVisible(true);
	}

}
