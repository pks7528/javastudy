package practice;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.json.JSONArray;

public class MainClass {
	
	// 문제 1. 현재 시간을 이용하여 디렉터리를 생성하시오.
	// 예시) 
	// C:\14\31\30
	
	public static void ex01() {
		
		LocalTime now = LocalTime.now();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();
		
		String sep = File.separator;
		File dir = new File("C:" + sep + hour + sep + minute + sep + second);
		
		if(dir.exists() == false) {
			dir.mkdirs();
		} 
	}
	
	// 문제2. C:\Program Files\Java\jdk-11.0.17 경로의 파일 목록을 아래와 같이 출력하시오.
		/*
		2023-01-04  오후 02:19    <DIR>          bin
		2023-01-04  오후 02:19    <DIR>          conf
		2023-01-04  오후 02:19    <DIR>          include
		2023-01-04  오후 02:19    <DIR>          jmods
		2023-01-04  오후 02:19    <DIR>          legal
		2023-01-04  오후 02:19    <DIR>          lib
		2023-01-04  오후 02:19               160 README.html
		2023-01-04  오후 02:19             1,302 release
		               2개 파일               1,462 바이트
		*/
	
	public static void ex02() throws IOException { // lastmodified dir 
		
		File dir = new File("C:" + File.separator + "Program Files" + File.separator + "Java" + File.separator +"jdk-11.0.17");
		if(dir.exists()) {
			
			File[] list = dir.listFiles();
			
			int fileCount = 0;
			long totalFileSize = 0;
			
			for(File file : list) {
				if(file.isHidden()) {
					continue;
				}
				String lastModifiedDate = new SimpleDateFormat("yyyy-MM-dd  a hh:mm \t").format(file.lastModified());
				String directory = file.isDirectory() ? "<DIR>" : "";
				String size = "";
				if(file.isFile()) {
					long length = file.length();
					size =  new DecimalFormat("#,##0").format(length); 
					fileCount++;
					totalFileSize += length;
				}
				String name = file.getName();
				String result = String.format("%s%9s%9s %s\n", lastModifiedDate, directory, size, name);
				System.out.print(result);
			}
			System.out.println(fileCount + "개 파일" + new DecimalFormat("#,##0").format(totalFileSize) + "바이트");
		}
			
}
		
	// 문제3. C:\storage 디렉터리를 삭제하시오.
	// 파일이 저장된 디렉터리는 지워지지 않으므로 먼저 디렉터리에 저장된 파일을 삭제해야 한다.
	public static void ex03() {
		
		File dir = new File("C:" + File.separator + "storage");
		
		File file = new File(dir, "myfile.txt");
		if(file.exists()) {
			file.delete();
		}
		
		if(dir.exists()) {
			dir.delete();
		}
		
		
		
	}
	
	// 문제4. 사용자로부터 입력 받은 문자열을 C:\storage\diary.txt 파일로 보내시오.
	// 총 5개 문장을 입력 받아서 보내시오.
	public static void ex04() {
		
		Scanner sc = new Scanner(System.in);
		
		String[] sentences = new String[5];
		System.out.println("5문장을 입력하세요.");
		for(int i=0; i<sentences.length; i++) {
			sentences[i] = sc.nextLine();
			
		}
		
		File dir = new File("C:" + File.separator + "storage");
		if(dir.exists() == false) {
			dir.mkdirs();
		}
		
		File file = new File(dir, "diary.txt");
		
		try(PrintWriter out = new PrintWriter(file)){
			for(int i=0; i<sentences.length; i++) {
				out.println(sentences[i]);
			}
			System.out.println("diary.txt 파일이 생성되었다.");
		} catch (IOException e) {
			e.printStackTrace();
		} 
		sc.close();
	}
	
