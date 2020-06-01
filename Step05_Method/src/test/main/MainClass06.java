package test.main;

import test.mypac.Car;
import test.mypac.Messenger;

public class MainClass06 {
	public static void main(String[] args) {
		//Messenger 클래스의 static 메소드 3개를 하나씩 호출해 보세요.
		Messenger.sendMessage("메시지");
		String str = Messenger.getMessage();
		System.out.println(str);
//		System.out.println(Messenger.getMessage());
		Messenger.useCar(new Car());
	}
}
