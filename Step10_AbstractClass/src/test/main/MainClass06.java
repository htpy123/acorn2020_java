package test.main;

import test.mypac.Weapon;
public class MainClass06 {
	//static inner class 로 Weapon 추상 클래스 상속 받기
	public static class Magic extends Weapon{
		@Override
		public void attack() {
			System.out.println("화려한 마법 공격");
		}	
	}



	public static void main(String[] args) {
		/*
		 * useWeapon() 메소드를 호출하는게 목적이다.
		 * 호출하려고 보니 Weapon 추상 클래스 type 객체의 참조값이 필요하다
		 * 따라서 Weapon 추상 클래스를 상속받은 클래스를 파일로 만들어야 된다.
		 * 근데 불금이다보니 만사가 귀찮다. 클래스를 파일로 만들기 싫다
		 * 내부 클래스(inner class) 로 만들고 싶다.
		 */
		Weapon w1 = new Magic();
		MainClass06.useWeapon(w1);
		
		//local inner class 도 이용해 보자
		class OurWeapon extends Weapon{
			@Override
			public void attack() {
				System.out.println("아군이다 사격중지!");
			}
			public void fly() {
				System.out.println("날아 다녀요");
			}
		}
		OurWeapon w2 = new OurWeapon();  //fly method를 이용하기 위해 OurWeapon 설명서 사용
//		Weapon w2 = new OurWeapon();
		useWeapon(w2);
		w2.fly();  // OurWeapon()을 사용해야 fly사용가능
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
