package test.main;
/*
 *  2. 증감 연산자 테스트
 */
public class MainClass02 {
	public static void main(String[] args) {
		int num=0;
		num++; 
		num++;
		num++; // num 이 최종적으로 3이된다.
		
		int num2=0;
		num2--; 
		num2--;
		num2--;	// num2 가 최종적으로 -3이 된다.
		
		int num3=0;
		int result1 = num3++;  // result1 에 0 이 대입되고 그 후 num3의 값이 1 증가한다.
		
		int num4=0; 
		int result2 = ++num4;  // num4가 1증하하고 이후 result2에 1이 대입된다.
	}
}












