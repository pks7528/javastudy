package ex02_random;

import java.util.UUID;

public class Ex04_UUID {
	
	public static void main(String[] args) {
	
		/*
		 	java.util.UUID
		 	1. 전역 고유 식별자(Universal Unique Identifier)
		 	2. 32개의 16진수와 4개의 하이픈(-)로 구성된 식별자 값 // -은 식별자 역할 아님,, 
		*/

		UUID uuid = UUID.randomUUID();
		String str = uuid.toString();
		
		// 하이픈(-) 모두 없애기 : 모든 하이픈(-)을 빈 문자열("")로 바꾸기
		String replacedStr = str.replace("-", "");
		System.out.println(replacedStr);
		
	
		
		// 일반적인 계산에 사용하는 랜덤은 math.random
		// 보안이 필요한 랜덤에는 securerandom
		// 중복되지 않는 랜덤값이 필요할 땐 uuid
		
		
		
	}
}
