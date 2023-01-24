package s2_Item;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeSet;

public class ItemDAO {
	private ArrayList<Item> ilist;
	private int cNum;
	private TreeSet<String> categoryset;
	//private ArrayList<String> categorylist;

	public ItemDAO() {
		ilist = new ArrayList<>();
		cNum = 100;
		categoryset = new TreeSet<>();
		//categorylist = new ArrayList<>();
		ilist.add(new Item(Num(), "음료", "콜라", 1000));
		ilist.add(new Item(Num(), "음료", "사이다", 2000));
		ilist.add(new Item(Num(), "과자", "나초", 3000));
		ilist.add(new Item(Num(), "과자", "새우깡", 4000));
		
	}

//	@Override
//	public String toString() {
//		String s = "";
////		if (ilist.size() == 0) {
////			System.out.println("등록된 상품이 없습니다.");
////		}
//		for (Item m : ilist) {
//			s += "[NUM] " + m.getNum() + " [ID] " + m.getCategoryName() + " [PW] " + m.getName() + " [NAME] "
//					+ m.getPrice() + "원" + "\n";
//		}
//		return s;
//		
//	}

	
	public ArrayList<Item> getIlist() {
		return ilist;
	}

	public void setIlist(ArrayList<Item> ilist) {
		this.ilist = ilist;
	}

	/** 아이템번호 부여 */
	public int Num() {
		cNum++;
		return cNum;
	}

	/** 아이템추가시 중복 방지 */
	public boolean checkIname(String name) {
		for (Item m : ilist) {
			if (name.equals(m.getName())) {
				return true;
			}
		}
		return false;
	}

	/** 아이템 0개 체크 */
	public boolean checkSize() {
		if (ilist.size() == 0) {
			return true;
		}
		return false;
	}

	/** 카테고리이름 어레이리스트화 */
	public ArrayList<String> settingCategorylist() {
		ArrayList<String> categorylist = new ArrayList<>();
		for (int i = 0; i < ilist.size(); i++) {
			//categoryList.add(null)
			categoryset.add(ilist.get(i).getCategoryName());
		}
		Iterator<String> iterator = categoryset.iterator();
		while (iterator.hasNext()) {
			categorylist.add(iterator.next());
		}
		return categorylist;
	}
	
	/** member 1.쇼핑에서 카테고리 목록 선택시 출력될 아이템목록 , 받아오는값이 선택된 카테고리 목록 이름 */
	public ArrayList<Item> getCategoryItemList(String selcategoryname){
		ArrayList<Item> selcategoryitemlist = new ArrayList<Item>();
		for(int i = 0; i < ilist.size(); i++) {
			//Item item = ilist.get(i);
			if(selcategoryname.equals(ilist.get(i).getCategoryName())){
				selcategoryitemlist.add(ilist.get(i));
			}
		}	
		return selcategoryitemlist;
	}
}
