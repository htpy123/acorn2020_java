package example4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONObject;

public class ClientMain2 extends JFrame implements ActionListener, KeyListener{

	JTextField tf_msg;
	Socket socket;
	BufferedWriter bw;
	JTextArea area;
	String chatName;
    
	public ClientMain2() {
		
		chatName = 
				JOptionPane.showInputDialog(this,"대화명을 입력하세요");
		
		setTitle("대화명: "+chatName);
		
		
		try {
			socket=new Socket("192.168.0.30",5000);

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			bw = new BufferedWriter(osw);

			new ClientThread().start();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		setLayout(new BorderLayout());
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.YELLOW);

		tf_msg=new JTextField(10);
		
		JButton sendBtn = new JButton("전송");
		sendBtn.setActionCommand("send");
		
		JButton resetBtn = new JButton("닉네임변경");
		resetBtn.setActionCommand("reset");

		panel.add(tf_msg);
		panel.add(sendBtn);
		panel.add(resetBtn);

		add(panel, BorderLayout.SOUTH);

		sendBtn.addActionListener(this);
		resetBtn.addActionListener(this);
		
		area = new JTextArea();
		area.setEditable(false);
		area.setBackground(Color.PINK);
		JScrollPane scroll = new JScrollPane(area,
				JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
				JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		add(scroll, BorderLayout.CENTER);
		
		tf_msg.addKeyListener(this);
		
	}
	
	
	
	public static void main(String[] args) {
		ClientMain2 f = new ClientMain2();
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
		}else if(str == "send"){
		sendMessage();

		}	
	}	
	public void sendMessage() {
		String msg = tf_msg.getText();
		
		try {

			bw.write(chatName+" : "+msg);
			bw.newLine();
			bw.flush();

			tf_msg.setText("");
		}catch(Exception e2) {
			e2.printStackTrace();
		}
		
	}
	

	public class ClientThread extends Thread{
		
		
		@Override
		public void run() {
			try {
				InputStream is = socket.getInputStream();
				InputStreamReader isr = new InputStreamReader(is);
				BufferedReader br = new BufferedReader(isr);
				while(true) {
					String msg = br.readLine();
					area.append(msg);
					area.append("\r\n");
					
					int docLength = area.getDocument().getLength();
					area.setCaretPosition(docLength);
					if(msg==null) {
						break;
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}		
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int code = e.getKeyCode();
		if(code == KeyEvent.VK_ENTER)
			sendMessage();
	}



	@Override
	public void keyReleased(KeyEvent e) {
		
	}



	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
