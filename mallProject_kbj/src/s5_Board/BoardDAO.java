package s5_Board;

import java.util.ArrayList;

public class BoardDAO {
	private ArrayList<Board> blist;
	
	public BoardDAO() {
		blist = new ArrayList<>();
		
	}

	public ArrayList<Board> getBlist() {
		return blist;
	}

	public void setBlist(ArrayList<Board> blist) {
		this.blist = blist;
	}
	
	
}
