package test.main;

import java.util.Scanner;
/*
 * 	RuntimeException 을 상속 받은 Exception 종류는
 * 	try ~ catch 블럭으로 묶어 주지 않아도 문법 오류가 발생하지 않는다
 */
public class MainClass02 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		
		System.out.println("나눌수 입력 : ");
		String inputNum1 = scan.nextLine();
		System.out.println("나누어 지는 수 입력 : ");
		String inputNum2 = scan.nextLine();
		try {
			int num1 = Integer.parseInt(inputNum1);
			int num2 = Integer.parseInt(inputNum2);
			try {
				int result = num2/num1;
				System.out.println(num2+" 를 "+num1+" 으로 나누면 : "+result);
			}catch(ArithmeticException ae) {  //int(정수) 형일때 0으로 나누면 ArithmeticExcetion 에러 발생
				System.out.println("0으로 나눌수 없습니다");
			}
			
		}catch(NumberFormatException nfe) {
			System.out.println("숫자의 형식으로 값을 입력해주세요.");
		}finally{//예외가 발생 하던 안하던 반드시 실행이 보장되는 블럭
			System.out.println("무언가 마무리 작업을 해요~");
		}
		System.out.println("main 메소드가 정상 종료 됩니다");
	}
}
