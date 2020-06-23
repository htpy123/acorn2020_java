package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 문자열을 두번 입력 받는다.
		 * 	즉, 새로 추가할 이름과 주소를 입력 받아서
		 * 	MemberDao 객체를 이용해서 DB 에 저장하는 code 를 작성해 보세요
		 */
		Scanner scan = new Scanner(System.in);
		
		System.out.print("DB서버에 새로 추가할 이름을 입력해주세요 : ");
		String name = scan.nextLine();
		System.out.print("DB서버에 새로 추가할 주소를 입력해주세요 : ");
		String addr = scan.nextLine();
		
		MemberDto dto = new MemberDto();
		dto.setName(name);
		dto.setAddr(addr);
		
		MemberDao dao = MemberDao.getInstance();
		
		dao.insert(dto);

		
	}
}
