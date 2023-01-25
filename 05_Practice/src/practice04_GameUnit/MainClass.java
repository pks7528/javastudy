package practice04_GameUnit;

public class MainClass {
	
	public static void main(String[] args) {
		GameUnit unit1 = new Tank("탱크");
		GameUnit unit2 = new Marine("마린");
		
		unit1.info(); 	// 탱크 에너지 100 공격력 10
		unit2.info(); 	// 마린 에너지 50 공격력 5
		
		System.out.println("===전투 시작===");
		
		//공격 차례 정하기
		boolean myTurn = Math.random() < 0.5;
		
		//한 대 씩 주고받기
		//두 유닛이 모두 살아있으면 계속 싸움
		
	}
}
