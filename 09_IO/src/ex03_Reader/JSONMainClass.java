package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONObject;

public class JSONMainClass {
	
	public static void main(String[] args) {
	
		// C:\storate\product.json 읽기
		
		File file = new File("C:" + File.separator + "storage", "product.json");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);									// json이 대괄호로 묶여있으면 배열, 중괄호로 묶여있으면 
				
			}
			
			JSONArray arr = new JSONArray(sb.toString());
			List<Map<String, Object>> products = new ArrayList<Map<String,Object>>();
			
			for( int i=0; i<arr.length(); i++) {
				JSONObject obj = arr.getJSONObject(i);
				products.add(obj.toMap());					// JSONObject obj를 Map으로 바꿔서 List에 저장하기
				
			}
			System.out.println(products);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				} 
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
}
