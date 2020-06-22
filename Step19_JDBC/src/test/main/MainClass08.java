package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass08 {
	public static void main(String[] args) {
		//추가할 회원의 정보
		String name = "주뎅이";
		String addr = "봉천동";
		//아래의 insert() 메소드를 호출해서 회원 한명의 정보가 추가 되도록 해 보세요.
		
		//추가할 회원의 정보를 MemberDto 객체에 담고
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		insert(dto);
	};
	//MemberDto 객체를 인자로 전달 받아서 회원정보를 DB에 저장하는 메소드
	public static void insert(MemberDto dto) {
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
}
