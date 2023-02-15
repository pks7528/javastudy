package ex04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSON {
	
	public static void ex01() {
		
		//측정소별 실시간 측정정보 조회
		String serviceKey = "lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt/amPC9Uu4aYvSl4ANX7/2/q1ag1cDx+Oj7dZO0ntuLfO3Fk39fmtfCg==";
		String apiURL = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMsrstnAcctoRltmMesureDnsty";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			
			String stationName = "종로구";
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&returnType=json");
			sbURL.append("&stationName=" + URLEncoder.encode(stationName, "UTF-8"));
			sbURL.append("&dataTerm=DAILY");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET"); // 웹페이지 주소를 
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			
			//byte가 스트림을 받아서 reader가 문자로 변환해서 buffer로 속도를 올림
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) { // readline은 한줄단위로 읽음, 라인단위로 받아온것을 스트림빌드에 넣음
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			//System.out.println(sb.toString());
			
			//대괄호는 배열이어서 jsonarray로 받음 없으면 object
			// 
			JSONArray items = new JSONObject(sb.toString())
											.getJSONObject("response")
											.getJSONObject("body")
											.getJSONArray("items");
			
//			List<Map<String, Object>> list = new ArrayList<>();
			List<JSONObject> list = new ArrayList<>();
			
			
			for(int i=0; i<items.length(); i++) {
				JSONObject item = items.getJSONObject(i);
//				list.add(item.toMap());
				list.add(item);
				String dataTime = item.getString("dataTime");
				String coValue = item.getString("coValue");
				String coGrade = item.getString("coGrade");
				String pm10Grade = item.getString("pm10Grade");
				//String coFlag = item.getString("coFlag"); 일산화탄소플래그
				
				
//				System.out.println("측정일 : " + dataTime + "일산화탄소농도 : " + coValue + " 일산화탄소지수: " 
//										+ coGrade + " 미세먼지24시간등급 : " + pm10Grade);
//				
//				arraylist 출력
				System.out.println(list.get(i));
//				System.out.println();
				
			}
			File file = new File("C:" + File.separator + "storage", "api테스트.JSON");
			writer = new BufferedWriter(new FileWriter(file));
			
			for(int i=0; i<list.size(); i++) {
				writer.write(list.get(i).toString()); //write에는 string만 들어갈수있음. 
			}
			
			writer.close();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
	
	
	public static void main(String[] args) {
		ex01();
	}
}
