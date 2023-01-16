package practice04_Shape;

public class Circle implements Shape {
	
	//필드
	public double radius;
	
	//생성자
	public Circle(double radius) { 					//Shape circle = new Circle(1.5)
		super();									//circle.getArea();
		this.radius = radius;
	}
	
	@Override
	public double getArea() {
		return PI * radius * radius;
		
	}
	
	

}
