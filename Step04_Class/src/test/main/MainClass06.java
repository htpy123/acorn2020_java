package test.main;

import test.mypac.Box;
import test.mypac.Car;
import test.mypac.Member;
import test.mypac.Rect;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작 되었습니다");
		Member a = Box.mem; //null
		Rect b = Box.rect;  //null
		Car c = Box.car;    //car 참조
		c.drive();
		
		//아래와 같이 사용할수도 있다.
		Box.car.drive();
		System.out.println();
//		a.showInfo(); //a가 null 이므로 NullPointerException 발생
		b.getArea();
	}
}
