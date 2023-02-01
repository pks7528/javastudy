package ex02_random;

import java.security.SecureRandom;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class test {
	public static void main(String[] args) {

		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd a hh-mm-ss");
		String strnow = sdf.format(now);
		System.out.println(strnow);
	}
}
