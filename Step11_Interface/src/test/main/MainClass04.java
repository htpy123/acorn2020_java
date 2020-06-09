package test.main;

import test.mypac.Drill;

public class MainClass04 {
	public static void main(String[] args) {
		useDrill(new Drill() {
			@Override
			public void hole() {
				System.out.println("바닥에 구멍을 뚫어요");
			}
		});
		//메소드 하나니깐 메소드명 쓸필요없다.
		Drill d1 = () -> {
			System.out.println("벽에 20mm 의 구멍내기");
		};
		useDrill(d1);     //function(){} javascript였다면 이런느낌 useDrill(function(){});
		useDrill(()->{
			System.out.println("핸드폰에 1mm 구멍내기");
		}); //interface가 메소드 하나 인경우 사용할수 있는 문법
	}
	
	public static void useDrill(Drill d) {
		d.hole();
	}
}
