package test.main;

import test.mypac.MyWeapon;
import test.mypac.Sword;
import test.mypac.Weapon;

public class MainClass02 {
	public static void main(String[] args) {
		//여러분이 직접 클래스를 만들고 객체 생성을 해서
		//아래 useWeapon() 메소드를 호출해 보세요
		Weapon w = new MyWeapon();
		useWeapon(w);
		Weapon S = new Sword();
		useWeapon(S);
	}
	
	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
