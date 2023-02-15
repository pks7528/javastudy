package api;

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

public class ApiMain {

	public static void main(String[] args) {
		
		String serviceKey = "lIiaVHQPSbv8hKaGqyz4QW8vgsxqagt/amPC9Uu4aYvSl4ANX7/2/q1ag1cDx+Oj7dZO0ntuLfO3Fk39fmtfCg==";
		String apiURL = "http://apis.data.go.kr/B552061/AccidentDeath/getRestTrafficAccidentDeath";
		URL url = null;
		HttpURLConnection con = null;
		BufferedReader reader = null;
		BufferedWriter writer = null;
		
		try {
			StringBuilder sbURL = new StringBuilder();
			sbURL.append(apiURL);
			sbURL.append("?serviceKey=" + URLEncoder.encode(serviceKey, "UTF-8"));
			sbURL.append("&type=json");
			sbURL.append("&searchYear=2021");
			sbURL.append("&siDo=1100");
			sbURL.append("&guGun=1125");
			sbURL.append("&numOfRows=10");
			sbURL.append("&pageNo=1");
			
			url = new URL(sbURL.toString());
			con = (HttpURLConnection) url.openConnection();
			
			con.setRequestMethod("GET");
			con.setRequestProperty("Content-Type", "application/json; charset=UTF-8");
			
			if(con.getResponseCode() == HttpURLConnection.HTTP_OK) {
				reader = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else {
				reader = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = reader.readLine()) != null) {
				sb.append(line);
			}
			
			reader.close();
			con.disconnect();
			System.out.println(sb.toString());
			
//			JSONArray items = new JSONObject(sb.toString())
//							            .getJSONObject("items")
//							            .getJSONArray("item");
//							   
//		    List<Map<String, Object>> list = new ArrayList<>();
//		      
//	        for(int i = 0; i < items.length(); i++) {
//		         
//	        	JSONObject item = items.getJSONObject(i);
//		        list.add(item.toMap());
//		        String occrrncdt = item.getString("occrrncdt");
//		        String occrrncdaycd = item.getString("occrrncdaycd");
//		        int dthdnvcnt = item.getInt("dthDnvCnt");
//		        int injpsncnt = item.getInt("injpsnCnt");
//	          
//		        System.out.println("발생월일시 : " + occrrncdt);
//		        System.out.println("발생요일코드 : " + occrrncdaycd);
//		        System.out.println("사망자수 : " + dthdnvcnt);
//		        System.out.println("부상자수 : " + injpsncnt);
//
//			}
//			
//			
//			File file = new File("accident.txt");
//			writer = new BufferedWriter(new FileWriter(file));
//			
//			for(int i=0; i<list.size(); i++) {
//				writer.write(list.get(i).toString());
//			}
//			writer.close();
//		
		
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
