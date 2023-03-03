package ex02_loop;

public class Ex03_break {

	/*
	 	break문
	 	1. switch문 종료
	 	2. 반복문(for, while) 종료
	 */
	
	public static void ex01() {
		
		/*
		 	무한 루프
		 	1. 끝나지 않는 반복문
		 	2. 형식
		 		for(;;)
		 		while(true)             // 대부분 while문으로 무한루프 만듬
		 */
		
		// 1 ~ 10
		
		int a = 1;
		while(true) {
			
			if(a > 10) {
				break;
			}
			System.out.println(a);
			a++;
			
		}
		
	}
	
	public static void ex02() {
		
		// 모금
		
		int goal = 100000; // 모금 목표
		int money = 60; // 1회 모금 금액
		int total = 0; // 누적 모금액
		int n = 0; // 모금 횟수
		
			// 1회 모금액 60원 현재 60원
			// 2회 모금액 60원 현재 120원
			// ?회 모금액 60원 현재 100000원이 넘어가면 스탑
		
//		while(true) { // 내 풀이 오답
//			
//			
//			++n;
//			total += money;
//			if(goal<=money*n) {
//				break;
//				
//			}
//			System.out.println(n + "회 모금액 " + money + "원 현재 " + total + "원");
//		
//		}
		
		while(true) {    									// 나중에 for문으로 변환해볼것
			if(total>=goal) {
				break;
			}
			total += money;
			System.out.println(++n + "회 모금액 " + money + "원, 현재 " + total + "원");
		}
		
	}
	
	
	public static void main(String[] args) {
		ex02();
	}

}
