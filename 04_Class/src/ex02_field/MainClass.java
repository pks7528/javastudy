package ex02_field;

public class MainClass {

	public static void main(String[] args) {
//		
//		Student student = new Student();
//		student.stuNo = "12345";
//		student.name = "박기상";
//		
//		student.score = new Score();
//		student.score.kor = 100;
//		student.score.eng = 90;
//		student.score.math = 80;
//	
//		System.out.println("학번 : " + student.stuNo);
//		System.out.println("이름 : " + student.name);
//		System.out.println("국어 : " + student.score.kor);
//		System.out.println("영어 : " + student.score.eng);
//		System.out.println("수학 : " + student.score.math);
//		
//		
		School school = new School();
		school.name = "철산초";
		school.students = new Student[3]; //학생 3명 저장 가능
		
		for(int i=0; i<school.students.length; i++) {
			
			// Student 객체 생성
			school.students[i] = new Student(); // 학생 생성
			
			school.students[i].name = "정숙";
			school.students[i].stuNo = "12345";
			
			// Score 객체 생성
			school.students[i].score = new Score();
			
			school.students[i].score.kor = 100;
			school.students[i].score.eng = 90;
			school.students[i].score.math = 80;
			
			
			
			System.out.println("학번 : " + school.students[i].stuNo);
			System.out.println("이름 : " + school.students[i].name);
			System.out.println("국어 : " + school.students[i].score.kor);
			System.out.println("영어 : " + school.students[i].score.eng);
			System.out.println("수학 : " + school.students[i].score.math);
		}
	}

}
