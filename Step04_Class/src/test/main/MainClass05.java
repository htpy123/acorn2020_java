package test.main;

import test.mypac.Rect;

public class MainClass05 {
	public static void main(String[] args) {
		Rect r1 = new Rect();
		r1.width=10;
		r1.height=20;
		int a = r1.getArea();
		System.out.println(a);
		
		Rect r2 = new Rect();
		r2.width = 5;
		r2.height = 10;
		int b = r2.getArea();
		System.out.println(b);
	}
}
