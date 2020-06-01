package test.main;

import test.mypac.Car;
import test.mypac.MyObject;
import test.mypac.Radio;
import test.mypac.Speaker;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 *  test.mypac 패키지에 다양한 모양의 메소드를 가지는
		 *  클래스를 정의하고
		 *  그 클래스를 이용해서 객체도 생성하고 메소드도 호출해 보세요.
		 */
		int num = 10;
		Radio radio = new Radio();
		MyObject obj1 = new MyObject();
		obj1.allSome(num, "티코", new Car(), radio, new Speaker());
		obj1.doSome(radio, new Speaker());
	}
}
