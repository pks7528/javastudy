package ex01_internet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class main {
	public static void ex01() {
		
		String apiURL = "https://t1.daumcdn.net/daumtop_chanel/op/20200723055344399.png";
		URL url = null;
		HttpURLConnection con = null;
		
		InputStream in = null;
		FileOutputStream out = null;
		
		try {
			
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
			
			int responseCode = con.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK) {
				
				in = con.getInputStream();
				out = new FileOutputStream("C:" + File.separator + "storage" + File.separator + "daum1.png");
				
				byte[] b = new byte[10];
				int readbyte = 0;
				
				while((readbyte = in.read(b)) != -1) {
					out.write(b, 0, readbyte);
				}
				System.out.println("다운로드 완료");
				
				out.close();
				in.close();
				con.disconnect();
			}
		} catch(MalformedURLException e	) {
			System.out.println("주소 오류");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void ex02() {
		
		// 1시간 마다 갱신되는 전국 날씨 정보
		String apiURL = "http://www.kma.go.kr/XML/weather/sfc_web_map.xml";
		
		URL url = null;
		HttpURLConnection con = null;
		
		BufferedReader reader = null;
		BufferedWriter writer = null;
		File file = null;
		String message = null;
	
		
		try {
			url = new URL(apiURL);
			con = (HttpURLConnection) url.openConnection();
		    //  openConnection 역할
	        //  - 해당 ip주소로 가서 컴퓨터 켜져있는지, 길이 실제로 있는지, ip주소가 있는지 등등 확인하고
	        //  - 오류가 없다면 Connection이 만들어짐 (아니면 catch문 탐)
			
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
			char[] cbuf = new char[5];
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
			System.out.println("url 수정");
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
	
	
	public static void main(String[] args) {
		ex02();
	}
}
