package rosic;

import java.util.Scanner;

import rosic.pac.Gugudan;

public class Sample02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.print("0~9사이 숫자를 입력해 주세요 :");
		int num = scan.nextInt();
		new Gugudan(num);
	}
}
