package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

import org.json.JSONArray;

public class JSON {
	public static void main(String[] args) {
		
		File file = new File("C:" + File.separator + "storage", "product.json");
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			JSONArray arr = new JSONArray(sb.toString());
			
		}
	}
}
