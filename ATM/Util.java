package ATM;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
	// 버튼입력값체크
	static int getValue(String msg, int a, int b) {
		Scanner sc = new Scanner(System.in);
		int val = -1;
		try {
			System.out.println(msg);
			val = sc.nextInt();
			if (val < a || val > b) {
				System.err.println(a + " ~ " + b + " 사이 값 입력");
				val = -1;
			}
		} catch (InputMismatchException e) {
			System.err.println("숫자값만 입력");
		}
		return val;
	}

	// 계좌번호일치체크
	static int accountCheck(String accNum) {
		int idx = -1;
		for (int i = 0; i < AccountDAO.getInstance().getAccList().size(); i++) {
			if (accNum.equals(AccountDAO.getInstance().getAccList().get(i).accountNumber)
					&& ClientDAO.loginId.equals(AccountDAO.getInstance().getAccList().get(i).id)) {
				idx = i;
				break;
			}
		}
		if (idx == -1) {
			System.err.println("올바른 계좌가 아니다.");
			return -1;
		}
		return idx;
	}

	// 탈퇴한유저체크
	static boolean leaveCheck() {
		if (ClientDAO.loginId.equals("")) {
			System.err.println("탈퇴된 회원이다.");
			return true;
		}
		return false;

	}

	// 계좌입력받을시형태체크
	static String getAccNum(String msg) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println(msg);
			String accNum = sc.next();
			String accNumPattern = "^\\d{4}-\\d{4}-\\d{4}$";
			Pattern p = Pattern.compile(accNumPattern);
			Matcher m = p.matcher(accNum);
			boolean check = m.matches();
			if (!check) {
				System.err.println("****-****-**** 형태로 입력");
				continue;
			}
			return accNum;
		}
	}

	// 랜덤계좌번호생성
	static String makeAccNum() {
		Random rd = new Random();
		String data = "";
		for (int i = 0; i < 12; i++) {
			int a = rd.nextInt(9) + 1;
			if (i % 4 == 0 && i != 0) {
				data += "-";
			}
			data += a;
		}
		return data;
	}
}
