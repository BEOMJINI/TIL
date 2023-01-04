package 경마;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

class horse {

}

class game {
	void run() {

	}
}

public class test {

	public static void main(String[] args) {

		/*
		 * [경마 게임] [1] 5 * 20 의 배열이 있다. [2] 각 줄은 말이 달릴 트랙을 의미한다. [3] 매 턴당 랜덤으로 1~4칸의 거리를
		 * 이동할수있다. [4] 말이 전부 도착하면 게임은 끝난다. 각말들의 순위를 출력한다. [5] 단, 말이 동시에 도착하면 등수는 같다.
		 */

		int horse[][] = new int[5][20];
		Random rd = new Random();
		int r = 0;

		int malmal[] = new int[5];
		int rank[] = new int[5];
		int ranking = 0;
		int flag = 1;
		int flag2 = 0;
		
		FileWriter fw = null;
		String fileName = "src/경마/test.txt";

		while (true) {
			if (flag > 0) {
				ranking += 1;
			}
			flag = 0;

			for (int i = 0; i < horse.length; i++) {
				r = rd.nextInt(4) + 1;
				//System.out.println(r);				
				malmal[i] += r;

				//System.out.println("합 : " + malmal[i]);

				if (malmal[i] < 20) {
					horse[i][malmal[i]] = 9;

					if (malmal[i] == 19 && rank[i] == 0) {
						rank[i] = ranking;
						++flag;
					}
					if (malmal[i] - r > -1) {
						horse[i][malmal[i] - r] = 0;
					}
				} else {
					if (malmal[i] - r < 20) {
						horse[i][malmal[i] - r] = 0;
						horse[i][19] = 9;	
					}
					
					if (rank[i] == 0) {
						rank[i] = ranking;
						++flag;
					}
				}

				// 출력문
				horse[i][0] = i + 1;
				for (int j = 0; j < horse[i].length; j++) {
					if (horse[i][j] == 0) {
						System.out.print("[ ]");
					} else if (horse[i][j] == 9) {
						System.out.print("[■]");
					} else {
						System.out.print("[" + horse[i][j] + "]");
					}
				}
				System.out.println();
			}
			System.out.println("======================================");

			for (int j = 0; j < rank.length; ++j) {
				if (rank[j] > 0) {
					++flag2;
				}
			}
			if (flag2 == rank.length) break;
			else flag2 = 0;
		}
		
		// 등수 저장
		String data = "";
		for (int i = 0; i < rank.length; ++i) {
			System.out.println(i+1  + "번 마 : " + rank[i] + "등\n");
			data += i+1  + "번 마 : " + rank[i] + "등\n";
		}
		
		try {
			fw = new FileWriter(fileName);
			fw.write(data);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (fw != null) {
				try {
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			System.out.println("파일" + fileName + " 생성");
		}
		
	}
}