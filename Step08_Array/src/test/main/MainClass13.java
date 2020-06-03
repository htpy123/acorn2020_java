package test.main;

import java.util.Random;
import java.util.Scanner;

/*
 * 	[ 컴퓨터와 가위 바위 보 하기 ]
 * 
 * 	가위(s) 바위(r) 보(p) :s
 * 
 * 	나 : 가위 vs 컴 : 보
 *  win(draw or lose)
 */
public class MainClass13 {
	public static void main(String[] args) {
		//가위 바위 보 문자열을 일단 배열에 담아보자
		String[] items = {"가위", "바위", "보"};
		//사용자 입력을 받아야 하니 Scanner 객체를 생성한다.
		Scanner scan = new Scanner(System.in);
		//컴퓨터가 랜덤하게 가위,바위,보를 정해야 하니 Random 객체를 생성한다.
		Random ran = new Random();
		
		while(true) {
			System.out.println("[ 컴퓨터와 가위 바위 보 !!! ]");
			System.out.println("[그만하시려면 q를 입력하세요 ]");
			String[] str = {"s","r","p"};			
			System.out.println("[가위(S)] [바위(R)] [보(P)]");
			System.out.println("가위 바위 보 중에 하나를 입력하세요");
			System.out.print("입력 : ");
			
			String sr = scan.nextLine();
			int myNum=0;
			int comNum = ran.nextInt(3);
		
			if(sr.equals("s")||sr.equals("S")) {
				myNum=0;
			}else if(sr.equals("r")||sr.equals("R")) {
				myNum=1;
			}else if(sr.equals("p")||sr.equals("P")) {
				myNum=2;
			}
			
			String result = "";
			if((myNum==0&&comNum==2)||(myNum==1&&comNum==0)||(myNum==2&&comNum==1)) {
				result="Win";
			}else if(myNum==comNum) {
				result="Draw";
			}else {
				result="Lose";
			}
			System.out.println("나 : "+items[myNum]+" VS 컴 : "+items[comNum]);
			System.out.println(result);
			
			
			if(sr.equals("q")) {
				System.out.println("[ 컴퓨터와 가위 바위 보 를 종료합니다 ]");
				break;
			}
		}
	}
}

