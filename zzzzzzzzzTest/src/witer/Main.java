package witer;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex01.txt");
		FileWriter fw = null;
		try {
			fw = new FileWriter(file); 
			
			int c = 'I';
			char[] cbuf = {' ', 'a', 'm'};
			String str = "boy";
			
			fw.write(c);
			fw.write(cbuf);
			fw.write(str);
			
			System.out.println("ex01.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) {
					fw.close();
				} 
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex04() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex04.txt");
		
		FileWriter fw = null;
		
		try(BufferedWriter bw = new BufferedWriter(fw)){
			bw.write("Hello World");
			System.out.println("ex04.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		ex04();
		
		
	}
}
