package test.main;

public class MainClass08 {
	public static void main(String[] args) {

		//String type
		String str="abcde12345";
		//문자열의 길이
		int size = str.length();
		//5번째 인덱스의 문자 1개 (char)
		char ch = str.charAt(5);
		//소문자를 모두 대문자로 변환한 문자열 얻어내기
		String result = str.toUpperCase();
		
		System.out.println(size+"+"+ch+"+"+result);
	}
};

