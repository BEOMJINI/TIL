package ATM;

import java.util.Random;

public class test {
	public static void main(String[] args) {
		Random rd = new Random();
		String data = "";

		for (int i = 0; i < 12; i++) {
			int a = rd.nextInt(9) + 1;
			if (i % 4 == 0 && i != 0) {
				data += "-";
			}
			data += a;
		}
		System.out.print(data);

		
		System.out.println();
	}
}
