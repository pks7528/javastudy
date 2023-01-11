package test;

public class Test {

	public static void main(String[] args) {

//		1. int serial의 첫번째 글자가 1,3,5이면 "남자" 2,4,6 이면 여자를 출력하시오
//		int serial의 첫 번째 글자는 항상 1~6 사이의 정수라고 가정한다
//		예시 
//		남자입니다
//
//		3. 구구단을 모두 출력하지 말고 5x5=25까지만 출력하시오
//		예시
//		2x1=2
//		2x2=4
//		...
//		5x5=25
//
//		5. 1부터 100사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오
//		예시
//		짝수 합은 2550입니다
//		홀수 합은 2500입니다.
			
		
		//1.
		int serial=0;
		String str = "";
		if(serial % 2 == 1) {
			str = "남자입니다.";
		} else {
			str = "여자입니다.";
		}
		System.out.println(str);
		
		//3.
		for(int i=2; i<=5; i++) {
			for(int j=1; j<=9; j++) {
				if((i==5 && j==6)) {
					break;
				}
				System.out.println( i + "x" + j + "=" + i*j);
			}
		}
				
		//5.
//		int sum=0;
//		
//		for(int i=1; i<=100; i++) {
//			if(i%2 == 0) {
//				sum += i;
//			}
//		}
		
//		System.out.println("짝수 합은 " + sum + "입니다.");
//		
//		for(int i=1; i<=100; i++) {
//			if(i%2 == 1) {
//				sum += i;
//			}
//		}
//		System.out.println("홀수 합은 " + sum + "입니다.");
//		
		int oddSum = 0; //(홀수)
		int evenSum = 0; //(짝수)
		
		for(int i=1;i<=100;i++) {
			if( i%2 == 0 ) {
				evenSum += i;
			}
		}
		System.out.println("짝수의 합은 " + evenSum + "입니다.");
		
		for(int i=1; i<= 100; i++) {
			if( i%2 == 1 ) {
				oddSum += i;
				
			}
		}
		System.out.println("홀수의 합은 " + oddSum + "입니다.");
	}

}
