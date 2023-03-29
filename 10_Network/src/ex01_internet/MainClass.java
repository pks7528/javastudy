package ex01_internet;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class MainClass {
	
	/*
		URL
		1. UniForm Resource Locator
		2. 정형화된 자원의 경로
		3. 실제로는 웹 주소를 의미한다.
		4. 구성
		   프로토콜://		호스트		/ 서버 경로	 ? 파라미터=값&파라미터=값&...				    삼성전자의 인코딩된 데이터(%EC%82%BC%EC%84%B1%EC%A0%84%EC%9E%90)
				https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=삼성전자
			1) 프로토콜 : 통신규약, https(secure + http : 보안 처리된 하이퍼텍스트 전송 프로토콜)
			2) 호스트   : 서버의 대표 주소 
			3) 서버경로 : URL Mapping(URL Pattern) - 개발자들이 만든 주소
			4) 파라미터 : 서버로 보내는 데이터를 의미(변수라고 생각)	기본적으로 물음표는 1개만 있어야 함		request.getParameter("where")
	*/
	
	public static void ex01() {
		
		String apiURL = "https://search.naver.com/search.naver?query=삼성전자";
		URL url = null;		// 예외처리 필요
		
		try {
			url = new URL(apiURL);	// 반드시 예외 처리가 필요한 코드
			
			System.out.println("프로토콜 : " + url.getProtocol());
			System.out.println("호스트   : " + url.getHost());
			System.out.println("파라미터 : " + url.getQuery());
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} 
		
		//받아오는 데이터 1. xml 2. json 형식을 이용해서 정보를 서버측이 제공하고 있다
	}

	public static void ex02() {
		
		// 웹 접속을 담당하는 HttpURLConnection
		
		String apiURL = "https://www.naver.com";
		URL url = null;
		HttpURLConnection con = null;
		
		
		try {
			
			url = new URL(apiURL);	// MalFormedURLException 처리가 필요하다.
			con = (HttpURLConnection)url.openConnection(); // IOException 처리가 필요하다.
			
			/*
				HTTP 응답 코드 공부하기
				1. 200 : 정상
				2. 40x : 잘못된 요청(사용자가 잘못하였음)
				3. 50x : 서버측 오류(서버가 잘못하였음)		// 자바 코드를 잘못짬
			*/
			
			System.out.println("정상 응답 : " + HttpURLConnection.HTTP_OK);
			System.out.println("Not Found : " + HttpURLConnection.HTTP_NOT_FOUND);
			System.out.println("Internal Error : " + HttpURLConnection.HTTP_INTERNAL_ERROR);
			
			// apiURL 접속 확인
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				System.out.println(apiURL + " 접속 완료");
			}
			
			// 요청 방식(요청 메소드)
			String requestMethod = con.getRequestMethod();
			System.out.println("요청 방식 : " + requestMethod);
			
			// 컨텐트 타입
			String contentType = con.getContentType();
			System.out.println("컨텐트 타입 : " + contentType);
			
			// 요청 헤더
			String userAgent = con.getRequestProperty("User-Agent");			// property - 속성,, 헤더의 키 값이 뭐냐
			System.out.println("User-Agent : " + userAgent);
			
			String referer = con.getRequestProperty("Referer");
			System.out.println("Referer : " + referer);	// 이전 주소가 나옴
			
			// 접속 종료
			con.disconnect();	// 생략 가능
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			System.out.println("apiURL 접속 오류");
		}
		
	}
	
	public static void ex03() {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedInputStream in = null;		// Daum 로그를 읽어 들이는 입력 스트림
		BufferedOutputStream out = null;	// C:\storage\daum.png로 내보내는 출력 스트림
		File file = new File("C:" + File.separator + "storage" + File.separator, "daum.png");
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				in = new BufferedInputStream(con.getInputStream());
				out = new BufferedOutputStream(new FileOutputStream(file));
				
				byte[] b = new byte[10];
				int readByte = 0;
				
				while((readByte = in.read(b)) != -1) {
					out.write(b, 0, readByte);					// 읽은만큼 내보내라
				}
				
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
				
			}
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			// 접속 실패 또는 스트림 관련 오류
			e.printStackTrace();
		}
	}
	
	public static void ex04() {
	
		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/_63d8848f7d506.txt";
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File file = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpsURLConnection) url.openConnection();
			
			String message = null;
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
				message = "다운로드 성공";
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				file = new File("C:" + File.separator + "storage", "다운로드실패.txt");
				message = "다운로드 실패";
			}
			
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[2];
			int readCount = 0;
			
			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println(message);
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
//		String apiURL = "https://gdlms.cafe24.com/uflist/curri/10004/bbs/68_63d8848f7d506.txt";
//		URL url = null;
//		HttpURLConnection con = null;
//		
//		InputStreamReader reader = null;
//		FileWriter writer = null;
//		File file = new File("C:" + File.separator + "storage", "다운로드문서.txt");
//		
//		try {
//			url = new URL(apiURL);
//			con = (HttpURLConnection) url.openConnection();
//			int responseCode = con.getResponseCode();
//			if(responseCode == HttpURLConnection.HTTP_OK) {
//				reader = new InputStreamReader(con.getInputStream());			// connection은 reader/writer 제공하지 않는다	// inputStreamReader //09_ex05_ex02_complete 참고
//			}else {
//				reader = new InputStreamReader(con.getErrorStream());
//			}
//			StringBuilder sb = new StringBuilder();
//			char[] cbuf = new char[2];
//			int readCount = 0;	//실제로 읽어들인 글자수
//			
//			while((readCount = reader.read(cbuf)) != -1) {
//				sb.append(cbuf, 0, readCount);
//			}
//			writer = new FileWriter(file);
//			writer.write(sb.toString());
//			
//			writer.close();
//			reader.close();
//			con.disconnect();
//			
//			System.out.println("다운로드 완료");
//			
//		} catch (MalformedURLException e) {
//			System.out.println("apiURL 주소 오류");
//		} catch(IOException e) {
//			e.printStackTrace();
//		}
	}
	
	public static void ex05() {
		
		/*
			인코딩(암호화) : 원본 데이터를 UTF-8 방식으로 암호화
			디코딩(복호화) : UTF-8 방식으로 암호화된 데이터를 복원
		*/
		
		String data = "한글 english 12345 !@#$%";
		try {
			// 인코딩	***
			String encodeData = URLEncoder.encode(data, "UTF-8");
			System.out.println(encodeData);
			
			// 디코딩
			String decodeData = URLDecoder.decode(encodeData, "UTF-8");
			System.out.println(decodeData);
			
		} catch(UnsupportedEncodingException e) {
			System.out.println("인코딩 실패");
		}
	}
	
	public static void ex06() {	// 연습
		
		// 1시간 마다 갱신되는 전국 날씨 정보
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		// storage/sfc_web_map.xml로 다운로드 받기
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File file = null;
		
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			String message = null;			
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
				file = new File("C:" + File.separator + "storage", "sfc_web_map.xml");
				message = "다운로드 성공";
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
				message = "다운로드 실패";
			}
			StringBuilder sb = new StringBuilder();
			char[] cbuf = new char[10];
			int readCount = 0;
			
			while((readCount = reader.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount);
			}
			
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			
			writer.close();
			reader.close();
			con.disconnect();
			
			System.out.println(message);
			
		} catch(MalformedURLException e) {
			System.out.println("apiURL 주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}					
}
		
	public static void main(String[] args) {
		ex06();
	}
}
