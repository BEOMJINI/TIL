package RPG2;

import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner sc = new Scanner(System.in);
	Random rd = new Random();
	final int BOSS = 9;
	final int MONSTER = 8;
	final int SIZE = 10;
	int map[];
	Mage p1;

	boolean win;

	void init() {
		map = new int[SIZE];
		win = true;
		map[3] = MONSTER;
		map[5] = MONSTER;
		map[7] = MONSTER;
		map[SIZE - 1] = BOSS;
		p1 = new Mage();
		Player p2 = new Healer();
		Monster m1 = new Bat();
		Monster m2 = new Wolf();

	}

	void monInit() {
		Unit.getMlist().clear();
		Monster m1 = new Bat();
		Monster m2 = new Wolf();
	}

	void printMap() {
		for (int i = 0; i < map.length; i++) {
			if (i == p1.po) {
				System.out.print("[■]");
			} else if (map[i] == MONSTER) {
				System.out.print("[M]");
			} else if (map[i] == BOSS) {
				System.out.print("[B]");
			} else {
				System.out.print("[ ]");
			}
		}
		System.out.println();
	}

	int menu() {
		System.out.println("[0]종료[1]한칸이동[2]현재상태");
		int num = sc.nextInt();
		if (num <= 0 || num > 2) {
			return 0;
		} else {
			return num;
		}
	}

	void battle() {

		System.out.println(Unit.getMlist());
		System.out.println(Unit.getPlist());
		int idx = rd.nextInt(Unit.getMlist().size());
		System.out.println(Unit.getMlist().get(idx).name + " 출현 !");
		System.out.println(Unit.getMlist().get(idx));
		boolean turn = true;
		while (true) {
			if (turn) {
				System.out.println("[플레이어 차례]");
				System.out.println(Unit.getPlist().get(0).name + " 행동");
				if (Unit.getPlist().get(0).hp <= 0) {
					System.out.println("죽음, 행동불능");
				} else {
					System.out.println("[1]공격 [2]스킬");
					int sel = sc.nextInt();
					if (sel == 1) {
						Unit.getPlist().get(0).attack(Unit.getMlist().get(idx));
					} else if (sel == 2) {
						Unit.getPlist().get(0).hitSkill(Unit.getMlist().get(idx));
					} else {
						System.out.println("입력오류");
						continue;
					}
				}
				System.out.println(Unit.getPlist().get(1).name + " 행동");
				if (Unit.getPlist().get(1).hp <= 0) {
					System.out.println("죽음, 행동불능");
				} else {
					System.out.println("[1]공격 [2]스킬");

					int sel = sc.nextInt();
					if (sel == 1) {
						Unit.getPlist().get(1).attack(Unit.getMlist().get(idx));
					} else if (sel == 2) {
						System.out.println("스킬 대상 선택");
						System.out.println("[1]마법사 [2]힐러");
						sel = sc.nextInt();
						if (sel == 1) {
							Unit.getPlist().get(1).healSkill(Unit.getPlist().get(0));
						} else if (sel == 2) {
							Unit.getPlist().get(1).healSkill(Unit.getPlist().get(1));
						} else {
							System.out.println("입력오류");
							continue;
						}
					} else {
						System.out.println("입력오류");
						continue;
					}
				}
				if (Unit.getMlist().get(idx).isDead()) {
					System.out.println("몬스터죽음, 전투 끝");
					map[p1.po] = 0;
					monInit();
					break;
				}
				if (Unit.getPlist().get(0).hp == 0 && Unit.getPlist().get(1).hp == 0) {
					System.out.println("플레이어전멸, 전투종료");
					win = false;
					break;
				}
			} else {
				System.out.println("[몬스터 차례]");
				int mIdx = rd.nextInt(2);
				int pIdx = rd.nextInt(2);
				if (mIdx == 0) {
					Unit.getMlist().get(idx).attack(Unit.getPlist().get(pIdx));
				} else if (mIdx == 1) {
					Unit.getMlist().get(idx).hitSkill(Unit.getPlist().get(pIdx));
					Unit.getMlist().get(idx).buffSkill();
				}
				if (Unit.getPlist().get(0).hp == 0 && Unit.getPlist().get(1).hp == 0) {
					System.out.println("플레이어전멸, 전투종료");
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
			printMap();
			int sel = menu();
			if (sel == 0) {
				System.out.println("종료");
				return;
			} else if (sel == 1) {
				if (p1.po < SIZE - 1) {
					p1.po++;
				}
			} else {
				System.out.println(p1.getPlist());
			}
			if (map[p1.po] == MONSTER) {
				battle();
			}
			if (Unit.getPlist().get(0).isDead() && Unit.getPlist().get(1).isDead()) {
				System.out.println("게임 끝");
				break;
			}

		}

	}

}
