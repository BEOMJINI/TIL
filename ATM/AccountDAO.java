package ATM;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class AccountDAO {
	private ArrayList<Account> accList = new ArrayList<Account>();
	Scanner sc = new Scanner(System.in);

	private AccountDAO(String name) {
		accList = new ArrayList<Account>();
	}

	public ArrayList<Account> getAccList() {
		return accList;
	}

	public void setAccList(ArrayList<Account> accList) {
		this.accList = accList;
	}

	public static AccountDAO getInstance() {
		return instance;
	}

	public static void setInstance(AccountDAO instance) {
		AccountDAO.instance = instance;
	}

	private static AccountDAO instance = new AccountDAO("accountDAO");

	// 샘플데이터 저장
	public static void dataSetting(String accountdata) {

		String accountdata2[] = accountdata.split("\n");
		for (int i = 0; i < accountdata2.length; i++) {
			String info[] = accountdata2[i].split("/");

			AccountDAO.getInstance().getAccList().add(new Account(info[0], info[1], Integer.parseInt(info[2])));
		}
	}

	public void addAccount() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		String data = Util.makeAccNum();
		for (Account acc : AccountDAO.instance.accList) {
			if (data.equals(acc.accountNumber)) {
				System.err.println("중복된 계좌번호 생성으로 오류");
				return;
			}
		}
		accList.add(new Account(ClientDAO.loginId, data, 0));
		System.out.println(ClientDAO.loginId + " 회원 " + data + " 계좌추가완료");

	}

	public void deleteAccount() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		String accNum = Util.getAccNum("삭제할 계좌번호 입력 :");
		int idx = Util.accountCheck(accNum);
//		int idx = -1;
//		for (int i = 0; i < accList.size(); i++) {
//			if (AccountNum.equals(accList.get(i).accountNumber) && ClientDAO.loginId.equals(accList.get(i).id)) {
//				idx = i;
//				break;
//			}
//		}
//		if (idx == -1) {
//			System.err.println("올바른 계좌가 아니다.");
//			return;
//		}
		if (idx != -1) {
			accList.remove(idx);
			System.out.println(ClientDAO.loginId + " 회원 " + accNum + " 계좌 삭제완료");
		}
	}

	public void credit() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		String accNum = Util.getAccNum("입금할 계좌번호 입력 :");
		int idx = Util.accountCheck(accNum);
		if (idx != -1) {
			System.out.println("입금 금액 :");
			int money = sc.nextInt();
			accList.get(idx).money += money;
			System.out.println(money + " 원 입금완료");
			System.out.println("잔액 " + accList.get(idx).money + " 원");
		}
	}

	public void debit() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		String accNum = Util.getAccNum("출금할 계좌번호 입력 :");
		int idx = Util.accountCheck(accNum);
		if (idx != -1) {
			System.out.println("출금 금액 :");
			int money = sc.nextInt();
			if (money > accList.get(idx).money) {
				System.err.println("잔액이 부족하다.");
				return;
			}
			accList.get(idx).money -= money;
			System.out.println(money + " 원 출금완료");
			System.out.println("잔액 " + accList.get(idx).money + " 원");
		}
	}

	public void transfer() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		String accNum = Util.getAccNum("당신 계좌번호 입력 :");
		int idx = Util.accountCheck(accNum);
		if (idx != -1) {
			String accNum2 = Util.getAccNum("이체할 계좌번호 입력 :");
//		if(accNum2.equals(accList.get(idx).accountNumber)) {
//			System.err.println("당신의 계좌와 이체할 계좌");
//		}
			int idx2 = -1;
			for (int i = 0; i < accList.size(); i++) {
				if (accNum2.equals(accList.get(i).accountNumber)) {
					idx2 = i;
					break;
				}
			}
			if (idx2 == -1) {
				System.err.println("올바른 계좌가 아니다.");
				return;
			}
			System.out.println("이체 금액 :");
			int money = sc.nextInt();
			if (money > accList.get(idx).money) {
				System.err.println("잔액이 부족하다.");
				return;
			}
			accList.get(idx).money -= money;
			accList.get(idx2).money += money;
			System.out.println(money + " 원 이체완료");
			System.out.println("잔액 " + accList.get(idx).money + " 원");
		}
	}

	public void printAccount() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		for (Account acc : accList) {
			if (ClientDAO.loginId.equals(acc.id)) {
				System.out.println(acc.id + " " + acc.accountNumber + " " + acc.money);
			}
		}
	}

}
