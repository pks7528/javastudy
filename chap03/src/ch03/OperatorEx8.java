package ch03;

public class OperatorEx8 {

	public static void main(String[] args) {
		int a = 1_000_000;
		int b = 2_000_000;
		
//		long c = a*b; //int�� int�� �������� intŸ���̴�.
		long c = (long)a*b;
		System.out.println(c);
	}

}
