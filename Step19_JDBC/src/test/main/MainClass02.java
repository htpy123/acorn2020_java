package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class MainClass02 {
	public static void main(String[] args) {
		/*
		 * 	member 테이블에 추가할 회원의 정보
		 * 	1, 김구라, 노량진
		 */
		int num=1;
		String name = "김구라";
		String addr = "노량진";
		//DB 연결객체를 담을 지역변수 만들기
		Connection conn = null;
		
		try {
			//오라클 드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB의 정보 @아이피주소 : port번호 : db이름
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			//계정 비밀번호를 이용해서 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");
			//예외가 발생하지 않고 여기까지 실행순서가 내려오면 접속 성공이다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
		//필요한 객체의 참조값을 담을 빈 지역 변수 미리 만들기
		PreparedStatement pstmt = null;
		try {
			//실행할 sql 문
			String sql = "INSERT INTO member"
					+" (num,name,addr)"
					+" VALUES(?, ?, ?)";//미완성인 sql문을 일단 preparedStatement 에 담은다음에
			
			//PreparedStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//? 에 값을 바인딩해서 미완성의 sql 문을 완성 시킨다.
			pstmt.setInt(1, num);
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
			//실제로 수행하고 변경(추가) 된 row 의 갯수를 리턴 받는다
			pstmt.executeUpdate();
			System.out.println("회원 정보를 저장했습니다");
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally{
			try {
				//안전하게 마무리 작업하기
				if(pstmt!=null)pstmt.close();
			}catch(Exception e) {}
		}
	}
}
