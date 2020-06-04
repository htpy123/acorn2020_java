package test.mypac;

public class SmartPhone extends HandPhone{
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}
	//@Override 는 무모의 메소드를 재정하 즤
	@Override
	public void takePicture() {
//		super.takePicture();
		System.out.println("1000만 화소의 사진을 찍어요");
	}
}
