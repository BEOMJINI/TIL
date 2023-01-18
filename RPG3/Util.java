package RPG3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Util {
	/** 메뉴 선택 이동 유틸 */
	static int getValue(int a, int b) {
		Scanner sc = new Scanner(System.in);
		int val = -1;
		while (true) {
			try {
				System.out.print("# 선택 ->  ");
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
	}

	/** 지정 대상 선택 유틸 */
	static int getIdx(String msg, ArrayList<Unit> list) {
		int num = -1;
		while (num == -1) {
			System.out.println(msg);
			num = Util.getValue(0, list.size() - 1);
			if (num >= 0 && num <= list.size() - 1 && list.get(num).isDead == true) {
				System.out.println("대상은 이미 사망한 상태입니다!");
				num = -1;
			}
		}
		return num;
	}

	/** 랜덤 대상 선택 유틸 */
	static int getRandomIdx(ArrayList<Unit> list) {
		Random rd = new Random();
		int num = -1;
		while (num == -1) {
			if (allDead(list) == true) {
				break;
			}
			num = rd.nextInt(list.size());
			if (num >= 0 && num <= list.size() - 1 && list.get(num).isDead == true) {
				System.out.println("대상은 이미 사망한 상태입니다!");
				num = -1;
			}
		}
		return num;
	}

	/** 전멸 체크 */
	static boolean allDead(ArrayList<Unit> list) {
		int deathCount = 0;
		for (Unit u : list) {
			if (u.isDead == true)
				deathCount++;
		}
		if (deathCount == list.size())
			return true;
		return false;

	}
}
