package 콜랙션멤버;

public class ActionPrint implements Action {

	@Override
	public void excute() {
		MemberDAO dao = MemberDAO.getIntance();
		System.out.println("멤버 출력");
		dao.print();
	}

}
