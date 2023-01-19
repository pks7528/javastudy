package practice05_Cart;

public class Pizza extends Product {

	// new Pizza(2, "고구마피자", 3000)
	
	// 필드 없을때 슈퍼클래스 생성자 만들어야 함 
	// source - generate constructors from superclass
	public Pizza(int prodNo, String prodName, int prodPrice) {
		super(prodNo, prodName, prodPrice);
		
	}
	

	
	
}
