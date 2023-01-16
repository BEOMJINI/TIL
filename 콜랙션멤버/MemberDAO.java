package 콜랙션멤버;

import java.util.ArrayList;
import java.util.Arrays;

public class MemberDAO {
	private MemberDAO() {
		init();
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getIntance() {
		return instance;
	}

	ArrayList<Member> memberlist;
	
	private void init() {
		memberlist = new ArrayList<>();
	}

	/** 추가 */
	void insert(Member member) {
		memberlist.add(member);
	}

	/** 출력 */
	void print() {
		if(memberlist.isEmpty()) {
			System.err.println("멤버없음");
			return;
		}
		for (int i = 0; i < memberlist.size(); i++) {
			System.out.println(memberlist.get(i).getId() + " " + memberlist.get(i).getPw());
		}
				
	}

	/** 삭제 */
	void delete(String id) {
		for (int i = 0; i < memberlist.size(); i++) {
			if (id.equals(memberlist.get(i).getId())) {
				memberlist.remove(i);
				i--;
			}
		}
		
		
	}

	/** 수정 */
	void update(int i, String id ,String pw2) {
		//memberlist.get(i).setPw(pw2);
		memberlist.set(i, new Member(id, pw2));
	}

	boolean checkId(String id) {

		for (Member m : memberlist) {
			if (m.getId().equals(id)) {
				return true;
			}
		}
		return false;
	}
	
}
