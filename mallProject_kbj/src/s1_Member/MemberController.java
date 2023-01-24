package s1_Member;

import java.util.Scanner;

import s2_Item.ItemController;
import s4_Cart.CartController;
import s5_Board.BoardController;
import s_Util.Util;

public class MemberController {
	private MemberController() {
	}

	private static MemberController instance = new MemberController();

	public static MemberController getInstance() {
		return instance;
	}

	private MemberDAO mDao; // = new MemberDAO();
	private Scanner sc;
	private ItemController iCon;
	private CartController cCon;
	private BoardController bCon;

	// 로그인 메뉴 , 회원가입 메뉴 , init
	// setAdmin
	public void init() {
		mDao = new MemberDAO();
		mDao.getMlist().add(new Member(1, "admin", "admin", "admin"));
		sc = Util.sc;
		iCon = ItemController.getInstance();
		cCon = CartController.getInstance();
		bCon = BoardController.getInstance();
	}

//	/** admin 세팅 */
//	public void setAdmin() {
//		mDao.getMlist().add(new Member(1, "admin", "admin", "admin"));
//
//	}

//	public void name() {
//		System.out.println(mDao.getMlist().get(0).getId());
//	}

	/** 로그인 페이지 */
	public String loginMenu() {
		System.out.println("\n[로그인]");
		System.out.print("# ID ->  ");
		String id = sc.next();
		System.out.print("# PW ->  ");
		String pw = sc.next();
		if (mDao.checkLogin(id, pw) == true) {
			// System.out.printf("\n[%s 로그인]\n",id);
			return id;
		}
		return "";
	}

	/** 회원가입 페이지 */
	public void joinMenu() {
		System.out.println("\n[회원가입]");
		while (true) {
			System.out.print("# ID ->  ");
			String id = sc.next();
			if (mDao.checkId(id) == true) {
				System.out.println("[중복된 아이디]\n다른 아이디를 사용해주세요.");
				continue;
			}
			System.out.print("# PW ->  ");
			String pw = sc.next();
			System.out.print("# NAME ->  ");
			String name = sc.next();
			mDao.getMlist().add(new Member(mDao.Num(), id, pw, name));
			System.out.printf("\n[%s 가입 완료]\n", id);
			break;
		}
	}

	/** admin회원관리 1.회원목록 출력 */
	public void printMember() {
		System.out.println("\n[회원목록]");
//		if(mDao.checkMSize()==true) {
//			System.out.println("등록된 회원이 없습니다.");
//		}
		System.out.println(mDao.toString());
	}
	
	public void memberMenu() {
		while(true) {
			System.out.println("\n____________MEMBER____________");
			System.out.println("[0]종료 [1]쇼핑 [2]장바구니 [3]게시판");
			int sel = Util.getValue(0, 3);
			if(sel ==0) {
				break;
			}else if (sel==1) {
				iCon.memberShoppingMeun();
			}else if (sel==2) {
				cCon.printCart();
			}else if (sel==3) {
				bCon.printBoard();
			}
		}
	}
}
