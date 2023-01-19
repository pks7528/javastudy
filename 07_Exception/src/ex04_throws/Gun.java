package ex04_throws;


public class Gun {
	
	private int bullet;
	public static final int MAX_BULLET = 10;
	
	// 총알 넣기
	public void reload(int bullet) throws RuntimeException {	// reload 메소드를 호출하는 곳으로 예외를 던지겠다.
		if(this.bullet + bullet > MAX_BULLET) {
			throw new RuntimeException("장전 불가능");
		}
		this.bullet += bullet;
		
	}
	
	// 총 쏘기								// 한번에 try catch 처리
	public void shoot() throws RuntimeException {
		if(bullet == 0) {
			throw new RuntimeException("총알 부족");
		}
		bullet--;
	}
	
	
	// 메소드								// final은 수정 못하니까 public static으로 하고 // gettet setter 만들필요 없음
	public int getBullet() {
		return bullet;
	}

	public void setBullet(int bullet) {
		this.bullet = bullet;
	}
	
	
	
	
	
	
	
	
}
