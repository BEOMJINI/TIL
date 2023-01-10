package RPG;

import java.util.Random;

abstract public class Unit {
	Random rd = new Random();
	int max_hp;
	int max_mp;
	int hp;
	int mp;
	String name;
	String type;
	int strength;

	public Unit(String name, int hp, int mp, int strength) {
		super();
		this.max_hp = hp;
		this.max_mp = mp;
		this.hp = hp;
		this.mp = mp;
		this.name = name;
		type = rdType();
		this.type = type;
		this.strength = strength;
	}
	
	abstract void skill(Unit u);
		
	String rdType() {
		String typeName="";
		int rdType = rd.nextInt(3);
		if(rdType == 0) {
			type = "Fire";
		}else if(rdType == 1) {
			type = "Water";
		}else  {
			type = "Grass";
		}
		return typeName;
		
	}
	
	void attack (Unit u) {
		u.hp -= this.strength;
		System.out.printf("%s가 %s를 공격 !\n",this.name,u.name);
		System.out.printf("[%d] 데미지 \n",this.strength);
		System.out.println(this);
		System.out.println(u);
		
	}
		
}
