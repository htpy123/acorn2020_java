package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import test.dto.MemberDto;
import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 	member 테이블에 저장된 모든 회원의 정보를
		 * 	번호에 대해서 오름차순 정렬해서 
		 * 	List<memberDto> 객체에 담아 오려고 한다.
		 */
		List<MemberDto> list = new ArrayList<>();
		
		PreparedStatement pstmt = null;
		Connection conn = new DBConnect().getConn();
		ResultSet rs=null;
		
		try {
			String sql ="SELECT * FROM member"
					+" ORDER BY num ASC";
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			while(rs.next()) {
				int num = rs.getInt("num");
				String name = rs.getString("name");
				String addr = rs.getString("addr");
				
				MemberDto dto = new MemberDto();
				dto.setNum(num);
				dto.setName(name);
				dto.setAddr(addr);
				
				list.add(dto);
				System.out.println(num +" | "+name+" | "+addr);
			}
			
//			System.out.println(list.get(1).getName());
			
			
			
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				//객체를 사용했던 순서 역순으로 닫아준다.
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}
	//회원목록을 콘솔창에 출력해주는 메소드
	public static void printMember(List<MemberDto> list) {
		for(MemberDto tmp : list) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());

		}
		//		System.out.println(rs.getInt("num")+" | "+rs.getString("name")+" | "+rs.getString("addr"));

	}
}
