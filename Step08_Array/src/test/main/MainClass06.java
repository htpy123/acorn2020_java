package test.main;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

import test.mypac.MainClass06_lotto;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 *  1. Scanner 객체를 이용해서 문자열을 5번 입력 받는다
		 *     입력 받은 문자열은 차례대로 배열에 저장되어야 한다
		 *     모두다 입력 받은 후 for 문을 이용해서 배열에 저장된
		 *     모든 문자열을 콘솔창에 순서대로 출력하는 코드를 작성해 보세요
		 *     
		 *     
		 *     //Scanner 객체를 생성해서 참조값을 지역 변수에 담기
		 *     Scanner scan = new Scanner(System.in);
		 *     //문자열(String)) 5개를 담을수 있는 배열 객체 생성해서 참조값을 지역변수에 담기
		 *     String[] msgs = new String[5];
		 *     
		 *     //5번 문자열 입력 받기 위해 for 문을 구성한다.
		 *     for(int i=0;i<5;i++){
		 *     		System.out.println("문자열 입력 :");
		 *     		String str = scan.nextLine();
		 *     		//입력받은 문자열의 참조값을 배열에 순서대로 저장하기		
		 *     		msgs[i]=str;
		 *     }
		 *     
		 *     
		 *     for(int i=0;i<msgs.length;i++){
		 *     		//i번째 방에 있는 String 객체의 참조값을 불러온다.
		 *     		String tmp = msgs[i];
		 *     		//콘솔에 출력한다.
		 *     		System.out.println(tmp);
		 *     }
		 */
		
		
		Scanner scan = new Scanner(System.in);
		String[] str = new String[5];
		System.out.println("문자열을 5번 입력해주세요");
		for(int i=0;i<5;i++){
			System.out.print((i+1)+"번 문자열을 입력해주세요 :");
			str[i] = scan.nextLine();
		}
		System.out.println("===입력하신 문자열을 모두 출력해 드리겠습니다===");
		for(int i=0;i<5;i++) {
			System.out.println((i+1)+"번째로 작성하신 문자열은 : "+str[i]+" 입니다");
		}
		
		
		/*
		 *  2. Random 객체를 이용해서 로또 번호를 6개 랜덤하게 얻어내서
		 *     배열에 저장한다.
		 *     모두다 저장이 되면 for 문을 이용해서 배열에 저장된 모든 로또 번호를
		 *     콘솔창에 순서대로 출력하는 코드를 작성해 보세요.
		 *     
		 *     
		 *     강사님 코드는 MainClass07에
		 */
		System.out.println("!!!이번주 로또 번호!!!");
		Random ran = new Random();
		int[] lottoNum = new int[6];
		
		MainClass06_lotto toto = new MainClass06_lotto();
		toto.lottoTmp(lottoNum);
		
		Arrays.sort(lottoNum);
		
		for(int i=0;i<lottoNum.length;i++)
			System.out.print(lottoNum[i]+" ");
		int lottoBonus = ran.nextInt(45)+1;
		System.out.println(" + 보너스 번호  "+lottoBonus);
		
		
		
		
		
		
//		for(int i=0;i<lottoNum.length;i++) {
//			lottoNum[i] = ran.nextInt(45)+1;
//		}
//		
//		for(int i=0;i<lottoNum.length;i++) {
//			for(int j=0;j<lottoNum.length;j++) {
//				if(lottoNum[i]==lottoNum[j]) {
//					lottoNum[j] = ran.nextInt(45)+1;
//				}
//			}
//		}
//		  MainClass06_lotto toto = new MainClass06_lotto();
//		  toto.lottoTmp(lottoNum);
//		    위에 두줄 코딩으로  Main클래스의 코드량을 줄이고
//		    다음에 int형 배열의 랜덤 중복값 비교를 할때 짧은 코드로
//		    다시 사용가능하다
		
		
//		for(int i=0;i<lottoNum.length;i++) {
//			for(int j=0;j<lottoNum.length;j++) {
//
//				if(i<j) {
//					if(lottoNum[i]>lottoNum[j]) {
//						int tmp = lottoNum[i];
//						lottoNum[i]=lottoNum[j];
//						lottoNum[j]=tmp;
//					}
//				}
//			}	
//		} Arrays.sort()를 사용하여 위 코드를 단축
		
		
	}
}
