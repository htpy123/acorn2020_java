package rosic;

public class Sample01 {
	public static void main(String[] args) {
		
		int[] num = {1,2,3,4,5,6,7,8,9,10};
		for(int i=0;i<num.length;i++) {
			for(int j=i;j<num.length-i;j++) {
				System.out.print(num[j]+"  ");
			}
			System.out.println();
		}
	}
}
