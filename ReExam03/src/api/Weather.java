package api;

public class Weather {

	private Integer temp;
	private String wfKor;
	private Integer hour;
	
	public Integer getTemp() {
		return temp;
	}
	public void setTemp(Integer temp) {
		this.temp = temp;
	}
	public String getWfKor() {
		return wfKor;
	}
	public void setWfKor(String wfKor) {
		this.wfKor = wfKor;
	}
	public Integer getHour() {
		return hour;
	}
	public void setHour(Integer hour) {
		this.hour = hour;
	}
	
	@Override
	public String toString() {
		return hour + "시" + ", " + temp + "도, " + wfKor;
//		return "온도 " + temp + "도, 날씨 " + wfKor + ", 시간 " + hour + "시";
	}
	
}
