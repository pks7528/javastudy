package practice07_Coffee;

public class MainClass {
	
	public static void main(String[] args) {
		
		// 브라질 원두
		CoffeeBean coffeeBean = new CoffeeBean("브라질");
		
		// 브라질 원두에 물 50ml를 사용한 에스프레소 2샷
		Espresso espresso1 = new Espresso(coffeeBean, 50);
		Espresso espresso2 = new Espresso(coffeeBean, 50);
		
		// 에스프레소 2샷에 물 100ml를 사용한 아메리카노
		Americano americano = new Americano(2, 100);
		americano.addExpresso(espresso1);
		americano.addExpresso(espresso2);
		
		// 조회
		americano.info();
		
	}
}
