package test.main;

import test.human.Blood;
import test.human.Woman;

public class MainClass12 {
	public static void main(String[] args) {
		/*
		 *  프로그래밍의 목적 : 독서를 하고 싶다
		 *  독서하는 프로그래밍을 해 보세요.
		 */
		//1번째 패턴
		Woman wm = new Woman(new Blood("a","a"));
		wm.reading();
		//2번째 패턴
		Blood b1 = new Blood("a","a");
		Woman wm1 = new Woman(b1);
		wm1.reading();

	}
	
}
