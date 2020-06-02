package rosic.pac;

public class Gugudan {
	public Gugudan(int num) {
		if(num<10) {
			for(int i=1;i<10;i++) {
				System.out.println(num+"*"+i+"="+num*i);
			}
		}else {
			System.out.println("0~9사이의 숫자를 입력해주세요");
		}
	}
}
