package test.main;

import test.mypac.Apple;
import test.mypac.Banana;
import test.mypac.FruitBox;
import test.mypac.Orange;

public class MainClass02 {
	public static void main(String[] args) {
		//객체를 생성할때 Generic 클래스는 생략이 가능하다
//		new FruitBox<>(); // <>안에 값은 생략가능하다 단, 참조값을 담는 변수의 타입에는 필요하다(받을때만 잘받으면된다)
		FruitBox<Apple> box1 = new FruitBox<>();
		FruitBox<Orange> box2 = new FruitBox<>();
		FruitBox<Banana> box3 = new FruitBox<>();
		
//		new FruitBox<>().push //바로 사용하는 경우에는 Object로 나온다. 이 경우에는 지정해주는게 좋다
		
	}
}
