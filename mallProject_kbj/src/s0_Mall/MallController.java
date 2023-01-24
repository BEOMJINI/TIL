package s0_Mall;

import s1_Member.MemberController;
import s3_Admin.AdminController;
import s_Util.Util;

public class MallController {
	private MallController() {
	}

	private static MallController instance = new MallController();

	public static MallController getInstance() {
		return instance;
	}

	private MemberController mCon;
	private String loginId;
	private AdminController aCon;

	public void init() {
		mCon = MemberController.getInstance();
		loginId = "";
		aCon = AdminController.getInstance();
	}

	public void mallMenu() {
		// mCon.setAdmin();
		//mCon.name();
		while (true) {
			System.out.println("\n________SHOPPING________");
			System.out.println("[0]종료 [1]로그인 [2]회원가입");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				loginId = mCon.loginMenu();
				//System.out.println(loginId);
				if (loginId.equals("")) {
					System.out.println("\n[로그인실패]\n아이디 또는 비밀번호를 확인해주세요.");
				} else if (loginId.equals("admin") ) {
					System.out.println("\n[admin 로그인]");
					aCon.adminMenu();
				} else {
					System.out.printf("\n[%s 로그인]\n", loginId);
					mCon.memberMenu();
				}
			} else if (sel == 2) {
				mCon.joinMenu();

			}
		}
	}

	public String getLoginId() {
		return loginId;
	}
	
	
}
