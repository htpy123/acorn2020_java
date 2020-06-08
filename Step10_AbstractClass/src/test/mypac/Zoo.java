package test.mypac;

//동물원 클래스
public class Zoo {
	
	//클래스 안에 클래스(내부                                                                                         클래스)
	public class Monkey{
		public void say() {
			System.out.println("우끼끼");
		}
	}
	//내부 클래스
	public class Tiger{
		public void say() {
			System.out.println("야옹!");
			System.out.println("Tiger는 우렁차게 울부짖었다");
		}
	}
	//메소드
	public Monkey getMonkey() {
		return new Monkey();
	}
	public Tiger getTiger() {
		return new Tiger();
	}
}
