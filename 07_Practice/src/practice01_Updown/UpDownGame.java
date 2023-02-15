package practice01_Updown;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class UpDownGame {
	
	// 1-100 사이 숫자 맞추기
	
	private int rn;
	private int count;
	private Scanner sc;

	
	public UpDownGame() {
		rn = (int)(Math.random()*100+1);
		sc = new Scanner(System.in);
	}
	
	public int input() {
		System.out.println("숫자를 입력하세요 : ");
		int n = sc.nextInt();
		if(!(1<= n && n<100)) {
			throw new RuntimeException("1~100 사이 정수 입력");
		}
		count++;	
		return n;
	}
	
	public void play() {
		
		while(true) {
			try{
				int n = input();
				if(n < rn) {
					System.out.println("up");
				} else if (n > rn) {
					System.out.println("down");
				} else {
					System.out.println("정답 - 입력 횟수 : " + count);
					break;
				}
			} catch (InputMismatchException e) {
				sc.next();
				System.out.println("정수만 입력 가능합니다.");
			} catch(RuntimeException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}