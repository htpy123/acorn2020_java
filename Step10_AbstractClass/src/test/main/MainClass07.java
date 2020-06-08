package test.main;

import test.mypac.Weapon;
public class MainClass07 {

	//run 했을때 실행순서가 시작되는 특별한 main 메소드
	public static void main(String[] args) {
		/*
		 *  Weapon 추상 클래스를 상속받은 익명의 local inner class
		 *  의 생성자를 호출해서 Weapon type 의 참조값 얻어내기
		 */
//		useWeapon(new Weapon()); 추상클래스 타입이기 때문에 new Weapon()으로 단독 생성 불가
		Weapon w1=new Weapon() {

			@Override
			public void attack() {
				System.out.println("아무나 공격해요!");
			}
			
		};
//		Weapon w2 = new Weapon Ctrl + space 하면 anonymous 생성가능
		Weapon w2 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("공중 공격을 해요!");
			}
		};
		
		useWeapon(w1);
		useWeapon(w2);
		useWeapon(new Weapon() {
			//1회용 객체 생성
			@Override
			public void attack() {
				System.out.println("1회용 공격");
			}
		});
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
