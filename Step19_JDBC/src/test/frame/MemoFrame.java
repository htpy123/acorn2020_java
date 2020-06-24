package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;
import test.util.DBConnect;


/*
 * 	CREATE TABLE MEMO
 * 	(num NUMBER PRIMARY KEY,
 * 	 content VARCHAR2(30),
 * 	 regdate DATE);
 * 
 * 	CREATE SEQUENCE MEMO_SEQ;
 * 
 * 	위와 같이 테이블과 시퀀스를 만들고 해당 테이블에 데이터를
 * 	SELECT, INSERT, UPDATE, DELETE 기능을 수행할수 있는 MemoFrame 을 만들어 보세요.
 * 
 * 	조건
 * 	1. num 칼럼은 시퀀스를 이용해서 넣으세요.
 * 	2. regdate 칼럼(등록일)의 값은 SYSDATE 를 이용해서 넣으세요.
 * 	3. 수정은 content 만 수정 가능하게 하세요.
 * 	4. MemoDto, MemoDao 를 만들어서 프로그래밍 하세요.
 */
public class MemoFrame extends JFrame implements ActionListener{
	
	public MemoFrame() {
		
	}
	
	public static void main(String[] args) {
		
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}
	
}