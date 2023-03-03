package test;

public class Test {
	
	public static void ex01() {
		for(int i=1; i<6; i++) {
			for(int j=0; j<i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void ex02() {
		for(int i=1; i<6; i++) {
			for(int j=6; j>i; j--) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}
	
	public static void ex03() {
		int sum = 0;
		int odd = 0;
		int even = 0;
		for(int i=1; i<=100; i++) {
			if(i%2 == 0) {
				even += i;
			} else {
				odd += i; 
			}
		}
		System.out.println("짝수 합 : " + even +" / 홀수 합 : " + odd);
	}
	
	public static void ex04() {
		for(int i=0;i<4;i++){
			for(int j=0;j<3-i;j++){
				System.out.print(" "); 
			}
			for(int j=0;j<2*i+1;j++){
				System.out.print("*"); 
			}
			System.out.println("");
		} 
	}
	
	public static void ex05() {
		int count=9;
		for(int i=1; i <= count; i = i+2) {
			for(int k=0; k<(count-i)/2; k++) {
				System.out.print(" ");
			}
			for(int j=0; j<i; j++) {
				System.out.print("*");
			} System.out.println();
		}
	}
	
	public static void ex06() {
		int i = 0;
		int odd = 0;
		int even = 0;
		
		// 1~100 홀짝합
		while(i<=100) {
			if(i%2 == 0) {
				even += i;
			} else {
				odd += i;
			}
			i++;
		}
		System.out.println(odd + "/" + even);
	}
	
	public static void ex07() {
		// 구구단 5*5까지만
		for(int i=2; i<=5; i++) {
			for(int j=1; j<=9; j++) {
				if(i==5 && j==6)
					break;
				System.out.println(i + "*" + j + "=" + i*j);
			}
		}
	}
	public static void ex08() {
		int[] arr = new int[5];
		
		for(int i=0; i<5; i++) {
			arr[i] += i+1;
			System.out.println(arr[i]);
		}
	}
	
	public static void ex09() {
		int total = 0;
		int min = 0;
		int max = 0;
		int[] scores = new int[5];
		
		scores[0] = 100;
		scores[1] = 70;
		scores[2] = 95;
		scores[3] = 83;
		scores[4] = 76;
		
		for(int i=0; i<5; i++) {
			total += scores[i];
			
			if(max < scores[i]) {
				max = scores[i];
			}
			if(min > scores[i]) {
				min = scores[i];
			}
		}
		System.out.println(total);
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void ex10() {
		 // 문제8. 점수에 따라 가져갈 수 있는 모든 사은품을 출력하시오.
		   // 점수가 60점 이상인 경우 : "행주"
		   // 점수가 70점 이상인 경우 : "행주", "도마"
		   // 점수가 80점 이상인 경우 : "행주", "도마", "식칼"
		   // 점수가 90점 이상인 경우 : "행주", "도마", "식칼", "냄비"
		
		int score = 75;
		String[] str = new String[4];
		str[0] = "행주";
		str[1] = "도마";
		str[2] = "식칼";
		str[3] = "냄비";
		
//		60이면 1/70이면 2
				
		int k=0;
		
		if(score >= 90)		 k=4;
		else if(score >= 80) k=3;
		else if(score >= 70) k=2;
		else				 k=1;
		
		for(int i=0; i<k; i++) {
			System.out.print(str[i] + " ");
		}
		
//		if(score >= 90) {
//			for(int i=0; i<4; i++) {
//				System.out.print(str[i] + " ");
//			}
//		} else if(score >= 80) {
//			for(int i=0; i<3; i++) {
//				System.out.print(str[i] + " ");
//			}
//		} else if(score >= 70) {
//			for(int i=0; i<2; i++) {
//				System.out.print(str[i] + " ");
//			}
//		} else {
//			for(int i=0; i<1; i++) {
//				System.out.print(str[i] + " ");
//			}
//		}
//		
		
	}
	public static void main(String[] args) {
		ex10();
	}
}
