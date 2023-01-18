package ex06_downcasating;

public class MainClass {
	
	public static void ex01() {

		Person person = new Student(); // 자식을 부모타입에 저장 upcasting
		
		Student student = (Student) person; // 강제로 타입 변환, downcasting
		
		student.eat();
		student.sleep();
		student.study();

		// 업캐스팅은 부모가 가진 것만 호출
		//	해결책 1) 부모에도 메소드 넣어서 오버라이딩
		//			2) 다운캐스팅
	}
	
	
	public static void ex02() {

		// Person
		Person person = new Person(); 
		
		//잘못된 캐스팅
		Student student = (Student) person;
		
		//잘못된 캐스팅은 컴파일 오류로 걸러지지 않는다. 
		student.eat();
		student.sleep();
		student.study(); // 오류 발생 부분 , Person은 study가 없기 때문에

	}
	
	public static void ex03() {
		
		// Person
		Person person = new Person();
		
		// Student 객체(인스턴스, instance)가 맞다면 student 타입으로 캐스팅하자.
		if(person instanceof Student) {
			Student student = (Student)person;
			student.eat();
			student.sleep();
			student.study();
			
			person.eat(); // student.eat()와 동일한 코드 // 코드 진행 이런식으로 추천
			person.sleep();
			((Student)person).study(); // 위의 코드와 이 코드는 서로 다른곳에 있음을 알수있다.
			
			// ((Student) person).study();// person.study가 없어야 정상이지만 if( instanceod) 연산자를 사용하면 나온다.
		}
	}
	
	public static void main(String[] args) {
		ex03();

	}
}