	// 문제5. 예외가 발생한 경우 예외 메시지와 예외 발생시간을 저장한 C:\storage\log.txt. 파일을 생성하시오.
	// 예시)
	// 2023-01-26 12:08:30 / by zero
	public static void ex05() {
		
		try {
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("첫 번째 정수를 입력하세요 >>>");
			int number1 = sc.nextInt();
			
			System.out.print("두 번째 정수를 입력하세요 >>>");
			int number2 = sc.nextInt();
			
			int add = number1 + number2;
			int sub = number1 - number2;
			int mul = number1 * number2;
			int div = number1 / number2;
			
			System.out.println(number1 + "+" + number2 + "=" + add);
			System.out.println(number1 + "+" + number2 + "=" + sub);
			System.out.println(number1 + "+" + number2 + "=" + mul);
			System.out.println(number1 + "+" + number2 + "=" + div);
			
			sc.close();
			
		} catch(Exception e) {
			
			// 날짜
			LocalDateTime now = LocalDateTime.now();
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			String dateTime = dtf.format(now);
			
			// 예외 클래스 이름
			String className = e.getClass().getName();
			
			// 예외 메시지
			String message = e.getMessage();
			
			// 로그 파일 만들기
			File dir = new File("C:" + File.separator + "storage");
			if(dir.exists() == false) {
				dir.mkdirs();
			}
			File file = new File(dir, "log.txt");
			
			// 생성 모드(언제나 새로 만든다.) new FileWriter(file)
			// 추가 모드(기존 내용에 추가한다.) new FIleWriter(file, true)
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(file, true))){
				bw.write(dateTime + " " + className + " " + message + "\n");
				//bw.newLine();		\n을 대신할 수 있는 코드
				
				System.out.println("예외 메시지가 log.txt파일에 기록되었습니다.");
			} catch (Exception e2) {
				e2.printStackTrace(); 
			}
			
		}
		
	}
	
	// 문제4 실행후 6 작업
	// 문제6. C:\storage\diary.txt 파일을 C:\storate2\diary.txt 파일로 이동하시오.(복사 후 원본 제거) 제거는 file클래스, 복사는 reader 클래스 참고
	public static void ex06() {
        
		File from = new File("C:" + File.separator + "storage", "diary.txt");
		
		File toDir = new File("C:" + File.separator + "storage2");
		if(toDir.exists() == false) {
			toDir.mkdirs();
		}
		File to = new File(toDir, from.getName());
		
		BufferedReader br = null;
		BufferedWriter bw = null;
		
		try {
			br = new BufferedReader(new FileReader(from));
			bw = new BufferedWriter(new FileWriter(to));
			
			String line = null;
			while((line = br.readLine()) != null) {
				bw.write(line);
				bw.newLine();
			}
			
			bw.close();
			br.close();
			
			if(from.length() == to.length()) {
				from.deleteOnExit();
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
		
		
		
		
//		File file = new File("C:" + File.separator + "storage", "diary.txt");
//		BufferedReader br = null;
//		
//		try {
//			br = new BufferedReader(new FileReader(file));
//			
//			String line = null;
//			StringBuilder sb = new StringBuilder();
//			while((line = br.readLine()) != null) {
//				sb.append(line);
//			}
//			System.out.println(sb.toString());
//			
//			File dir = new File("C:" + file.separator + "storage2");
////			if(dir.exists() == false) {
////				dir.mkdirs();
////			}
//			File file2 = new File(dir, "diary.txt");
//			if(file.exists() == false) {
//				file.createNewFile();
//			}
//			
//			file2 = file;
//			
//		} catch(IOException e) {
//			e.printStackTrace();
//		} finally {
//			try {
//				if(br != null) {
//					br.close();
//				}
//			} catch (IOException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	
	// 문제7. System.in은 키보드로부터 바이트 데이터를 입력 받는 InputStream이다. 
	//		  System.in으로부터 문장 1개를 입력받아서 출력하시오.
	//		  Scanner 대신 BufferedReader를 사용하시오.
	
	public static void ex07() {
		// 입력은 바이트스트림,,을 문자스트림으로 바꿀것
		
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(System.in)); // 키보드로 들어오는 데이터가 문자로 바뀌고 속도 향상
			
			System.out.print("문장 입력 >>> ");
			String sentence = br.readLine();	// 엔터누르면 입력 끝
			System.out.println("입력된 문장 : " + sentence);
			
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if(br != null) {
					br.close();
				}
			} catch(IOException e) {
				e.printStackTrace();
			}
			
		}
	}


	// 문제8. C:\GDJ61\installer\eclipse-jee-2021-03-R-win32-x86_64.zip 파일을 
	//		  C:\storage\eclipse.zip으로 복사하시오
	public static void ex08() {				// 실서비스에서 사용할 수 있으므로.....공부
		
		File from = new File("C:" + File.separator + "GDJ61" + File.separator + "installer", "eclipse-jee-2021-03-R-win32-x86_64.zip");
		File to = new File("C:" + File.separator + "storage", "eclipse.zip");

		BufferedInputStream bin = null;
		BufferedOutputStream bout = null;
		
		try {
			bin = new BufferedInputStream(new FileInputStream(from));
			bout = new BufferedOutputStream(new FileOutputStream(to));
			
			byte[] b = new byte[1024];	// 1킬로 바이트
			int readByte = 0;
			while((readByte = bin.read(b)) != -1) {
				bout.write(b, 0, readByte);	// 배열 b의 인덱스 0부터 readByte개 데이터를 사용한다.
			}
			System.out.println("복사완료");
		} catch(IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if( bout != null) {bout.close();}
				if( bin != null) {bin.close();}
			} catch(IOException e) {
				e.printStackTrace();
			}
		}
	} 
	
	public static void main(String[] args) {
		ex08();
	}
	
	
}
