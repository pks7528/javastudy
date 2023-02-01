package ex03_api;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

public class XMLMainClass {
	
	public static void ex01() {
		
		/*
			한국공항공사_항공기 운항정보 : 공항 코드 정보
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList
			2. 요청변수(Request Parameter)
				1) ServiceKey : 인증키
		*/
		
//		encodingKey  활용 - 비추천
//		String serviceKey = "lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt%2FamPC9Uu4aYvSl4ANX7%2F2%2Fq1ag1cDx%2BOj7dZO0ntuLfO3Fk39fmtfCg%3D%3D\r\n";
//		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
//		apiURL += "?serviceKey=" + encodingKey;
		
//		decodingKey 활용
		String serviceKey = "lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt/amPC9Uu4aYvSl4ANX7/2/q1ag1cDx+Oj7dZO0ntuLfO3Fk39fmtfCg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/AirportCodeList/getAirportCodeList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"); // 주소창에 파라미터를 붙여서 쓰는 방식 = get방식
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");	// 반드시 대문자로 적을 것
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");		// xml 데이터 타입
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//read(), read(char[] cbuf), readLine() 리드라인은 버퍼드리더에서만 사용가능
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}

			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "공항코드정보.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("공항코드정보.xml이 생성되었습니다.");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public static void ex02() {
		
		/*
			한국공항공사_항공기 운항정보 : 국제선 운항 스케줄
			1. 서비스 URL : http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList
			2. 요청변수(Request Parameter)
				1) ServiceKey 		: 인증키
				2) pageNo 			: 조회할 페이지 번호
				3) schDate			: 검색일자
				4) schDeptCityCode	: 도착 도시 코드
				5) schArrvCityCode	: 출항 도시 코드
		*/
		
		
		String serviceKey = "lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt/amPC9Uu4aYvSl4ANX7/2/q1ag1cDx+Oj7dZO0ntuLfO3Fk39fmtfCg==";
		String apiURL = "http://openapi.airport.co.kr/service/rest/FlightScheduleList/getIflightScheduleList";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			apiURL += "?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8");
			apiURL += "&pageNo=1";
			apiURL += "&schDate=20230201";
			apiURL += "&schDeptCityCode=ICN";
			apiURL += "&schArrvCityCode=JFK";	// 인코딩 필요하면 위에거 처럼 인코딩해야함
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");	// 반드시 대문자로 적을 것
			con.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");		// xml 데이터 타입
			
			int responseCode = con.getResponseCode();
			
			if(responseCode == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			//read(), read(char[] cbuf), readLine() 리드라인은 버퍼드리더에서만 사용가능
			String line = null;
			StringBuilder sb = new StringBuilder();
			
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}

			reader.close();
			con.disconnect();
			
			File file = new File("C:" + File.separator + "storage", "국제선 운항 스케줄.xml");
			writer = new BufferedWriter(new FileWriter(file));
			writer.write(sb.toString());
			writer.close();
			
			System.out.println("국제선 운항 스케줄.xml이 생성되었습니다.");
			
		} catch(UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch(MalformedURLException e) {
			e.printStackTrace();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ex02();
		
	}
}
