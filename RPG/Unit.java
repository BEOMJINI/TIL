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
		this.type = rdType();
		// this.type = type;
		this.strength = strength;
	}

	abstract void skill(Unit u);

	
	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + max_hp + " mp : " + mp + "/" + max_mp + " type : " + type + " strength : "
				+ strength;
	}

	String rdType() {
		String typeName = "";
		int rdType = rd.nextInt(3);
		if (rdType == 0) {
			typeName = "Fire";
		} else if (rdType == 1) {
			typeName = "Water";
		} else {
			typeName = "Grass";
		}
		return typeName;
	}

	void attack(Unit u) {
		System.out.printf("%s가 %s를 공격 !\n", this.name, u.name);
		if (this.type.equals("Fire") && u.type.equals("Grass") || this.type.equals("Water") && u.type.equals("Fire")
				|| this.type.equals("Grass") && u.type.equals("Water")) {
			u.hp -= this.strength * 2;
			System.out.println("상성공격 2배 데미지");
			System.out.printf("[%d] 데미지 \n", this.strength*2);
		} else {
			u.hp -= this.strength;
			System.out.printf("[%d] 데미지 \n", this.strength);
		}
		System.out.println(this);
		System.out.println(u);

	}
	
	boolean isDead() {
		if(hp<=0) {
			System.out.printf("%s 가 죽었다...\n",name);
			return true;
		}
		return false;
		
	}

}
