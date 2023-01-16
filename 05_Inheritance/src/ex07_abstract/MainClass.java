package ex07_abstract;

public class MainClass {

	public static void main(String[] args) {
		
		Person person = new Student(); // person에 있는 메소드만 호출할 수 있다
		
		person.eat();
		person.sleep();
		person.study();
		
		
	}

}

// person == 공통타입
// 객체 생성이 필요한 것은 student나 alba같은 클래스
// person 데이터 저장 타입// 객체 생성을 위한 클래스 아님
// 
// 하나의 메소드로 여러개의 타입을 전달??
// 여러개의 객체를 하나의 배열로 관리
