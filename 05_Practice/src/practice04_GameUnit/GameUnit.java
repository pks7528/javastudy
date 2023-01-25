package practice04_GameUnit;

public abstract class GameUnit {

	//필드
	private String name;
	private int energy;
	private int power;
	private boolean isAlive;
	
	//생성자
	public GameUnit(String name, int energy, int power) {
		super();
		this.name = name;
		this.energy = energy;
		this.power = power;
		this.isAlive = energy > 0;
	}

	//메소드
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getEnergy() {
		return energy;
	}

	public void setEnergy(int energy) {
		this.energy = energy;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public boolean isAlive() {
		return isAlive;
	}

	public void setAlive(boolean isAlive) {
		this.isAlive = isAlive;
	}
	
	public void info() {
		System.err.println(name + "(에너지 " + energy + ", 공격력 " + power + ")");
	}
	
	public abstract void attack(GameUnit unit);
	
	
	
	
	
	
}
