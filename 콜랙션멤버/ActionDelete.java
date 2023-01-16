package 콜랙션멤버;

public class ActionDelete implements Action {
	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();
		System.out.println("아이디 입력:");
		String id = Util.scan.next();
		if (dao.checkId(id) == false) {
			System.err.println("존재하지 않는 아이디");
			return;
		}
		dao.delete(id);
		System.out.println("삭제 완료");
	}
}
