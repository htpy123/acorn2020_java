package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass02 {
	//필드에 Remocon type
//	Remocon r3 = null; //field에 선언
	static Remocon r3 = new Remocon() {
		@Override
		public void up() {
			System.out.println("물건을 올려요");
		}
		@Override
		public void down() {
			System.out.println("물건을 내려요");	
		}
	};
	
	public static void main(String[] args) {
		/*
		 *  Remocon 인터페이스를 구현한 익명의 local inner class의 생성자를 호출해서
		 *  참조값을 얻어내서 Remocon type 의 지역변수 r1 에 대입하기
		 */
		Remocon r1 = new Remocon() { //new 한게 interface라면 자동으로 implements 함 class ? implements Remocon{ }
			@Override
			public void up() {
				System.out.println("볼륨을 올려요");
			}
			@Override
			public void down() {
				System.out.println("볼륨을 내려요");
			}
		};
		useRemocon(r1);
		useRemocon(new Remocon() { //익명성 클래스  interface라면 class ? implements Remocon{ }  그냥 일반 클래스나 extends라면 class ? extends Remocon{ }으로 자동 부여
			@Override
			public void up() {
				System.out.println("1회성 올리기");
			}
			@Override
			public void down() {
				System.out.println("1회성 내리기");
			}
		});
		useRemocon(r3);
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
