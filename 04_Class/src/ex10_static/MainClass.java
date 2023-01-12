package ex10_static;

public class MainClass {

	public static void main(String[] args) {
		
		// static 요소는 객체를 이용해서 호출할 수 있으나 권장하지 않는다.
		
		MyMath myMath = new MyMath();
		System.out.println(myMath.PI);
		
		MyMath yourMath = new MyMath();
		System.out.println(yourMath.PI);
	
		// myMath yourMath 둘다 pi값 생성
		// 같은값 객체 2개 생김/// 메모리 낭비
		// 하나만 만들어서 공유 -> static
		
		// static 요소는 클래스를 이용해서 호출하는 것이 권장이다.
		System.out.println(MyMath.PI);
		
		System.out.println(MyMath.getCircleArea(1.5));
		
		System.out.println(MyMath.max(1.1, 2.2, 3.3));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4));
		System.out.println(MyMath.max(1.1, 2.2, 3.3, 4.4, 5.5));
		
		System.out.println(MyMath.min(1.1, 2.2, 3.3));
		System.out.println(MyMath.min(2.2, 3.3, 4.4));
		System.out.println(MyMath.min(3.3, 4.4, 5.5));
		
		
		
		
		
	}
}
