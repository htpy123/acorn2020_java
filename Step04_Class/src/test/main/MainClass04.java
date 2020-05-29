package test.main;

import test.mypac.Member;

public class MainClass04 {
	public static void main(String[] args) {
		/*
		 * 1, 김구라, 노량진
		 * 
		 * 이라는 int, String, String type 의 값을
		 * 
		 * 객체의 필드에 저장하는 프로그래밍을 해보세요.
		 * 
		 * 단 객체를 생성할 클래스의 이름은 Member 로 작성하세요.
		 */
		
		Member mem1 = new Member();
		mem1.number=1;
		mem1.name="김구라";
		mem1.addr="노량진";
		
		Member mem2 = new Member();
		mem2.number=2;
		mem2.name="해골";
		mem2.addr="상도동";
		
		System.out.println("Member table \n번호: "+mem1.number+"\n이름 : "+mem1.name+"\n주소 : "+mem1.addr+"\n");
		System.out.println("Member table \n번호: "+mem2.number+"\n이름 : "+mem2.name+"\n주소 : "+mem2.addr+"\n");
		
		mem1.Members(3,"하하","호호");
		mem1.Members(4, "흐흐", "히히");
	}
}
