package ex03_Reader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class MainClass {
	
	/*
		Reader
		1. 문자 기반의 입력 스트림이다.
		2. Reader로 끝나는 이름의 클래스는 모두 문자 기반의 입력 스트림이다.
		3. 문자를 읽어들이는 스트림이다.(파일의 내용을 읽는다. 서버가 보낸 내용을 읽는다. 등등)
	*/
	
	public static void ex01() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		File file = new File(dir, "ex01.txt");
		
		FileReader fr = null;
		try {
			fr = new FileReader(file);
			
			int c;			// 1글자를 저장할 변수	//charactor로 모든 문자를 저장할 수 있는 것이 아니기 떄문에 char보다 용량이 큰 int 사용 // 한글자 읽는데 int 사용
		
			StringBuilder sb = new StringBuilder();		//StringBuilder에 읽어온것 다 저장
			while((c=fr.read()) != -1) {				//읽을 것이 없으면 -1 출력
				sb.append((char)c);
			}
			System.out.println(sb.toString());
					
//			while(true) {
//				c = fr.read();
//				if(c == -1) {
//					break;
//				} 
//				System.out.print((char)c);
//			}
			
		} catch (IOException e) {		// FileNotFoundException이 함께 처리된다.
			e.printStackTrace();
		} finally {
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void ex02() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex02.txt");
		
		FileReader fr = null;
		
		try {
			fr = new FileReader(file);
			char[] cbuf = new char[5];
			int readCount = 0;	// 실제로 읽은 글자의 개수
			StringBuilder sb = new StringBuilder();
			
			while((readCount = fr.read(cbuf)) != -1) {
				sb.append(cbuf, 0, readCount); // 인덱스 0부터 readCount개 글자를 sb에 추가하시오.
			
			}
			System.out.println(sb.toString());
			
//		try {
//			fr = new FileReader(file);
//			
//			char[] cbuf = new char[5];	
//			while(true) {
//				
//				// ex02.txt 읽는 과정
//				// 루프	readCount	cbuf
//				// 1	5			a b c d e 
//				// 2	2			f g c d e
//				// 3	-1			
//				
//				int readCount = fr.read(cbuf);		// readCount : 읽은 글자의 개수
//				
//				if(readCount == -1) {
//					break;
//				}
//				for(int i = 0; i<readCount; i++) {	//cbuf.length쓰면 abcdefgcde 출력
//					System.out.print(cbuf[i]);
//				}
//			}
		} catch(IOException e) {
			e.printStackTrace();
		} finally {							// Writter는 안닫으면 오류 남, Reader는 오류 잘 안남
			try {
				if(fr != null) {
					fr.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "ex03.txt");
		
		BufferedReader br = null;
		
//		try {
//			br = new BufferedReader(new FileReader(file));
//			
//			char[] cbuf = new char[5];
//			int readCount = 0;
//			StringBuilder sb = new StringBuilder();
//			
//			while((readCount = br.read(cbuf)) != -1) {
//				sb.append(cbuf, 0, readCount);
//			}
//		
//			System.out.println(sb.toString());
		
		/*
			BufferedReader의 장점
			1. 속도가 빠르다.
			2. readLine 메소드를 사용할 수 있다.
		*/
		
		try {
			br = new BufferedReader(new FileReader(file));
			
			String line = null;
			StringBuilder sb = new StringBuilder();
			while((line = br.readLine()) != null) {
				sb.append(line);
			}
			System.out.println(sb.toString());
		
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
	

	public static void main(String[] args) {
		ex03();
		
	}
}


//csv파일은 데이터 한 줄에 하나씩만
//최종적으로는 readLine을 이용해서 한줄 읽음

