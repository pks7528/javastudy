package c;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeMap;

////// collection은 데이터 저장

public class main {

	public static void ex01() {
		
//		ArrayList<String> list = new ArrayList<String>();
		
		
		List<String> list = new ArrayList<String>();
		
		//추가
		list.add("봄");
		list.add("여름");
		list.add("가을");
		list.add("겨울");
		
		//하나씩 꺼내기
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		for(int i = 0; i<list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("---");
		
		for(String season : list) {
			System.out.println(season);
		}
		
//		 	일반 for문과 향상 for문의 차이점
//		
//			int[] arr = new int[3];
//			arr[0] = 10;
//			arr[1] = 20;
//			arr[2] = 30;
//		
//			for(int i = 0; i<arr.length; i++){
//				arr[i] += 10; // 20, 30, 40	
//			}
//			System.out.println(Arrays.toString(arr));
//			
//			for(int n : arr){
//				n += 10;	// 10, 20, 30
//			}
//			System.out.println(Arrays.toString(arr));
//  			
//			for은 배열 요소 자체, 향상 for는 배열요소를 복사받은 또 다른 배열
		
	}
	
	public static void ex02() {
		
		//treemap은 순서관련 특징
//		TreeMap<Integer, String> treeMap = new TreeMap<Integer, String>();
//		treeMap.put(90, "제시카");
//		treeMap.put(100, "블랑카");
//		treeMap.put(50, "제레미");
//		treeMap.put(80, "사만다");
//		
//		System.out.println(treeMap.descendingMap());
		
		
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(1, "a");
		map.put(10, "b");
		map.put(101, "c");
		map.put(11, "d");
		System.out.println(map);
	}
	
	public static void ex03() {
		
		String name = "제시카";
		String phone = "010-1111-2222";
		int age = 20;
		
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", name);
		map.put("phone", phone);
		map.put("age", age + "");
		
		System.out.println(map);
	}
	
	public static void ex04() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("service-Key", "kasjdhsak");
		map.put("Content-Type", "application/xml");
		
		System.out.println(map.get("service-Key"));	// map 호출하는 방법
		System.out.println(map.get("Content-Type"));
		ex05(map);
	}
	
	public static void ex05(Map<String, Object> map) {
		//ex04에서 맵을 받을수있는 매개변수 입력하고 출력하는...
		//맵의 반복문 사용
		//04에서 맵을 만들어서 하나로 만든 후 05로 보낸 후에 출력을 하기 위해 나시 쪼개서 하나씩 호출
		
//		아래 식과 동일
//					↓ 타입
//		Set<Entry<String, Object>> set = map.entrySet();
//		for( Entry<String, Object> entry : set ) {
//			
//		}
		
		// 맵에서 key 하나씩 잘라주는 역할 keyset
		// 맵에서 entry 하나씩 잘라주는 역할 entryset
		for( Entry<String, Object> entry : map.entrySet() ) {
			System.out.println(entry.getKey() + " : " + entry.getValue());
		}
	}
	
	public static void main(String[] args) {
		ex04();
	}
}
