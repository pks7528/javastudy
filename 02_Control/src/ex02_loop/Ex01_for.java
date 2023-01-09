package ex02_loop;

public class Ex01_for {
	
	/*
	 	 for문
	 	 1. 연속된 숫자를 생성하는 반복문(배열에서 주로 사용)
	 	 2. 형식
	 	 	for(초기문; 조건문; 증감문){
	 	 		실행문
	 	 	}
	 */
	
	public static void ex01() {
		
		// 1 ~ 10
		for(int a=1; a<=10; a++) {
			System.out.println(a);
		}
//		for(int a=0; a<=9; a++) {
//			System.out.println(a+1);
//		} // 이것도 가능// 
		// 실행 순서 : 초기문-조건문-실행문-증감문
		// 초기문 한번만 실행,, 조건문,실행문,증감문이 반복
	}
	
	public static void ex02() {
		
		// 횟수
//		for(int a = 1; a<=5; a++) {
//			System.out.println("Hello World");
//		}
		
		//0부터 시작하는 것을 선호
		for(int a = 0; a<5; a++) {
			System.out.println("Hello World");
		}
		
//		int count = 5;
//		for(int a = 0; a<count; a++) {
//			System.out.println("Hello World");
//		}
	}
	
	public static void ex03() { //연습
		
		// 10 ~ 1 출력
		
		for(int a = 10; a>=1; a--) {
			System.out.println(a);
		}
		
	}
	
	public static void ex04() { //연습
		
		// 구구단 2단 출력
		// 2 x 1 = 2
		// 2 x 2 = 4
		// ...
		
//		for(int a = 2; a < 3; a++) {
//			for(int b = 1; b<=9; b++) {
//				System.out.printf("%d x %d = %2d%n", a, b, a*b);
//			}
//		}
		
//		for(int a = 1; a <= 9; a++) {
//			System.out.printf("2 x %d = %2d%n", a, 2*a);
//		}
//		
		int dan = 2; // 이곳에 원하는 구구단을 넣으면 된다.
		
		for(int a = 1; a <= 9; a++) {
			System.out.println( dan + " x " + a + " = " + 2*a );
		}
	}

	public static void main(String[] args) {
		ex04();
		
	}

}
