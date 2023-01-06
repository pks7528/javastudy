package ch03;

public class OperatorEx8 {

	public static void main(String[] args) {
		int a = 1_000_000;
		int b = 2_000_000;
		
//		long c = a*b; //int와 int의 연산결과는 int타입이다.
		long c = (long)a*b;
		System.out.println(c);
	}

}
