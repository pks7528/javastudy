package ex03_singleton;

public class MainClass {
	public static void main(String[] args) {
		
		// User 객체 가져오기
		User user1 = User.getInstance();
		System.out.println(user1);
		
		User user2 = User.getInstance();
		System.out.println(user2);
		
		System.out.println(user1 == user2); // 참조값이 같다.
		
		
	}
}
