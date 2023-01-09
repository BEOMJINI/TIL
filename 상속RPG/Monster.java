package 상속RPG;

import java.util.Random;

public class Monster extends Unit {
	private static Monster monster = new Monster(0, 0, null);
	Random rd = new Random();
	String[] names = { "늑대", "박쥐", "좀비" };
	String[] attack = { "할퀴기", "음파공격", "물어뜯기" };
	static int idx;
	boolean boss;

	public Monster(int hp, int power, String name) {
		super(hp, power, name);
	}

	Monster init(int idx) {
		Monster m = null;
		this.idx = idx;
		if (idx == 0) {
			return new Monster(35, 5, names[idx]);
		} else if (idx == 1) {
			return new Monster(49, 7, names[idx]);
		} else {
			return new Monster(63, 9, names[idx]);
		}
	}

	public static Monster getmonster() {
		return monster;
	}

	public void beBoss() {
		name += "보스 # " +name;
		hp+= 50;
		maxHp = hp;
		power +=30;
		System.out.println(UnitInfo());
	}
}
