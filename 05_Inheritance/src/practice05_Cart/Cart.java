package practice05_Cart;

public class Cart {
	
	//getter setter 는 부모클래스에 생성
	private Product[] products;				// 배열 선언
	private int prodCount;					// 실제로 products 배열에 저장된 product의 개수
	
	// new Cart(10) - 물건을 10개 담을 수 있는 카트
	// new Cart(20) - 물건을 20개
	
	public Cart(int cartSize) {				// 직접 생성자 생성
		products = new Product[cartSize];	// 배열 생성
		prodCount = 0;						// 안적어도 됨,, 필드값이기 때문에 0으로 자동 초기화
	}

	public Product[] getProducts() {
		return products;
	}

	public void setProducts(Product[] products) {
		this.products = products;
	}

	public int getProdCount() {
		return prodCount;
	}

	public void setProdCount(int prodCount) {
		this.prodCount = prodCount;
	}
	
	// addProduct(new Meat(1, "소고기", 5000))	//new Meat를 부모 생성자로
	// addProduct(new Pizza(2, "고구마피자", 3000))
	// addProduct(new Noodle(3, "누들면", 1500))
	public void addProduct(Product product) {
	
		// 카트가 가득 차면 물건을 담지 못한다.
		if(products.length == prodCount) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 카트에 물건 담기	
		products[prodCount++] = product;		//product를 사용하고 늘리기	
	}
	
	// 카트에서 물건 빼기
	// deleteProduct(1)
	// deleteProduct(2)
	// deleteProduct(3)
	public void deleteProduct(int prodNo) {
		
		// 카트가 비어있으면 뺄 물건이 없다.
		if(prodCount == 0) {
			System.out.println("카트가 비어있습니다.");
			return;
		}
		
		// 카트에서 물건 빼기
		for(int i=0; i<prodCount; i++) {
			if(products[i].getProdNo() == prodNo ) {
				products[i] = products[--prodCount];	// 마지막 물건을 뺀 물건 자리로 옮기기
				break;
			}
		}
		
	}
}
