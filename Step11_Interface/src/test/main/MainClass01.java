package test.main;

import test.mypac.MyRemocon;
import test.mypac.Remocon;

public class MainClass01 {
	public static void main(String[] args) {
		//인터페이스 type(부모 type)
		Remocon r1 = new MyRemocon();
		//원래 class type 
		MyRemocon r2 = new MyRemocon();
		
//		Remocon r1 = new Remocon(); Remocon 단독으로는 생성 불가
//		r1. 메소드 모양은 완벽해서 Remocon 내에 기능 사용가능 하지만 기능이 정의되지 않음 일단 data type의 역활은 가능하다정도  
		useRemocon(r1);
		useRemocon(r2);
	}
	public static void useRemocon(Remocon r) {
		r.up();
		r.down();
	}
}
