package ex05_lombok;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@ToString			// 
@NoArgsConstructor	//	default 형태의 생성자, 매개변수가 없는 생성자
@AllArgsConstructor	// source - generate constructor using fields // 모든것을 받아오는 생성자
@Getter
@Setter
public class User {
	//필드
	private String id;
	private String pw;
	
	
}
