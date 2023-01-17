package RPG3;

abstract public class Unit {
	int max_hp;
	int max_mp;
	int hp;
	int mp;
	String name;
	int strength;
	boolean isDead;
	Skill skill;

	public Unit(String name, int hp, int strength) {
		super();
		this.max_hp = hp;
		this.hp = hp;
		this.name = name;
		this.strength = strength;
		isDead = false;
	}

	public void attack(Unit u) {
		u.hp -= this.strength;
		System.out.printf("%s 가 %s 를 공격\n%d의 데미지 \n", this.name, u.name, this.strength);
		if (u.hp <= 0) {
			u.hp = 0;
			u.isDead = true;
			System.out.println(u.name + " 사망");
		}
	}
	
	public void useSkill(Unit u) {
		this.skill.skill(u);
	}

}
