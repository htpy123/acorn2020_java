package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
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
public class MemoFrame_1 extends JFrame implements ActionListener,PropertyChangeListener{
	JTextField jtf;
	JTable table;
	DefaultTableModel model;
	
	
	
	public MemoFrame_1() {
		setLayout(new BorderLayout());
		
		jtf = new JTextField(10);
		JButton Select = new JButton("SELECT");
		Select.setActionCommand("select");
		Select.addActionListener(this);
		
		JButton Insert = new JButton("INSERT");
		Insert.setActionCommand("insert");
		Insert.addActionListener(this);
		
		JButton Update = new JButton("UPDATE");
		Update.setActionCommand("update");
		Update.addActionListener(this);
		
		JButton Delete = new JButton("DELETE");
		Delete.setActionCommand("delete");
		Delete.addActionListener(this);
		
		JButton Search = new JButton("SEARCH");
		Search.setActionCommand("search");
		Search.addActionListener(this);
		
		JPanel jp = new JPanel();
		
		jp.add(jtf);
		jp.add(Search);
		jp.add(Select);
		jp.add(Insert);
		jp.add(Update);
		jp.add(Delete);
		
		add(jp, BorderLayout.NORTH);
		
		table = new JTable();
		String[] colName = {"번호","콘텐츠","날짜"};
		model = new DefaultTableModel(colName, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				if(column==0||column==2) {
					return false;
				}
				return true;
			}
		};
		table.setModel(model);
		JScrollPane jscroll = new JScrollPane(table);
		add(jscroll, BorderLayout.CENTER);
		
		table.addPropertyChangeListener(this);
		displayMember();
		
		
	}
	public void displayMember() {
		
		model.setRowCount(0);
		
		List<MemberDto> list = select();
		for(MemberDto tmp : list) {
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
		}
	}
	
	public static void main(String[] args) {
		MemoFrame_1 f = new MemoFrame_1();
		f.setBounds(800, 300, 600, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String str = e.getActionCommand();
		if(str=="select") {
			displayMember();
		}else if(str=="insert") {
			insert();
		}else if(str=="delete") {
			delete();
		}else if(str=="search") {
			search();
		}else if(str=="update") {
			JOptionPane.showMessageDialog(this, "대충 더블클릭해서 변경하세요");
		}
	}
	//검색
	//검색
	//검색
	//검색
	//검색
	//검색
	//검색
	public void search() {
		List<MemberDto> list = select();
		model.setRowCount(0);
		for(MemberDto tmp : list) {
			if(jtf.getText().equals(tmp.getName())) {
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
			model.addRow(row);
			}
		}
	}
	//조회
	//조회
	//조회
	//조회
	//조회
	//조회
	//조회
	//조회
	//조회
	public List<MemberDto> select() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		ResultSet rs = null;
		List<MemberDto> list = new ArrayList<>();
		try {
			conn = new DBConnect().getConn();
			String sql = "SELECT num,content,TO_CHAR(regdate,'YYYY\"년\"MM\"월\"DD AM HH:MI') AS regdate"
					+" FROM memo ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String content = rs.getString("content");
				String regdate = rs.getString("regdate");
				
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(content);
				dto.setAddr(regdate);
				
				list.add(dto);
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	//추가
	//추가
	//추가
	//추가
	//추가
	//추가
	//추가
	public void insert() {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			String str = jtf.getText();
			conn = new DBConnect().getConn();
		
			String sql = "INSERT INTO memo"
					+" (num,content,regdate)"
					+" VALUES(memo_seq.NEXTVAL,?,SYSDATE)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, str);
			pstmt.executeUpdate();
			System.out.println("정보를 추가 했습니다");
			displayMember();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//삭제
	//삭제
	//삭제
	//삭제
	//삭제
	//삭제
	public void delete() {
		int selectedIndex = table.getSelectedRow();
		if(selectedIndex==-1) {
			return;	
		}
		int selection = JOptionPane.showConfirmDialog(this, "선택된 row 를 삭제 하겠습니까?");
		if(selection != JOptionPane.YES_OPTION) {
			return;
		}
	
		int num = (int)model.getValueAt(selectedIndex, 0);
	
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM memo"
					+" WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("정보를 삭제 했습니다");
			displayMember();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//수정
	//수정
	//수정
	//수정
	//수정
	//수정
	//수정
	public void update(MemberDto dto) {
		PreparedStatement pstmt = null;
		Connection conn = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "UPDATE memo"
					+" SET content=?"
					+" WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setInt(2, dto.getNum());
			pstmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	boolean isEditing=false;
	
//	@Override
//	public void propertyChange(PropertyChangeEvent evt) {
//		if(evt.getPropertyName().equals("tableCellEditor")) {
//			if(isEditing) {
//				int selectedNum = table.getSelectedRow();
//				String content = (String) table.getValueAt(selectedNum, 1);
//				
//				MemberDto dto = new MemberDto();
//				dto.setNum(selectedNum);
//				dto.setName(content);
//				
//				update(dto);
//				isEditing = false;
//				}
//			isEditing = true;
//		}
//	}
	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		if(evt.getPropertyName().equals("tableCellEditor")) {
			if(isEditing) {//수정중일때 
				//변화된 값을 읽어와서 DB 에 반영한다. 
				//수정된 칼럼에 있는 row  전체의 값을 읽어온다. 
				int selectedIndex=table.getSelectedRow();
				int num=(int)model.getValueAt(selectedIndex, 0);
				String content=(String)model.getValueAt(selectedIndex, 1);
				//수정할 회원의 정보를 MemoDto 객체에 담고 
				MemberDto dto=new MemberDto(num, content, null);
				//DB에 저장하기 
				update(dto);
				isEditing=false;//수정중이 아니라고 표시한다.
			}
			isEditing=true;//수정중이라 표시한다.
		}
	}
}
