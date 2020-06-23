package test.main;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass13 {
	public static void main(String[] args) {
		/*
		 * 	MemberDao 객체를 이용해서 회원 목록을 얻어와서
		 * 	아래와 같은 형식으로 출력해 보세요.
		 * 	
		 * 	1 | 김구라 | 노량진
		 * 	2 | 원숭이 | 상도동
		 *  3 | 주뎅이 | 봉천동
		 *  .
		 *  .
		 */

		//MemberDao 객체의 참조값 얻어오기
		MemberDao dao = MemberDao.getInstance();
		//MemberDao 객체의 메소드를 이용해서 회원목록 얻어오기
		List<MemberDto> list = dao.getList();
		//반복문 돌면서 원하는 형식으로 출력하기
		for(int i=0; i<list.size();i++) {
			MemberDto tmp = list.get(i);
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
		System.out.println("-----------------");
		for(MemberDto tmp : list) {
			System.out.println(tmp.getNum()+" | "+tmp.getName()+" | "+tmp.getAddr());
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		List<MemberDto> list = new ArrayList<>();
//		Connection conn = new DBConnet();
//		preparedStatement pstmtm = null;
//		ResultSet rs = null;
//		try {
//			String sql = "SELECT * FROM member"
//					+" ORDER BY num ASC";
//			pstmt = conn.prepareStatement(sql);
//			rs = pstmt.executeQurey();
//			MemberDto dto = new MemberDto();
//			while(rs.next()) {
//				int num = rs.getInt("num");
//				String name = rs.getString("name");
//				String addr = rs.getString("addr");
//				
//				dto.setNum(num);
//				dto.setName(name);
//				dto.setAddr(addr);
//				
//				list.add(dto);
//				
//				System.out.println(num+" | "+name+" | "+addr);
//			}
//			
//		}catch(Exception e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(pstmt!=null)pstmt.close();
//			}catch(Exception e) {
//				e.printStackTrace();
//			}
//		}
		
		
		
		
	}
}
