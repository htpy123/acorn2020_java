package main.marin_status;

public class Marine_My_HP {
	int marin_hp=60;
	public void marin() {
//		while(true) {
			double num = (int)(Math.random()*10);
			marin_hp -= num;
			System.out.println(num+"의 데미지를 입었습니다");
			if(marin_hp>0) {
				System.out.println("마린의 현재 체력 : "+marin_hp);
			}else {
				System.out.println("으앙 쥬금~");
//				break;
//			}
		}
		}
}
