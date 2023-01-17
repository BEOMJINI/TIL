package RPG3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Util {
	static int getValue(int a, int b) {
		Scanner sc = new Scanner(System.in);
		int val = -1;
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
