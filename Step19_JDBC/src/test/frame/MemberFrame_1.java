package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MemberFrame_1 extends JFrame implements ActionListener{
	//필드
	JTextField inputName, inputAddr;
	DefaultTableModel model;
	JTable table;
	//생성자
	public MemberFrame_1() {
		setLayout(new BorderLayout());
		
		JLabel label1 = new JLabel("이름");
		inputName = new JTextField(10);
		JLabel label2 = new JLabel("주소");
		inputAddr = new JTextField(10);
		
		JButton saveBtn = new JButton("저장");
		saveBtn.setActionCommand("save");
		saveBtn.addActionListener(this);
		
		JButton deleteBtn = new JButton("삭제");
		deleteBtn.setActionCommand("delete");
		deleteBtn.addActionListener(this);
		
		
		JPanel panel = new JPanel();
		panel.add(label1);
		panel.add(inputName);
		panel.add(label2);
		panel.add(inputAddr);
		panel.add(saveBtn);
		panel.add(deleteBtn);

		JPanel panel1 = new JPanel();
		
		add(panel, BorderLayout.NORTH);
		
		//표형식으로 정보를 출력하기 위한 JTable
		table = new JTable();
		//칼럼명을 String[] 에 순서대로 준비
		String[] colNames = {"번호","이름","주소"};
		//테이블에 출력할 정보를 가지고 있는 모델 객체 (칼럼명, row 갯수)
		model = new DefaultTableModel(colNames, 0);
		//모델을 테이블에 연결한다.
		table.setModel(model);
		//스크롤이 가능 하도록
		JScrollPane scroll = new JScrollPane(table);
		//JScrollPane 을 프레임의 가운데에 배치하기
		add(scroll, BorderLayout.CENTER);
		
		//JTable 에 sample 데이터 출력해보기
		
//		Object[] row1 = {1, "김구라", "노량진"};
//		Object[] row2 = {2, "해골", "행신동"};
//		model.addRow(row1);
//		model.addRow(row2);
		//테이블에 회원 목록 출력하기 2
		displayMember();
		
		
	}
	//테이블에 회원 목록을 출력하는 메소드
	public void displayMember() {
		//row 의 갯수를 강제로 0으로 지정해서 삭제 한다.(테이블 초기화)
		model.setRowCount(0);
		//회원 목록을 얻어와서
		MemberDao dao = MemberDao.getInstance();
		List<MemberDto> list = dao.getList();
		for(MemberDto tmp : list) {
			//MemberDto 객체에 저장된 정보를 object[] 객체에 순서대로 담는다.
			Object[] row = {tmp.getNum(), tmp.getName(), tmp.getAddr()};
//			Object[] row = {1, "김구라", "노량진"};
			model.addRow(row);
		}
	}
	
	//main 메소드
	public static void main(String[] args) {
		MemberFrame_1 f = new MemberFrame_1();		
		f.setBounds(100, 100, 800, 500);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//액션 command 읽어오기
		String command = e.getActionCommand();
		if(command.equals("save")) {
			//입력한 문자열 읽어와서
			String name = inputName.getText();
			String addr = inputAddr.getText();
			//MemberDto 객체에 담아서
			MemberDto dto = new MemberDto();
			dto.setName(name);
			dto.setAddr(addr);
			
			//MemberDao 객체를 이용해서 DB에 저장
			MemberDao dao = MemberDao.getInstance();
			boolean isSuccess = dao.insert(dto);
			
			Object[] row1 = {dto.getNum(), dto.getName(), dto.getAddr()};
			model.addRow(row1);
			if(isSuccess) {
				JOptionPane.showMessageDialog(this, name+" 님의 정보 추가 했습니다");
			}else {
				JOptionPane.showMessageDialog(this, "추가 실패!!!");
			}
			
			//JTable 에 목록 다시 출력하기
			displayMember();
			
		}else if(command.equals("delete")) {
			int num = table.getSelectedRow();
			if(num==-1) {
				return;
			}
			int n = (int)model.getValueAt(num, 0);
			MemberDao dao = MemberDao.getInstance();
			dao.delete(n);
			displayMember();
			System.out.println(n);
			
		}
	}
}
