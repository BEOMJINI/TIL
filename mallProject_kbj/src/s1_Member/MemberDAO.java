package s1_Member;

import java.util.ArrayList;

public class MemberDAO {
	private ArrayList<Member> mlist;
	private int mNum;
	// private String loginId;

	public MemberDAO() {
		mlist = new ArrayList<>();
		mNum = 1000;
		// loginId = null;
	}

	@Override
	public String toString() {
		//System.out.println(mlist);
		String s = "";
		for(Member m : mlist) {
			s+= "[NUM] "+m.getNum()+" [ID] "+m.getId()+" [PW] "+m.getPw()+" [NAME] "+m.getName()+"\n";
		}
		return s;
	}

	public ArrayList<Member> getMlist() {
		return mlist;
	}

	public void setMlist(ArrayList<Member> mlist) {
		this.mlist = mlist;
	}

	public int getmNum() {
		return mNum;
	}

	public void setmNum(int mNum) {
		this.mNum = mNum;
	}

//	public String getLoginId() {
//		return loginId;
//	}
//
//	public void setLoginId(String loginId) {
//		this.loginId = loginId;
//	}
	/** 아이디 , 비밀번호 일치 체크 */
	public boolean checkLogin(String id, String pw) {
		for (Member m : mlist) {
			if (id.equals(m.getId()) && pw.equals(m.getPw())) {
				// loginId = id;
				return true;
			}
		}
		return false;
	}

	/** 중복 아이디 체크 */
	public boolean checkId(String id) {
		for (Member m : mlist) {
			if (id.equals(m.getId())) {
				return true;
			}
		}
		return false;
	}

	/** 멤버번호 부여 */
	public int Num() {
		mNum++;
		return mNum;
	}
	
//	/** 멤버 0명 체크 */
//	public boolean checkMSize() {
//		if (mlist.size() == 0) {
//			return true;
//		}
//		return false;
//	}
}
