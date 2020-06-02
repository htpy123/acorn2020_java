package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		
		// int type 5 개를 저장하고 있는 배열
		int[] nums = { 10, 20, 30, 40, 50};
		// double type 5개를 저장하고 있는 배열
		double[] nums2 = { 10.1, 10.2, 10.3, 10.4, 10.5};
		//boolean type 5개를 저장하고 있는 배열
		boolean[] truth = {true, false, false, true, true};
		
		//String type(참조데이터 type) 5개를 저장하고 있는 배열
		String[] names = {"김구라", "해골", "원숭이", "주뎅이", "덩어리"};
		
		int result1 = nums[0];			//10
		double result2 = nums2[1];		//10.2
		boolean result3  = truth[2];	//false
		String result4 = names[3];		//"주뎅이"
		int result5 = nums.length;		//5
		
		// 배열 객체의 메소드와 필드 사용해 보기
		int[] cloned = nums.clone();
		int size=nums.length;
		
	}
}
