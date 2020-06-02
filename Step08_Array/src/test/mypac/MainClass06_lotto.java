package test.mypac;

import java.util.Random;

public class MainClass06_lotto {
	public int[] lottoTmp(int lottoNum[]) {
		Random ran = new Random();
		for(int i=0;i<lottoNum.length;i++) {
			lottoNum[i] = ran.nextInt(45)+1;
		}
		
		for(int i=0;i<lottoNum.length;i++) {
			for(int j=0;j<lottoNum.length;j++) {
				if(lottoNum[i]==lottoNum[j]) {
					lottoNum[j] = ran.nextInt(45)+1;
				}
			}
		}
		return lottoNum;
	}
}
