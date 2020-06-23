package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass09_1{
	public static void main(String[] args) {
		int num = 1;
		String name = "이정호";
		String addr = "독산동";
		MemberDto dto = new MemberDto();
		dto.setNum(num);
		dto.setName(name);
		dto.setAddr(addr);
		
		update(dto);
		
	}
	public static void update(MemberDto dto) {
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
			
			System.out.println("회원정보가 업데이트 되었습니다");
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