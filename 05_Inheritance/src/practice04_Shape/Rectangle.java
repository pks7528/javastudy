package practice04_Shape;

public class Rectangle implements Shape {
	
	//필드
	private double width;
	private double height;
	
	
	//생성자
	public Rectangle(double width, double height) {
		super();
		this.width = width;
		this.height = height;
	}

	@Override
	public double getArea() {
		return width*height;
	}
	
	
}



//getter settet 참조변수일때만?? 아니네 아ㅓㄴ무아ㅓㄴ무이ㅏㅈ브안ㅁ앚ㅂ이ㅏㅁ느이ㅏㅈㅂ이ㅏㄴ망