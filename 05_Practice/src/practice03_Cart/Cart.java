package practice03_Cart;

public class Cart {
	
	private Product[] products;
	private int prodCount;
	
	public Cart(int cartSize) {
		products = new Product[cartSize];	// 배열 생성
		prodCount = 0;
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
	
	// 카트에 물건 담기
	// addProduct(new Meat(1, "소고기", 5000))
	// addProduct(new Pizza(2, 고구마 피자", 3000))
	// addProduct(new Noodle(3, "누들면", 1500))
	public void addProduct(Product product) {
		if(products.length == prodCount) {
			System.out.println("카트가 가득 찼습니다.");
			return;
		}
		
		// 카트에 물건 담기
		products[prodCount ++] = product;
	}
	
	// 카트에서 물건 빼기
	// deleteProduct(1)
	// deleteProduct(2)
	// deleteProduct(3)
	public void deleteProduct(int prodNo) {
		if(prodCount == 0) {
			System.out.println("카트가 비어 있습니다.");
			return;
		}
		
		// 카트에서 물건 빼기
		for(int i=0; i<prodCount; i++) {
			if(products[i].getProdNo() == prodNo) {
				products[i] = products[prodCount -1]; // 마지막 물건을 뺀 물건 자리로 옮기기
				products[--prodCount] = null;
				break;
			}
		}
	}
	
	
}
