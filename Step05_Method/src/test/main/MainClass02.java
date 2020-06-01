package test.main;

import test.mypac.Car;
import test.mypac.MyObject;

public class MainClass02 {
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
//		type은 Car로 같지만 a,b,c 객체에 각각 다른 id값이 들어가있다.
		Car a = obj1.getCar();
		Car b = obj1.getCar();
		Car c = obj1.getCar();
		
		//지역변수에 담긴 객체 사용하기
		a.drive();
		b.drive();
		c.drive();
	}
}
