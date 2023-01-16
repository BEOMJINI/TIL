package 콜랙션멤버;

public class ActionUpdate implements Action {

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();
		System.out.println("아이디 입력:");
		String id = Util.scan.next();
		if (dao.checkId(id) == false) {
			System.err.println("존재하지 않는 아이디");
			return;
		}
		System.out.println("비밀번호 입력:");
		String pw = Util.scan.next();
//		if (dao.checkPw(pw) == false) {
//			System.err.println("비밀번호틀림");
//			return;
//		}

		for (int i = 0; i < dao.memberlist.size(); i++) {
			if (id.equals(dao.memberlist.get(i).getId())) {
				dao.update(i,id, pw);
				System.out.println("수정완료");
			}
		}
	}
}
