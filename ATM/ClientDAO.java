package ATM;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ClientDAO {
	private ArrayList<Client> cList = new ArrayList<Client>();
	Scanner sc = new Scanner(System.in);
	static String loginId;
	static int num = 1;

	private ClientDAO(String name) {
		cList = new ArrayList<Client>();
	}

	private static ClientDAO instance = new ClientDAO("clientDao");

	public ArrayList<Client> getcList() {
		return cList;
	}

	public void setcList(ArrayList<Client> cList) {
		this.cList = cList;
	}

	public static ClientDAO getInstance() {
		return instance;
	}

	public static void setInstance(ClientDAO instance) {
		ClientDAO.instance = instance;
	}

	// 샘플데이터저장
	public static void dataSetting(String clientData) {

		String clientData2[] = clientData.split("\n");
		for (int i = 0; i < clientData2.length; i++) {
			String info[] = clientData2[i].split("/");

			ClientDAO.instance.cList.add(new Client(info[0], info[1], info[2], num++));
		}
	}

	public void printClient() {
		int[] cnt = new int[cList.size()];
		int idx = 0;
		for (Client c : cList) {
			for (Account acc : AccountDAO.getInstance().getAccList()) {
				if (c.id.equals(acc.id)) {
					cnt[idx]++;
				}
			}
			idx++;
		}
		int idx2 = 0;
		for (Client c : cList) {
			System.out.println(c.id + " " + c.pw + " " + c.name + " 계좌 " + cnt[idx2] + " 개 회원번호 " + c.clientNo);
			idx2++;
		}

	}

	public void reviseClient() {
		System.out.println("회원정보 수정할 아이디 입력 : ");
		String id = sc.next();
		int idx = 0;
		for (Client c : cList) {
			if (id.equals(c.id)) {
				System.out.println("수정할 이름 입력 : ");
				String name = sc.next();
				c.name = name;
				System.out.println(c.id + " 회원정보 수정 완료");
			}
			idx++;
		}
	}

	public void deleteClient() {
		System.out.println("삭제할 회원 아이디 입력 : ");
		String id = sc.next();
		for (int i = 0; i < cList.size(); i++) {
			if (id.equals(cList.get(i).id)) {
				System.out.println(cList.get(i).id + " 회원 삭제 완료");
				cList.remove(i);
				i--;
			}
		}
	}

	public void join() {
		System.out.println("신규 아이디 입력 :");
		String id = sc.next();
		for (Client c : cList) {
			if (id.equals(c.id)) {
				System.err.println("중복되어 사용불가.");
				return;
			}
		}
		System.out.println("비밀번호 입력 :");
		String pw = sc.next();
		System.out.println("이름 입력 :");
		String name = sc.next();

		ClientDAO.instance.cList.add(new Client(id, pw, name, num++));
		System.out.println(id + " 신규 회원가입완료");
	}

	public boolean login() {
		// TODO Auto-generated method stub
		System.out.println("로그인");
		System.out.println("아이디 입력 :");
		String id = sc.next();
		System.out.println("비밀번호 입력 :");
		String pw = sc.next();
		for (Client c : cList) {
			if (id.equals(c.id) && pw.equals(c.pw)) {
				loginId = id;
				System.out.println(id + " 회원 로그인완료");
				return true;
			}
		}
		System.err.println("아이디 또는 비밀번호가 올바르지않다.");
		return false;
	}

	public void logout() {
		// TODO Auto-generated method stub
		if (!loginId.equals("")) {
			System.out.println(loginId + " 회원 로그아웃");
		}
		loginId = "";
	}

	public void leave() {
		// TODO Auto-generated method stub
		if (Util.leaveCheck() == true) {
			return;
		}
		System.out.println("비밀번호 입력 :");
		String pw = sc.next();
		int idx = -1;
		for (int i = 0; i < cList.size(); i++) {
			if (loginId.equals(cList.get(i).id) && pw.equals(cList.get(i).pw)) {
				idx = i;
				cList.remove(i);
				i--;
			}
		}
		if (idx == -1) {
			System.err.println("비밀번호가 올바르지 않다.");
			return;
		}

		for (int i = 0; i < AccountDAO.getInstance().getAccList().size(); i++) {
			if (loginId.equals(AccountDAO.getInstance().getAccList().get(i).id)) {
				AccountDAO.getInstance().getAccList().remove(i);
				i--;
			}
		}
		System.out.println(loginId + " 회원 탈퇴완료");
		loginId = "";
	}
}
