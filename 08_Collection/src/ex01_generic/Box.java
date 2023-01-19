package ex01_generic;

public class Box<T> {		//new Box<int>() 정수 저장하는 박스// new Box<double>() 
	
	//필드
	private T item;

	//getter, setter
	public T getItem() {
		return item;
	}

	public void setItem(T item) {
		this.item = item;
	}
	
	
}
