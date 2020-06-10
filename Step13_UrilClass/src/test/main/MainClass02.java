package test.main;

import java.util.ArrayList;
import java.util.Random;

public class MainClass02 {
	public static void main(String[] args) {
		//정수를 저장할수 있는 가변 배열 객체 생성
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(10);
		nums.add(20);
		nums.add(30);
//		nums의 길이를 정수형 int type의 size변수에 저장
		//배열의 크기 얻어오기
		int size = nums.size();
//		nums 배열의 0번째 방의 integer 값을 int형 num1 변수에 저장
		//특정 인덱스 아이템 얻어오기(참조)
		int num1 = nums.get(0);
		Integer num2 = nums.get(1);
		int num3 = nums.get(2);
//		nums 배열의 1번방에 40값을 대입
		//특정 인덱스 수정
		nums.set(1, 40);
//		nums배열의 1번방 삭제
		//특정 인덱스 삭제          //삭제된 자리를 메꾸기 위해서 인덱스값이 떙겨짐  0,1,2 중에 1삭제시 0,1로 바뀜 2->1로 바뀜
		nums.remove(1);
//		nums배열 전부 삭제
		//배열 비우기
		nums.clear();
	}
}
