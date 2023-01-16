package ex07_abstract;

public class Student extends Person{

	@Override									// 자동 작성 ctrl + space -> study// source - override method
	public void study() {
		System.out.println("공부한다.");
	}
	

}
