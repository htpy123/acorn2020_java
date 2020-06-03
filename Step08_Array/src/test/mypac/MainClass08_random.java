package test.mypac;

import java.util.Random;
import java.util.Scanner;

public class MainClass08_random {
	public void prinT(String[] str) {
		Scanner scan = new Scanner(System.in);
		Random ran = new Random();
		int[] points = {10,20,30,40,1000};
		int[] random = new int[3];
		int[][] tmp=new int[3][3];
		System.out.println("\n   ~★☆★☆띠리리리링☆★☆★~");
		System.out.println("=========================");
		for(int i=0;i<3;i++) {
			for(int j=0;j<2;j++) {
				int a = ran.nextInt(101);
				tmp[i][j]=this.returnNum(a);
				random[j]=tmp[i][j];
				System.out.print(str[random[j]]+" | ");
			}
			int a = ran.nextInt(101);
			tmp[i][2]=this.returnNum(a);
			random[2]=tmp[i][2];
			System.out.print(str[random[2]]);
			if(random[0]==random[1]&&random[0]==random[2]) {
				System.out.println(" : ( "+points[random[0]]+" )점");
			}else {
				System.out.println(" :  ( 0 )점");
			}
			if(i==2) {
				for(int j=0;j<3;j++) {
					if(tmp[0][j]==tmp[1][j]&&tmp[0][j]==tmp[2][j]) {
						System.out.print("  "+points[tmp[0][j]]+"점       ");
					}else {
						System.out.print("  0점         ");
					}
				}
			}
		}
		System.out.println("\n=========================");
	}
	public int returnNum(int a) {
		if(98<a) {
			return 4;
		}else if(90<=a) {
			return 3;
		}else if(70<=a) {
			return 2;
		}else if(40<a) {
			return 1;
		}else{
			return 0;
		}
		
		
//      내가 작성했던 코드		
//		if(40>=a&&a>=0) {
//			return 0;
//		}else if(70>=a&&a>40) {
//			return 1;
//		}else if(90>=a&&a>70) {
//			return 2;
//		}else if(98>=a&&a>90) {
//			return 3;
//		}else {
//			return 4;
//		}
	}
}
