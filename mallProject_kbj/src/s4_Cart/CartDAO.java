package s4_Cart;

import java.util.ArrayList;

public class CartDAO {
	private ArrayList<Cart> clist;
	private int cartNum;
	private ArrayList<Cart> buylist;
	
	public CartDAO() {
		clist = new ArrayList<>();
		cartNum = 0;
		buylist = new ArrayList<>();
	}
	
	public int Num() {
		cartNum ++;
		return cartNum;
		
	}

	public ArrayList<Cart> getClist() {
		return clist;
	}

	public void setClist(ArrayList<Cart> clist) {
		this.clist = clist;
	}

	public ArrayList<Cart> getBuylist() {
		return buylist;
	}

	public void setBuylist(ArrayList<Cart> buylist) {
		this.buylist = buylist;
	}
	
	
}
