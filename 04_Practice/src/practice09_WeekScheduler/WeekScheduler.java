package practice09_WeekScheduler;

import java.util.Scanner;

public class WeekScheduler {
	
		//7개의 day를 가져야 한다
	private Scanner sc;
	private Day[] days;
	private String[] dayNames = {"일", "월", "화", "수", "목", "금", "토"};
	private int nthWeek;
	
	
	// new WeekScheduler(4)
	public WeekScheduler(int nthWeek) {
		this.nthWeek = nthWeek;	
		sc =new Scanner(System.in);					// 
		days = new Day[7];							// 배열에 null값 
		for(int i=0; i<days.length; i++) {
			days[i] = new Day();
		}
	}
	
	public void addSchedule() {
		System.out.println("요일 입력 >>>");
		String dayName = sc.next().trim().substring(0, 1);	// 요일과 엔터 입력	//0번부터 1글자만 따옴	//trim -> 공백제거	// substring으로 입력받은 값의 첫번째 글자만 따옴 // charAt(0)은 반환값이 String이 아니라 char이라 오류
		sc.nextLine();										// 엔터 제거 // 목을 입력후 엔터치면 dayname이 목만 먹음,, 엔터 출력하면 빈문자열로 출력되므로 엔터제거를 위해  nextLine 작성
		
		for(int i=0; i<dayNames.length; i++) {
			if(dayName.equals(dayNames[i])) {
				if(days[i].getSchedule() == null) {				// 19번 줄 for문 때문에 이미 day에 값 들어잇으므로 days[i] == null은 안됨,,,  getschedule로 값 불러서 확인
					System.out.print("스케쥴 입력>>>");
					String schedule = sc.nextLine();			// nextline -> 공백 포함	// 목은 dayName이 먹음,,엔터출력하면 빈문자열로 저장
					days[i].setSchedule(schedule);				// set으로 입력받은 스케줄 전달
					System.out.println(dayName + "요일에 스케줄 등록 완료");
				} else {
					System.out.println(dayName + "요일은 이미 스케쥴이 있음");
				}
				break;										// 스케줄 있든 없든 순회 끝
			}
		}
		
	}
	
	public void deleteSchedule() {									// 삭제 == 해당 값에 null 넣어주기 days[i].setschedule(null)
		System.out.println("요일 입력 >>>");
		String dayName = sc.next().trim().substring(0, 1);
		sc.nextLine();										
		
		for(int i=0; i<dayNames.length; i++) {
			if(dayName.equals(dayNames[i])) {
				days[i].setSchedule(null); 				// 해당 스케쥴을 null로 바꾼다.  -- 삭제
				System.out.println(dayName + "요일 스케쥴 삭제 완료");
				break;									// 삭제되면 종료
			}
		}
	}
	
	
	public void printAllSchedule() {
		System.out.println(nthWeek + "주차 스케쥴");
		for(int i=0; i<days.length; i++) {
			System.out.println(dayNames[i] + "요일");
			System.out.println(days[i].getSchedule() == null ? "스케쥴 없음" : days[i].getSchedule()); //요일에 스케쥴이 없으면 슼쥴 없음 출력, 아니면 스케쥴 출력
		}
	}
	
	public void manage() {
		while(true) {
			System.out.println("1. 추가 2. 삭제 3.수정 4. 출력 0. 종료 >>>");
			String choice = sc.next();
			switch(choice) {
			case "1" :
				addSchedule();
				break;
			case "2" :
				deleteSchedule();
				break;
			case "4" :
				printAllSchedule();
				break;
			case "0" :
				return;
			}
		}
	}
	public static void main(String[] args) {
		
	}
	
	
	
}

//