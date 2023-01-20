package parking;

import java.util.Scanner;

public class ParkingLot {
	
	//필드
	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	/*
	 	constructor
	 	매개변수로 주차장이름을 전달 받아서 필드를 초기화하고,
	 	길이가 10인 cars 배열을 생성하고, 
	 	키보드로부터 정보를 입력 받을 수 있는 sc 인스턴스를 생성한다.
	 */
	
	//생성자
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
		}
	
	public void addCar() { 
//		현재 등록된 차량이 몇대인지
//		cars[idx] = new Car("no", "model");
//		idx++
//		idx는 주차장에 등록된 자동차 대수와 같다
		
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if( idx == cars.length ) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
/*
 	(1) 가장 먼저 현재 등록된 차량 0대와 같은 메시지를 출력한다
 	2. 주차장이 가득찬 경우 "더 이상 차량 등록이 불가능합니다."메시지를 출력하고 addCar()메소드를 종료한다.
 	3. sc인스턴스를 이용해서 차량번호와모델명을 입력받은 뒤 cars 배열에 순차적으로 저장한다.
 	4. 차량번호와 모델명은 공백없는 문자열로처리한다 ==> next();
 	5. 차량번호가 288러1111과 같은 차량의 등록이 성공하면 차량번호 288러1111차량이 등록되었습니다. 메시지를 출력한다.
 	6. 기타 명시되지 않은 예외는 발생하지 않는 것으로 가정한다.
 */
		System.out.print("차량번호 >>>");
		String carNo = sc.next();
		System.out.print("모델명 >>>");
		String model = sc.next();					//next는 공백 불가능; nextLine 줄바꿈까지 공백가능
		Car car = new Car(carNo, model);
		cars[idx++] = car; // 
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
	}
	
	public void deleteCar() {
	}
	
	public void printAllCars() {
	}
	
	public void manage() {
		
		while(true) {
			System.out.print(" 1.추가	2.삭제	3.전체	0.종료 >>> ");
			
			String choice = sc.next();
			
			switch(choice) {
			case "1": 
				addCar(); //addCar 호출
				break;
			case "2":
				deleteCar();
				break;
			case "3":
				printAllCars();
				break;
			case "0":
				return; 	//manage 메소드 종료	//break쓰면 switch 종료,, 
			default :
				System.out.println("존재하지 않는 메뉴입니다.");
			}
			
			}
	
	
	}
	
	
	
	
}