package exam;

public class MainClass {

	// 문제1. int serial의 첫 번째 글자가 1,3,5이면 "남자", 2,4,6이면 "여자"를 출력하시오.
	// int serial의 첫 번째 글자는 항상 1 ~ 6 사이의 정수라고 가정한다.
	// 예시
	// 남자입니다.
	public static void q1() {
		int number = 1234567;
		int num = number/1000000;
		if(num % 2 == 1) {
			System.out.println("남자입니다.");
		} else {
			System.out.println("여자입니다.");
		}
	
	
	// 풀이
//		int number = 1234567;
//		if( number / 1000000 == 1) {
//			System.out.println("남자입니다.");
//		} else {
//			System.out.println("여자입니다.");
//		}
	
//		int number = 1234567;
//		String strNumber = number + "";
//		if(strNumber.charAt(0) % 2 == 1) {
//			System.out.println("남자입니다.");
//		} else {
//			System.out.println("여자입니다.");
//		}
	}	
		
	// 문제2. int a와 int b에 저장된 결과를 이용해서 사칙연산 결과를 출력하시오.
	// 예시
	// 7 + 2 = 9
	// 7 - 2 = 5
	// 7 * 2 = 14
	// 7 / 2 = 3.5
	public static void q2() {
		int a = 7;
		int b = 2;
		
		System.out.println(a + " + " + b + " = " + (a+b));
		System.out.println(a + " - " + b + " = " + (a-b));
		System.out.println(a + " * " + b + " = " + (a*b));
		System.out.println(a + " / " + b + " = " + ((double)a/b));
	}
	
	// 문제3. 구구단을 모두 출력하지 말고 5 x 5 = 25까지만 출력하시오.
	// 예시
	// 2 x 1 = 2
	// 2 x 2 = 4
	// ...
	// 5 x 5 = 25
	public static void q3() {
		
		for( int i=2; i<=5; i++ ){
			for( int j=1; j<=9; j++ ){
				if( i == 5 && j == 6 ) {
					break;
				}
				System.out.println( i + " x " + j + " = " + i*j );
			}
		}
		
//		풀이
//		for( int i=2; i<=5; i++ ){
//			for( int j=1; j<=9; j++ ){
//				System.out.println( i + " x " + j + " = " + i*j );
//				if( i == 5 && j == 5 ) {
//					break;
//				}
//			}
//		}
		
//		outer :	// 바깥 for문 laber
//		for( int i=2; i<=5; i++ ){
//			inner: // 안쪽 for문 label
//			for( int j=1; j<=9; j++ ){
//				System.out.println( i + " x " + j + " = " + i*j );
//					if( i == 5 && j == 5 ) {
//					break outer; // 바깥 for문 끝내기
//				}
//			}
//		}
		
	}
	
	// 문제4. begin부터 end 사이의 모든 정수들의 평균을 출력하시오.
	// 단, 항상 begin은 end보다 작거나 같은 상태이다.
	// 예시
	// 1부터 6사이 모든 정수의 평균은 3.5입니다.
	public static void q4() {
		int begin = 1;
		int end = 6;
		int total = 0;
		int count = 0;
		double average = 0;
		
		for(int i=begin; i<=end; i++) {
			total += i;
			count++;
		}
		average = (double)total / count;
		System.out.println(begin + "부터 " + end + "사이 모든 정수의 평균은 " + average + "입니다.");
		
//		풀이
//		int begin = 1;
//		int end = 6;
//		int total = 0;
//		for(int n=begin; n<=end; n++) {
//			total += n;
//		}
//		System.out.println(begin + "부터 " + end + "사이 모든 정수의 평균은 " + total / (end - begin + 1.0) + "입니다.");
	}
	
