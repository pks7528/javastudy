package Practice01;

import java.util.Scanner;

public class main {
	
	// 문제6. 비밀번호를 "1234"로 가정한다.
	// 사용자로부터 비밀번호를 입력 받아서 "1234"와 같으면 "성공", "1234"가 아니면 다시 비밀번호를 입력 받도록 처리하시오.
	// 비밀번호 입력은 최대 5번으로 제한하고, 5번의 입력이 모두 틀리면 최종적으로 "실패"를 출력하시오.
	public static void ex06() {
		
//		int password = 1234;
//		Scanner sc = new Scanner(System.in);
//		
//		for(int i=0; i<5; i++) {
//			System.out.println("비밀번호 : ");
//			if(password == sc.nextInt()) {
//				System.out.println("성공");
//				return;
//			}
//		}
//		System.out.println("실패");
		
		String password = "1234";
		Scanner sc = new Scanner(System.in);
		
		for(int i=0; i<5; i++) {
			System.out.print("비밀번호 : ");
			if(password.equals(sc.next())) {
				System.out.println("성공");
				return;
			}
		}
		System.out.println("실패");
		

//		Scanner sc = new Scanner(System.in);
//
//		String pw = "1234";
//		int count = 0;
//
//		while(true) {
//			System.out.println("비밀번호를 입력하세요 >>> ");
//			String input = sc.next();
//			count++;
//
//			if(input.equals(pw)) {
//				System.out.println("성공");
//				break;
//			}
//			if(count == 5) {
//				System.out.println("실패");
//				break;
//			}
//		}
//
//		sc.close();

	}		
	public static void main(String[] args) {
		ex06();
		
	}
}
