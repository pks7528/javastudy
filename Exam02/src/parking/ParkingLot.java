package parking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {

	private String name;
	private Car[] cars;
	private int idx;
	private Scanner sc;
	
	
	public ParkingLot(String name) {
		this.name = name;
		cars = new Car[10];
		sc = new Scanner(System.in);
	}
	
	public void addCar() {
		System.out.println("현재 등록된 차량 : " + idx + "대");
		if( idx == cars.length ) {
			System.out.println("더 이상 차량 등록이 불가능합니다.");
			return;
		}
		
		System.out.print("차량번호 >>>");
		String carNo = sc.next();
		System.out.print("모델명 >>>");
		String model = sc.next();
		Car car = new Car(carNo, model);
		cars[idx++] = car;
		System.out.println("차량번호 " + carNo + " 차량이 등록되었습니다.");
		
	}
	
	public void deleteCar() {
		if( idx == 0) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.print("차량번호 >>>");
		String carNo = sc.next();

		for(int i=0; i<idx; i++) {
			if(carNo.equals(cars[i].getCarNo())) {
				// 방법1. 삭제할 요소의 뒤에 있는 것들을 모두 한 칸씩 앞으로 옮기기
				System.arraycopy(cars, i+1, cars, i, idx - i - 1);
				cars[--idx] = null;
				System.out.println("차량번호 " + carNo + "가 삭제되었습니다.");
				return;
				
				/*
				마지막 차량을 옮겨오기
				제거할 차량의 위치 : i
				마지막 차량의 위치 : idx -1 
				cars[i] = cars[idx-1];					// 배열은 그림 그려서 이해할 것
				cars[--idx] = null;						// cars[--idx] 실제로 차량이 줄어드는 코드
				return;									// break도 가능
				*/
			} 
		}
		System.out.println("대상 차량이 존재하지 않습니다.");
		// for문이 끝나고 삭제할 차량이 없을 때 이곳으로 올수있음
	}
	
	public void printAllCars() {
		if( idx == 0 ) {
			System.out.println("등록된 차량이 없습니다.");
			return;
		}
		System.out.println(name + "차량 목록");
		for(int i =0; i<idx; i++) {
			System.out.println(cars[i]);
		}
		
	/* for(int i=0; i<cars.length; i++){		다른풀이// 위에 방식 우선
	 		Car car = cars[i];
	 		if(car != null){
	 			System.out.println(car);
	 		}
	 	}		
	*/
			
	}
	
	public void manage() {
		
		while(true) {
			System.out.print("1.추가  2.삭제  3.전체  0.종료 >>>");
			String choice = sc.next();
			switch(choice) {
			case "1":
				addCar();
				break;
			case "2":
				deleteCar();
				break;
			case "3":
				printAllCars();
				break;
			case "0":
				return;
			default : 
				System.out.println("존재하지 않는 메뉴입니다.");
			}
		}
	}
}
