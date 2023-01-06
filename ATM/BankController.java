package ATM;

public class BankController {
	String name = "우리은행";

	ClientDAO cdao = ClientDAO.getInstance();
	AccountDAO accdao = AccountDAO.getInstance();

	public void setSampleData() {
		String clientData = "test01/1111/김철수\n"; // id / pw /name
		clientData += "test02/2222/이영희\n";
		clientData += "test03/3333/신민수\n";
		clientData += "test04/4444/최상민";

		String accountdata = "test01/1111-1111-1111/8000\n";
		accountdata += "test02/2222-2222-2222/5000\n";
		accountdata += "test01/3333-3333-3333/11000\n";
		accountdata += "test03/4444-4444-4444/9000\n";
		accountdata += "test01/5555-5555-5555/5400\n";
		accountdata += "test02/6666-6666-6666/1000\n";
		accountdata += "test03/7777-7777-7777/1000\n";
		accountdata += "test04/8888-8888-8888/1000";
		// 1) test01 김철수는 계좌를 3개 가지고있다.
		// 2) test02 이영희는 계좌를 2개 가지고있다.
		// 3) test03 신민수는 계좌를 2개 가지고있다.
		// 4) test04 최상민은 계좌를 1개 가지고있다.

		ClientDAO.dataSetting(clientData);
		AccountDAO.dataSetting(accountdata);
	}

	public void run() {
		setSampleData();
		while (true) {
			System.out.println("\n[메인 화면]");
			System.out.println("[1] 관리자 [2] 사용자 [0] 종료");

			int sel = Util.getValue("메인화면 선택 : ", 0, 2);

			if (sel == 1) {
				while (true) {
					System.out.println("\n[관리자 화면]");
					System.out.println("[1] 회원목록 - 전체회원 목록");
					System.out.println("[2] 회원정보 수정");
					System.out.println("[3] 회원정보 삭제");
					System.out.println("[4] 회원정보 저장");
					System.out.println("[5] 회원정보 불러오기");
					System.out.println("[0] 뒤로가기");

					int sel2 = Util.getValue("관리자화면 선택 : ", 0, 5);

					if (sel2 == 1) {
						cdao.printClient();
					} else if (sel2 == 2) {
						cdao.reviseClient();
					} else if (sel2 == 3) {
						cdao.deleteClient();
					} else if (sel2 == 4) {
						File.save();
					} else if (sel2 == 5) {
						File.load();
					} else if (sel2 == 0) {
						break;
					}
				}
			} else if (sel == 2) {
				while (true) {
					System.out.println("\n[사용자 화면]");
					System.out.println("[1] 회원가입 [2] 로그인 [0] 뒤로가기");

					int sel2 = Util.getValue("사용자화면 선택 : ", 0, 2);

					if (sel2 == 1) {
						cdao.join();
					} else if (sel2 == 2) {
						if (cdao.login() == true) {
							while (true) {
								System.out.println("\n[로그인 성공 시 화면]");
								System.out.println("[1] 계좌 추가");
								System.out.println("[2] 계좌 삭제");
								System.out.println("[3] 입금");
								System.out.println("[4] 출금");
								System.out.println("[5] 이체");
								System.out.println("[6] 탈퇴 ");
								System.out.println("[7] 마이페이지: 전체 계좌, 금액 (회원정보: 비밀번호 수정)");
								System.out.println("[0] 뒤로가기");

								int sel3 = Util.getValue("로그인성공시화면 선택 : ", 0, 7);

								if (sel3 == 1) {
									accdao.addAccount();
								} else if (sel3 == 2) {
									accdao.deleteAccount();
								} else if (sel3 == 3) {
									accdao.credit();
								} else if (sel3 == 4) {
									accdao.debit();
								} else if (sel3 == 5) {
									accdao.transfer();
								} else if (sel3 == 6) {
									cdao.leave();
								} else if (sel3 == 7) {
									accdao.printAccount();
								} else if (sel3 == 0) {
									cdao.logout();
									break;
								}
							}
						}
					} else if (sel2 == 0) {
						break;
					}

				}
			} else if (sel == 0) {
				break;
			}
		}
	}

}
