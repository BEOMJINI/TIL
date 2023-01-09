package 상속RPG;

import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

public class Game {

	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	final int BOSS = 9;
	final int MONSTER = 8;
	final int SIZE = 10;

	int map[];
	Player player;
//	int px;
//	Monster mon;
//	int rIdx = rd.nextInt(3);
	boolean win;

	void init() {
		map = new int[SIZE];
		player = new Player(100, 10, "전사");
		map[3] = MONSTER;
		map[5] = MONSTER;
		map[7] = MONSTER;
		map[SIZE - 1] = BOSS;
//		px = 3;
//		map[player.position] = px;
		win = true;

	}

	void printGameMap() {
//		for (int game : map) {
//			if (game == px) {
//				System.out.print("[옷]");
//			} else if (game == 0) {
//				System.out.print("[ ]");
//			} else if (game == MONSTER) {
//				System.out.print("[M]");
//			} else {
//				System.out.print("[B]");
//			}
//		}
//		System.out.println();
		System.out.println();
		for (int i = 0; i < map.length; i++) {
			if (i == player.position) {
				System.out.printf("[★]");
			} else if (map[i] == MONSTER) {
				System.out.printf("[M]");
			} else if (map[i] == BOSS) {
				System.out.printf("[B]");
			} else {
				System.out.printf("[ ]");
			}
		}
		System.out.println();
	}

//	void movePlayer() {
//		player.movePlayer(SIZE);
//
//		if (map[player.position] == MONSTER || map[player.position] == BOSS) {
//			battleMonster();
//		}
//		map[player.position] = px;
//		map[player.position - 1] = 0;
//	}

	void mainMenu() {
		System.out.println("[0]종료[1]한칸이동[2]체력회복");
	}

	void battleMonster(Monster monster) {
//		Unit u;
//		mon.init(rId);
//		boolean turn = false;
		boolean turn = true;
		while (true) {
			if (turn) {
				System.out.println("\n========= [ 전투 ]==========");
				System.out.println("[플레이어 차례]");
				System.out.println("[1]공격 [2]스킬");
				int sel = getValue("메뉴 선택 : ", 1, 2);
				if (sel == 1) {
					player.attack(monster);
				} else if (sel == 2) {
					player.skill(monster);
				} else {
					continue;
				}

				if (monster.isDead()) {
					if(monster.boss)player.levelUp();
					player.item++;
					System.out.println("포션 1개 획득");
					break;

				}
			} else {
				System.out.println("[몬스터 차례]");
				monster.attack(player);
				if (player.isDead()) {
					System.out.println("패배");
					win = false;
					break;
				}
			}
			turn = !turn;
		}
	}

	void run() {
		init();
		while (true) {
			printGameMap();
			mainMenu();
			int sel = getValue("메뉴 입력 : ", 0, 2);
			if (sel == 1) {
				player.movePlayer(SIZE);
			} else if (sel == 2) {
				player.cure();
			} else if (sel == 0) {
				break;
			}
			if (map[player.position] == MONSTER) {
				Monster m = createMonster();
				battleMonster(m);
			} else if (map[player.position] == BOSS) {
				Monster m = createMonster();
				battleBoss(m);
				battleMonster(m);
			}

			if (win == false) {
				System.out.println("게임 오버");
				return;
			} else {
				map[player.position] = 0;
			}
			if (player.position == SIZE - 1) {
				System.out.println("게임 클리어");
				return;
			}
		}
	}

	void battleBoss(Monster m) {
		System.out.println("보스등장");
		m.boss = true;
		m.beBoss();
	}

	Monster createMonster() {
		int index = rd.nextInt(3);

		return Monster.getmonster().init(index);
	}

	int getValue(String msg, int a, int b) {
		Scanner sc = new Scanner(System.in);

		System.out.println(msg);
		int val = -1;
		try {
			val = sc.nextInt();
			if (val < a || val > b) {
				System.err.println(a + " ~ " + b + " 사이 값 입력");
			}
		} catch (InputMismatchException e) {
			System.err.println("숫자값입력");
		}
		return val;
	}

}
