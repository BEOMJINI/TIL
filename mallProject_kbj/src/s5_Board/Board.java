package s5_Board;

public class Board {
	private String title;
	private String info;
	//private int num;
	
	public Board(String title, String info) {
		super();
		this.title = title;
		this.info = info;
		//this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public String getInfo() {
		return info;
	}
	@Override
	public String toString() {
		
		return "[Title] " + title;
	}
	
	
	
	
}
