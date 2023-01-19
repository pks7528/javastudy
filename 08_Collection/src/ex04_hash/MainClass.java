package ex04_hash;

import java.util.HashSet;
import java.util.Set;

public class MainClass {

	public static void main(String[] args) {

		User user1 = new User("admin", "1245");
		User user2 = new User("admin", "1245");
		
		Set<User> set = new HashSet<User>();
		set.add(user1);
		set.add(user2);
		
		System.out.println(set);
		
		
//객체 비교하려면 equals필요
//equals없으면 참조값만 비교함.. 
//source - 자동완성
	}

}
