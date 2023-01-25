package practice08_Song;

public class Song {
	
	//필드
	private String title;
	private String genre;
	
	//생성자
	public Song(String title, String genre) {
		super();
		this.title = title;
		this.genre = genre;
	}

	//메소드
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}
	
	//정보
	public void info() {
		System.out.println("[title : " + title + ", genre : " + genre +"]");
	}
	
}
