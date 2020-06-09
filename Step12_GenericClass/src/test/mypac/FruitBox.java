package test.mypac;
/*
 *  class 클래스명<Generic type>
 *  
 *  	- 클래스를 정의할때 Generic type을 지정해서 특정 type을 동적으로 지정할 수 있다.
 */
public class FruitBox<T> {  //<>안에는 변수명을 지정하듯 아무명이나 입력하면된다 //여러개 지정가능
	//필드
	private T item;
	//메소드
	public void push(T item) {
		this.item=item;
	}
	public T pull() {
		return item;
	}
}
