package test.main;

import test.mypac.Weapon;
public class MainClass08 {
	//클래스의 필드에 Weapon type 의 참조값 넣어두기
//	static Weapon w1 = null; //static을 붙여야 static 영역에서 사용 가능
						 	 //null값을 넣으면 NullPointerExcetion 에러 발생
	static Weapon w1 = new Weapon() {
		@Override
		public void attack() {
			System.out.println("필드 공격");	//이름은 없지만 Weapon 클래스를 상속받은 클래스이다.   class ? extends Weapon{ }
		}									//anonymous inner class
	};
	
	
	public static void main(String[] args) {
		//필드에 저장된 Weapon type 의 참조값을 이용해서 useWeapon() 메소드 호출하기
		useWeapon(w1); //필드에 static 을 붙여줘야 호출가능
	}
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
