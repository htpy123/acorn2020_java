package test.mypac;

public class Member {
	//non static 필드 정의하기
	public int number;
	public String name;
	public String addr;
	public void Members(int a,String b, String c) {
		System.out.println("Member table \n번호: "+a+"\n이름 : "+b+"\n주소 : "+c+"\n");
	};
	
	//non static 메소드 정의하기
	public void showInfo() {
		String name="원숭이";
		System.out.println(this.number+"|"+this.name+"|"+this.addr);
		System.out.println(number+"|"+name+"|"+addr);
	};
};
