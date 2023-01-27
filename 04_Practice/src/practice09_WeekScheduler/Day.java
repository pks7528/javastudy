package practice09_WeekScheduler;

public class Day {
	
	//필드
	private String schedule;

	//생성자
	public Day() {																// new Day()에 세터로 값 주입
		
	}
	
	public Day(String schedule) {												// new Day("Fitness") 생성자 주입
		this.schedule = schedule;
	}
	
	public String getSchedule() {
		return schedule;
	}
	
	public void setSchedule(String schedule) {									// day.setSchedule("Fitness"
		this.schedule = schedule;
	}
	
	

}

//디톨트 생성자 만들면 세터 게터 만들어야함
//컨스트럭트 인젝션에 세터 게터 사용하는 것은 값 변경을 위해 사용
//7개의 값 없이 day 생성 후 세터를 이용해서 하나씩 채움

