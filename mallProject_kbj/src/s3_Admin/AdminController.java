package s3_Admin;

import s1_Member.MemberController;
import s2_Item.ItemController;
import s4_Cart.CartController;
import s_Util.Util;

public class AdminController {
	private AdminController() {
	}

	private static AdminController instance = new AdminController();

	public static AdminController getInstance() {
		return instance;
	}

	private MemberController mCon;
	private ItemController iCon;
	private CartController cCon;
	
	public void init() {
		mCon = MemberController.getInstance();
		iCon = ItemController.getInstance();
		cCon = CartController.getInstance();
	}

	/** admin 메뉴 페이지 */
	public void adminMenu() {
		while (true) {
			System.out.println("\n_______________________ADMIN_______________________");
			System.out.println("[0]뒤로가기 [1]회원관리 [2]상품관리 [3]장바구니관리 [4]게시판관리");
			int sel = Util.getValue(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				adminMember();
			} else if (sel == 2) {
				adminItem();
			} else if (sel == 3) {
				adminCart();
			} else if (sel ==4) {
				adminBoard();
			}
		}
	}

	/** admin 회원관리페이지 */
	public void adminMember() {
		while (true) {
			System.out.println("\n_______ADMIN 회원관리________");
			System.out.println("[0]뒤로가기 [1]회원목록 [2]주문목록");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				mCon.printMember();
			} else if (sel == 2) {
				cCon.printBuy();
			}
		}
	}

	/** admin 상품관리페이지 */
	public void adminItem() {
		while (true) {
			System.out.println("\n_____________ADMIN 상품관리_____________");
			System.out.println("[0]뒤로가기 [1]전체 상품목록 [2]상품추가 [3]상품삭제");
			int sel = Util.getValue(0, 3);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				iCon.printItem();
			} else if (sel == 2) {
				iCon.addItem();
			} else if (sel == 3) {
				iCon.deleteItem();
			}
		}
	}

	/** admin 장바구니관리페이지 */
	public void adminCart() {
		while (true) {
			System.out.println("\n_____ADMIN 장바구니관리______");
			System.out.println("[0]뒤로가기 [1]전체 장바구니목록");
			int sel = Util.getValue(0, 1);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				cCon.printAdminCart();
			}
		}
	}
	
	public void adminBoard() {
		while (true) {
			System.out.println("\n_____ADMIN 게시판관리______");
			System.out.println("[0]뒤로가기 [1]전체 게시판목록 [2]공지작성 [3]게시글삭제");
			int sel = Util.getValue(0, 3);
			if(sel ==0) {
				break;
			}else if(sel==1) {
				
			}else if(sel==2) {
				
			}else if(sel==3) {
				
			}
		
		}
	}

}
