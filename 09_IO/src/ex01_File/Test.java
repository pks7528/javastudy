package ex01_File;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class Test {

	public static void ex01() throws IOException {
	
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists()==false	) {
			dir.mkdirs();
		}
		
		File file = new File(dir, ".txt");
		if(file.exists() == false) {
			file.createNewFile();
		} else {
			file.delete();
		}
		
		System.out.println(file.getName());
		System.out.println(file.getParent());
		System.out.println(file.getPath());
		
		System.out.println(file.isDirectory());
		System.out.println(file.isFile());
		
		long lastmodified = file.lastModified(); // 최종 수정일의 타임스탬프
		System.out.println(lastmodified);
		
		String lastmodifiedate = new SimpleDateFormat("yyyy-MM-dd").format(lastmodified);
		System.out.println(lastmodifiedate);
		
		long size = file.length();
		long kb = size/1024
	}
	
	
	public static void main(String[] args) throws IOException {
		ex01();
		
	}
}