	// 문제5. 1부터 100 사이의 모든 짝수와 홀수를 각각 더한 결과를 모두 출력하시오.
	// 예시
	// 짝수 합은 2550입니다.
	// 홀수 합은 2500입니다.
	public static void q5() {
		int evenTotal = 0;  // 짝수 합
		int oddTotal = 0;   // 홀수 합
		
		for(int i=1; i<=100; i++) {
			if( i % 2 == 0 ) {
				evenTotal += i;
			} 
		}
		System.out.println("짝수 합은 " + evenTotal + "입니다.");
		
		for(int i=1; i<=100; i++) {
			if( i % 2 == 1) {
				oddTotal += i;
			}
		}
		System.out.println("홀수 합은 " + oddTotal + "입니다.");
//		풀이
//		for(int i=1; i<=100; i++) {
//			if( i % 2 == 0 ) {
//				evenTotal += i;
//			} else {
//				oddTotal += i;
//			}
//			System.out.println("짝수 합은 " + evenTotal + "입니다.");
//			System.out.println("홀수 합은 " + oddTotal + "입니다.");
//		}	
	}
	

	
	// 문제6. 배열에 저장된 모든 정수를 모두 더하시오.
	// 단, 0보다 작은 값은 더하지 마시오.
	// 예시
	// 합계는 6입니다.
	public static void q6() {
		int total = 0;
		int[] arr = {1, -1, -2, 2, 3, -3};
		
		for(int i=0; i<arr.length; i++) {
			if(arr[i] > 0) {
				total += arr[i];
			}
		}
		System.out.println("합계는 " + total + "입니다.");
		
//		풀이 예시1
//		for(int i=0; i<arr.length; i++) {
//			if(arr[i] < 0) {
//				continue;
//			}
//			total += arr[i];
//		}
//		System.out.println("합계는 " + total + "입니다.");
//		
	}
	
	// 문제7. 제시된 배열에 변수 ch에 저장된 문자가 몇 개 포함되어 있는지 갯수를 구해서 출력하시오.
	// 예시
	// 배열에 포함된 h는 2개입니다.
	public static void q7() {
		char ch = 'h';
		char[] characters = {'a', 'h', 'e', 'h', 'p'};
		int count = 0;
		
		for(int i=0; i<characters.length; i++) {
			if( ch == characters[i]) {
				count++;
			}
		}
		System.out.println("배열에 포함된 " + ch + "는 " + count + "개입니다.");
	
	
	}
	
	// 문제8. 점수에 따라 가져갈 수 있는 모든 사은품을 출력하시오.
	// 점수가 60점 이상인 경우 : "행주"
	// 점수가 70점 이상인 경우 : "행주", "도마"
	// 점수가 80점 이상인 경우 : "행주", "도마", "식칼"
	// 점수가 90점 이상인 경우 : "행주", "도마", "식칼", "냄비"
	// 예시
	// 행주도마
	public static void q8() {
		String strScore = "75";
		int str = Integer.parseInt(strScore);
		
		switch(str/10) {
		case 10:
		case 9: System.out.println("행주, 도마, 식칼, 냄비");
		break;
		case 8: System.out.println("행주, 도마, 식칼");
		break;
		case 7: System.out.println("행주, 도마");
		break;
		case 6: System.out.println("행주");
		}
		
//		//예시 1
//		String strScore = "75";
//		int score = Integer.parseInt(strScore);
//		
//		String result = "";
//		switch(score/10) {
//		case 10: 
//		case 9: result += "냄비";
//		case 8: result += "식칼";
//		case 7: result += "도마";
//		case 6: result += "행주";
//		}
//		System.out.println(result);
		//예시 2
//		String strScore = "75";
//		int score = Integer.parseInt(strScore);
//		String result = "";
//		if(score >= 60) {
//			result += "행주";
//		}
//		if(score >= 70) {
//			result += "도마";
//		}
//		if(score >= 80) {
//			result += "식칼";
//		}
//		if(score >= 90) {
//			result += "냄비";
//		}
//		System.out.println(result);
	}
	
