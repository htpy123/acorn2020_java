package test.main;

import test.mypac.Car;
import test.mypac.MyObject;

public class MainClass03 {
	public static void main(String[] args) {
		MyObject obj1 = new MyObject();
		// .setNum(), .setName(), .useCar() 메소드를 호출해 보세요.
		obj1.setNum(10);
		obj1.setName(null);
		obj1.useCar(new Car());
		
		
//		Car car = new Car();
//		
//		obj1.setNum(10);
//		obj1.setName("이름");
//		obj1.useCar(obj1.getCar());
//		obj1.useCar(car);
	}
}
