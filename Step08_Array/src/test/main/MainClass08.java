package test.main;

import java.util.Random;
import java.util.Scanner;

import test.mypac.MainClass08_random;

/*
 * 	1. 	cherry, apple, banana, melon, 7
 *  	5개의 문자열중에서 하나가 랜덤하게 출력되게 해 보세요.
 * 
 * 	2.	5개읠 문자열 중에서 3개가 한줄에 한번에 랜덤하게 출력되게 해 보세요
 * 		예)	cherry | apple | cherry
 * 			   7   | apple | melon
 * 			   7   |   7   |   7
 */

public class MainClass08 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		MainClass08_random rD = new MainClass08_random();
		
		String[] str = {"cherry", "apple ", "banana", "melon ", "  7   "};
		
		Random ran = new Random();
		int a = ran.nextInt(101);
		System.out.println(str[rD.returnNum(a)]);
		while(true) {
			System.out.println("=======빠칭코=======");
			System.out.println("1. 빠칭코 슬롯 내리기(Enter)");
			System.out.println("2. 빠칭코 끝내기(q)");
			System.out.print("선택해주세요 : ");
			String b = scan.nextLine();
			if(b.equals("")||b.equals("Enter")) {
				rD.prinT(str);
			}if(b.equals("q")) {
				System.out.println("====빠칭코를 종료합니다====");
				break;
			}
		}
	
	}
}
