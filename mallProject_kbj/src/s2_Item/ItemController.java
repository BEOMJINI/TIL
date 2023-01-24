package s2_Item;

import java.util.ArrayList;
import java.util.Scanner;

import s4_Cart.CartController;
import s_Util.Util;

public class ItemController {
	private ItemController() {
	}

	private static ItemController instance = new ItemController();

	public static ItemController getInstance() {
		return instance;
	}

	private ItemDAO iDao;
	private Scanner sc;
	private CartController cCon;

	public void init() {
		iDao = new ItemDAO();
		sc = Util.sc;
//		iDao.getIlist().add(new Item(iDao.Num(), "음료", "콜라", 5000));
//		iDao.getIlist().add(new Item(iDao.Num(), "과자", "나초", 3000));
//		iDao.getIlist().add(new Item(iDao.Num(), "음료", "사이다", 44000));
//		iDao.getIlist().add(new Item(iDao.Num(), "과자", "새우깡", 600));
		cCon = CartController.getInstance();
	}

	/** admin 상품관리 1.상품목록 출력 */
	public void printItem() {
		System.out.println("\n[상품목록]");
		if (iDao.checkSize() == true) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		for(Item i : iDao.getIlist()) {
		System.out.println(i.toString());
		}
	}

	/** admin 상품관리 2.상품추가 */
	public void addItem() {
		System.out.println("\n[상품추가]");
		while (true) {
			System.out.print("# Name ->  ");
			String name = sc.next();
			if (iDao.checkIname(name) == true) {
				System.out.println("[중복된 상품이름]\n다른 상품이름을 사용해주세요.");
				continue;
			}
			System.out.print("# CategoryName ->  ");
			String cName = sc.next();
			// System.out.print("# Price -> ");
			int price = Util.getPrice();
			iDao.getIlist().add(new Item(iDao.Num(), cName, name, price));
			System.out.printf("\n[%s 상품추가 완료]\n", name);
			break;
		}
	}

	/** admin 상품관리 2.상품삭제 */
	public void deleteItem() {
		System.out.println("\n[상품삭제]");
		if (iDao.checkSize() == true) {
			System.out.println("등록된 상품이 없습니다.");
			return;
		}
		while (true) {
			System.out.print("# Name ->  ");
			String name = sc.next();
			if (iDao.checkIname(name) == false) {
				System.out.println("[목록에 없는 상품]\n상품이름을 확인해주세요.");
				continue;
			}
			for (int i = 0; i < iDao.getIlist().size(); i++) {
				if (name.equals(iDao.getIlist().get(i).getName())) {
					iDao.getIlist().remove(i);
					i--;
				}
			}
			System.out.printf("\n[%s 상품삭제 완료]\n", name);
			break;
		}
	}

	/** member 1.쇼핑 페이지 */
	public void memberShoppingMeun() {
		ArrayList<String> test = iDao.settingCategorylist();
		while (true) {
			System.out.println("\n[상품 카테고리 목록]");
			System.out.println("[0]뒤로가기");
			// System.out.println(test.size());
			for (int i = 0; i < test.size(); i++) {
				System.out.printf("[%d]%s\n", i + 1, test.get(i));
			}
			int sel = Util.getValue(0, iDao.settingCategorylist().size()) - 1;
			if (sel == -1) {
				break;
			} else if(sel >= 0 && sel <=iDao.settingCategorylist().size()-1){
				// gggg(int sel);
//				for (Item i : iDao.getIlist()) {
//					if (test.get(sel).equals(i.getCategoryName())) {
//						System.out.println(iDao.toString());
//					}
//				}
				while (true) {
					System.out.println("\n[0]뒤로가기");
					ArrayList<Item> list = iDao.getCategoryItemList(test.get(sel));
					for (int i = 0; i < list.size(); i++) {
						System.out.println(i + 1 + ") " + list.get(i).toString());
					}
					int choice = Util.getValue(0, list.size()) - 1;
					if (choice == -1) {
						break;
					} else if (choice>=0 && choice <= list.size()-1){
						Item i = list.get(choice);
						cCon.addCart(i);
					}
				}
				// System.out.println(iDao.getCategoryItemList(test.get(sel)).get(sel).toString());
			} 
		}
	}

	public void memberShopItemList(int sel) {
		for (int i = 0; i < iDao.getIlist().size(); i++) {
			if (iDao.settingCategorylist().get(sel).equals(iDao.getIlist().get(i).getCategoryName())) {
				System.out.println(iDao.toString());
			}
		}
	}
}
