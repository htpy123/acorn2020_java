package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		Connection conn = new DBConnect().getConn();;

		PreparedStatement pstmt = null;
		int num = 4;
		try {
			String sql = "DELETE FROM member"
					+" WHERE num = ?";
			
			pstmt=conn.prepareStatement(sql);
			pstmt.setInt(1, num);
			pstmt.executeUpdate();
			
			System.out.println("회원정보 변경 완료");
			
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
