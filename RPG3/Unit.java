package RPG3;

import java.util.ArrayList;

abstract public class Unit {
	int max_hp;
	int max_mp;
	int hp;
	int mp;
	String name;
	int strength;
	boolean isDead;
	Skill skill;
	int fishingPercent;
	
	public Unit(String name, int hp, int strength) {
		super();
		this.max_hp = hp;
		this.hp = hp;
		this.name = name;
		this.strength = strength;
		isDead = false;
	}

	/** 공격 */
	public void attack(Unit u) {

//		if (u.isDead == true) {
//			System.out.println("대상은 이미 사망한 상태입니다!");
//			return;
//		} else {
		u.hp -= this.strength;
		System.out.printf("[%s]에게 [%d]의 데미지\n", u.name, this.strength);
		if (u.hp <= 0) {
			u.hp = 0;
			u.isDead = true;
			System.out.printf("[%s] 사망했습니다.\n", u.name);
		}

//		}
	}

	/** 스킬 */
	public void useSkill(Unit u) {
		this.skill.skill(u);
	}

	public boolean allDead(ArrayList<Unit> list) {
		for (Unit u : list) {
			if (u.isDead == true)
				return true;
		}
		return false;

	}
}
