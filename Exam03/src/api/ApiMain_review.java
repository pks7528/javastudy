package api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

public class ApiMain_review {
	public static void main(String[] args) {
		
		try {
			// API주소 완성
			String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
			apiURL += "?serviceKey=" + URLEncoder.encode("lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt/amPC9Uu4aYvSl4ANX7/2/q1ag1cDx+Oj7dZO0ntuLfO3Fk39fmtfCg==", "UTF-8");
			apiURL += "&searchYear=" + URLEncoder.encode("2021", "UTF-8"); 
			apiURL += "&siDo=" + URLEncoder.encode("1100", "UTF-8"); 
			apiURL += "&guGun=" + URLEncoder.encode("1125", "UTF-8"); 
			apiURL += "&type=" + URLEncoder.encode("json", "UTF-8"); 
			apiURL += "&numOfRows=" + URLEncoder.encode("10", "UTF-8"); 
			apiURL += "&pageNo=" + URLEncoder.encode("1", "UTF-8"); 
			
			// URL 객체 생성(API주소의 형식 검증)
			URL url = new URL(apiURL);
			
			// API주소로 접속
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			
			// GET 방식의 요청임을 처리
			con.setRequestMethod("GET");	// GET방식 : 주소창에 파라미터 주렁주렁 매달아 요청하는 방식
			
			// 응답 데이터는 "json" 임을 처리
			// 웹 상에서 주고 받는 데이터의 타입 : Content-Type
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");	//[; charset=UTF-8] 생략 가능
			
			// 접속된 API로부터 데이터를 읽어 들일 입력 스트림 생성
			// 1. 정상 스트림과 에러 스트림으로 구분해서 생성
			// 2. API 입력 스트림은 오직 바이트 입력 스트림만 지원하므로 문자 입력 스트림으로 바꾸는 작업이 필요하다.
			// 3. 속도 향상을 위해서 Buffer가 내장된 스트림을 생성
			BufferedReader reader = null;
			if(con.getResponseCode() == 200) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			// BufferedReader는 readLine 메소드를 지원한다.
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			// 이제 API의 응답 데이터는 sb에 저장되어 있다.
			// System.out.println(sb.toString());
			
			// API의 응답 데이터를 분석하기 위해서 JSONObject로 변환한다.
			// json 라이브러리 사용을 위해서 Build Path 작업을 수행한다.
//			JSONObject obj = new JSONObject(sb.toString()); 
//			JSONObject items = obj.getJSONObject("items");
//			JSONArray itemList = items.getJSONArray("items");
			
			JSONArray itemList = new JSONObject(sb.toString())
									.getJSONObject("items")
									.getJSONArray("item");
			
			List<Accident_review> list = new ArrayList<Accident_review>();	// accident 9개를 한번에 저장하기 위해 arraylist 사용
			for(int i = 0; i<itemList.length(); i++) {
				// 응답 데이터에서 필요한 데이터를 분석(파싱)한다.
				JSONObject item = itemList.getJSONObject(i);
				String occrrncDt = item.getString("occrrnc_dt");			// 4개의 정보가 하나의 데이터가 되기 위해서 Bean이나 Map으로 만들어야 함
				String occrrncDayCd = item.getString("occrrnc_day_cd");		// Accident 클래스를 만들어서 4개의 데이터를 저장시켜라
				int dthDnvCnt	= item.getInt("dth_dnv_cnt");
				int injpsnCnt = item.getInt("injpsn_cnt");
				
				// 응답 데이터에서 추출한 데이터를 하나의 객체(Bean)으로 만든다.
				Accident_review accident = new Accident_review();
				accident.setOccrrncDt(occrrncDt);
				accident.setOccrrncDayCd(occrrncDayCd);
				accident.setDthDnvCnt(dthDnvCnt);
				accident.setInjpsnCnt(injpsnCnt);
				// 객체를 ArrayList엣 저장한다.
				list.add(accident);
									
//				System.out.println("발생월일시 : " + occrrncDt);
//		        System.out.println("발생요일코드 : " + occrrncDayCd);
//		        System.out.println("사망자수 : " + dthDnvCnt);
//		        System.out.println("부상자수 : " + injpsnCnt);
//		        System.out.println("----------");
		        
				
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
}
