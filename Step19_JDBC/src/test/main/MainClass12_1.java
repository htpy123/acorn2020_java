package test.main;

import java.util.Scanner;

import test.dao.MemberDao;
import test.dto.MemberDto;

public class MainClass12_1 {
	public static void main(String[] args) {
		/*
		 * 	Scanner 객체를 이용해서 문자열을 두번 입력 받는다.
		 * 	즉, 새로 추가할 이름과 주소를 입력 받아서
		 * 	MemberDao 객체를 이용해서 DB 에 저장하는 code 를 작성해 보세요
		 */
		Scanner scan = new Scanner(System.in);

		System.out.println("oneLine, allLine, select, delete, update");
		String str = scan.nextLine();
		
			
		
		MemberDao dao = MemberDao.getInstance();
		MemberDto dto = new MemberDto();
		

		if(str=="oneSelect") {
			
		}else if(str=="select") {
			
		}else if(str=="update") {
			
		}else if(str=="delete") {
			System.out.print("삭제할 row의 번호를 입력해주세요 : ");
			int num = scan.nextInt();
			dao.delete(num);
			
		}else if(str=="insert") {
			System.out.print("DB서버에 새로 추가할 이름을 입력해주세요 : ");
			String name = scan.nextLine();
			System.out.print("DB서버에 새로 추가할 주소를 입력해주세요 : ");
			String addr = scan.nextLine();
			
			
			dto.setName(name);
			dto.setAddr(addr);
			
			dao.insert(dto);
		}else {
			System.out.println("잘못입력");
		}
	}
}
