package test.mypac;

import java.util.Random;
import java.util.Scanner;

public class MainClass10_random {
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
					tmp[i][j]=ran.nextInt(5);
					random[j]=tmp[i][j];
					System.out.print(str[random[j]]+" | ");
			}
			tmp[i][2] = ran.nextInt(5);
			random[2]=tmp[i][2];
			System.out.print(str[random[2]]);
			if(random[0]==random[1]&&random[0]==random[2]) {
				System.out.println(" : ( "+points[random[0]]+" )점");
			}else {
				System.out.println(" : ( 0 )점");
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
}
