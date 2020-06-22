package test.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

/*
 * 	DAO (Data Access Object) 의 약자
 * 
 * 	- 만드는 방법
 * 
 * 	1. 외부에서 객체 생성하지 못하도록 생성자의 접근지정자를 private로 지정
 * 	2. 자신의 참조값을 저장할수 있는 필드를 private 로 선언
 * 	3. 자신의 참조값을 오직 하나만 생성해서 리턴해주는 static 메소드 만들기
 * 	4. 나머지 기능(select, insert, update, delete)들은 non static 으로 만들기
 * 	
 */
public class MemberDao {
	//자신의 참조값을 저장할 private 필드
	private static MemberDao dao;
	
	//외부에서 객체 생성하지 못하도록 한다.
	private MemberDao() {}
	
	//참조값을 리턴해주는 메소드
	public static MemberDao getInstance() {
		if(dao==null) {	//최초 호출되면 null 이므로
			dao=new MemberDao();	//객체를 생성해서 static 필드에 담는다
		}
		return dao;
	}
	//회원 한명의 정보를 리턴해주는 메소드
	public MemberDto getData(int num) {
		Connection conn = new DBConnect().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MemberDto dto = new MemberDto();
		try {
			String sql = "SELECT name,addr"
					+" FROM member"
					+" WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				
				System.out.println(num+" | "+rs.getString("name")+" | "+rs.getString("addr"));
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	//회원 목록을 리턴해주는 메소드
	public List<MemberDto> getList(){
		List<MemberDto> list = new ArrayList<>();
		Connection conn = new DBConnect().getConn();
		PreparedStatement pstmt = null;
		ResultSet rs= null;
		try {
			String sql = "SELECT num,name,addr"
					+" FROM member"
					+" ORDER BY num ASC";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			MemberDto dto = new MemberDto();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
				list.add(dto);
				
				System.out.println(num+" | "+name+" | "+addr);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	//회원 한명의 정보를 DB에서 삭제하는 메소드
	public void delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		try {
			conn = new DBConnect().getConn();
			String sql = "DELETE FROM member"
					+" WHERE num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			System.out.println("회원 정보 삭제");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//회원 정보를 DB에 저장하는 메소드
	public void insert(MemberDto dto) {
		PreparedStatement pstmt = null;
		Connection conn = new DBConnect().getConn();;
		
		try {
			String sql = "INSERT INTO member"
					+" (num, name, addr)"
					+" VALUES(member_seq.NEXTVAL, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.executeUpdate();
			
			System.out.println("회원정보 추가 완료");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	//회원 정보를 DB에서 수정하는 메소드
	public void update(MemberDto dto) {
		PreparedStatement pstmt = null;
		Connection conn = new DBConnect().getConn();
		try {
			String sql = "UPDATE member"
					+" SET name = ?, addr = ?"
					+" WHERE num = ?";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			
			pstmt.executeUpdate();
			
			System.out.println("회원정보 수정 완료");
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
}
