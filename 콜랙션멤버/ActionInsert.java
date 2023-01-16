package 콜랙션멤버;

public class ActionInsert implements Action{

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();
		System.out.println("아이디 입력:");
		String id = Util.scan.next();
		if(dao.checkId(id)) {
			System.out.println("중복아이디");
			return;
		}
		System.out.println("비밀번호 입력:");
		String pw = Util.scan.next();
	//	Member member = new Member(id,pw);
		//dao.memberlist.add(member);
		dao.insert(new Member(id,pw));
		System.out.println("회원가입성공");
	}

}
