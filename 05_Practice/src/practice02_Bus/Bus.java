package practice02_Bus;

public class Bus {
	//필드
	private Seat[] seats;			// 여러 좌석 있음
	private int passengerLimit;		// 버스 정원
	
	//생성자
	public Bus(int passengerLimit) {
		this.seats = new Seat[passengerLimit];
		this.passengerLimit = passengerLimit;
		for( int i=0; i<seats.length; i++) {
			seats[i] = new Seat();
		}
	}
	
	//승차 메소드
	public void riding(int seatNo, Person person) {
		
		//존재하지 않는 Seat 번호
		if(seatNo == 0 || seatNo > passengerLimit) {
			return;
		}
		
		//Seat가 비어있으면 해당 Seat에 Person 저장하기
		Seat seat = seats[seatNo -1];
		Person p = seat.getPerson();
		if(p==null) {
			seat.setPerson(person);
		}
	}
	
	//승차 현황 메소드
	public void info() {
		//1번 좌석 : 홍길동
		//2번 좌석 : 비어있음
		//...
		for( int i=0; i<passengerLimit; i++ ) {
			Person person = seats[i].getPerson();
			if(person != null) {
				System.out.println((i+1) + "번 좌석 : " + person.getName());
			} else {
				System.out.println((i+1) + "번 좌석 : 비어있음");
			}
			
		}
	}
}
