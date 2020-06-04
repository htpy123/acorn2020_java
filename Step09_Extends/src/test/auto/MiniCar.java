package test.auto;

public class MiniCar extends Car{

	public MiniCar(Engine engine) {
		super(engine);
//		System.out.println("귀여운 미니카");
	}
	@Override
	public void drive() {
		super.drive();
		System.out.println("귀여운 미니카");
	}

}
