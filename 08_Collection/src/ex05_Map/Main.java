package ex05_Map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		
//		HashMap
//		1.하나의 데이터가 2개의 요소로 구성된다
//		2.용어정리
//		entry : 하나의 데이터
//		key 구성 요소, 식별자 역할
//		value 구성 요소, 실제 데이터
//		
//		주로 key는 string을 사용
//		value는 object를 사용
//		key는 중복 불가/value는 중복 가능
		
		//map은 하나의 객체

		//person정보를 HashMap으로 만들기
		Map<String, Object> person = new HashMap<String, Object>();
		
		//추가
		//put(key, value)
		person.put("name", "홍길동");
		person.put("age", 30);
		
		//수정
		person.put("age", 40);
		
		//삭제
		int age = (int)person.remove("age");
		System.out.println(age);
		System.out.println(person);
		
		Map<String, String> dictionary = new HashMap<String, String>();
		dictionary.put("spring", "봄");
		dictionary.put("summer", "여름");
		dictionary.put("autumn", "가을");
		dictionary.put("winter", "겨울");
		
//		//맵 순회
//		//1. key만 모두 가져온 뒤 key와 value분리
//		Set<String> keySet = dictionary.keySet();
//		System.out.println(keySet);
		
		for(Entry<String, String> entry : dictionary.entrySet()) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
		
		// title, author, price로 구성되는 책 hashmap
		// 책 3권이 저장된 arraylist
		
		Map<String, Object> book1 = new HashMap<String, Object>();
		book1.put("title", "어린왕자");
		book1.put("author", "생택쥐 베리");
		book1.put("price", 10000);
		Map<String, Object> book2 = new HashMap<String, Object>();
		book2.put("title", "성냥팔이 소녀");
		book2.put("author", "안데르센");
		book2.put("price", 20000);
		Map<String, Object> book3 = new HashMap<String, Object>();
		book3.put("title", "소나기");
		book3.put("author", "황순원");
		book3.put("price", 30000);
		
		List<Map<String, Object>> books = new ArrayList<Map<String,Object>>();
		books.add(book1);
		books.add(book2);
		books.add(book3);
		
		
		
		//list 순회
		for(int i=0, length=books.size(); i<length; i++) {
			//map의 순회
			Map<String, Object> book = books.get(i);
			System.out.println( (i+1)+"번째 책의 정보");
			for(Entry<String, Object> entry : book.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		
		
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
