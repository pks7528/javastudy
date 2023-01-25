package practice02_Bus;

public class MainClass {
	public static void main(String[] args) {
		
		Bus bus = new Bus(10);
		
		bus.riding(1, new Person("홍길동"));
		bus.riding(1, new Person("도깨비"));
		bus.riding(3, new Person("김두한"));
		bus.riding(11, new Person("공유"));
		
		bus.info();
	}
}