	// 문제9. 1 ~ 100 사이의 정수를 대상으로 369 게임 결과를 아래와 같이 출력하시오.
	// 예시
	// 1   2   짝   4   5   짝   7   8   짝   10
	// 11  12  짝   14  15  짝   17  18  짝   20
	// 21  22  짝   24  25  짝   27  28  짝   짝
	// 짝  짝  짝짝 짝  짝  짝짝 짝  짝  짝짝 40
	// ...
	// 81  82  짝   84  85  짝   87  88  짝   짝
	// 짝  짝  짝짝 짝  짝  짝짝 짝  짝  짝짝 100
	public static void q9() {
		boolean condition1 = false;  // 일의 자리가 3의 배수인가?
		boolean condition2 = false;  // 십의 자리가 3의 배수인가?
		
//		for(int i=1; i<=100; i++) {
//			System.out.print(i + "\t");
//			if( i%10 == 0 ) {
//				System.out.println();
//			}
//		}
		
		for(int n = 1; n <= 100; n++) {
			int a = n % 10;
			int b = n / 10;
			
			if(n < 10){
				if( n % 3 == 0 ) {
					System.out.print("짝" + "\t");
				} else {
					System.out.print(n + "\t");
				}
			} else if ( n % 10 == 0) {
				if((a % 3 == 0) && (b % 3 == 0)) {
					System.out.println("짝" + "\t");
				} else { 
					System.out.println(n + "\t");
				}
			} else {
				if((a % 3 == 0) && ( b % 3 == 0)) {
					System.out.print("짝짝" + "\t");
				} else if((a % 3 == 0) || (b % 3 == 0)) {
					System.out.print("짝" + "\t");
				} else {
					System.out.print(n + "\t");
				}
			}
		}
//		예시
		for(int n=1; n<=100; n++) {
			int one = n % 10;
			condition1 = ( one % 3 == 0 && one != 0 );
			int ten = n / 10; 
			condition2 = ( ten % 3 == 0 && ten != 0 );
			if(condition1 && condition2) {
				System.out.print("짝짝" + "\t");
			} else if(condition1 || condition2) {
				System.out.print("짝" + "\t");
			} else {
				System.out.print(n + "\t");
			}
			if(n%10 == 0)
				System.out.println();
		}
		
	}
	
	// 문제10. 5명의 이름과 점수를 각각의 배열에 저장하였다.
	// 가장 높은 점수를 받은 사람의 이름을 출력하시오.
	// 예시
	// 가장 높은 점수를 받은 사람은 정숙입니다.
	public static void q10() {
		String[] names = {"철수", "영희", "정숙", "상철", "미희"};
		int[] scores = {50, 60, 90, 80, 70};
		
		int max = 0;
		int num = 0; 
		
		for(int i=0; i<scores.length; i++) {
			if( max < scores[i] ) {
				max = scores[i];
				num = i;
			}
		}
		System.out.println("가장 높은 점수를 받은 사람은 " + names[num]  + "입니다.");
		
//		예시
//		int max = scores[0];
//		int maxNo = 0;
//		for(int i=1; i<scores.length; i++) {
//			if( max < scores[i] ) {
//				max = scores[i];
//				maxNo = i;
//			}
//		}
//		System.out.println("가장 높은 점수를 받은 사람은 " + names[maxNo]  + "입니다.");
		
	}
	
	// main 메소드는 그대로 사용합니다.
	public static void main(String[] args) {
		System.out.println("=====문제1=====");
		q1();
		System.out.println("=====문제2=====");
		q2();
		System.out.println("=====문제3=====");
		q3();
		System.out.println("=====문제4=====");
		q4();
		System.out.println("=====문제5=====");
		q5();
		System.out.println("=====문제6=====");
		q6();
		System.out.println("=====문제7=====");
		q7();
		System.out.println("=====문제8=====");
		q8();
		System.out.println("=====문제9=====");
		q9();
		System.out.println("=====문제10=====");
		q10();
	}

}
