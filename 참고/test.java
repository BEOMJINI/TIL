package 참고;

import java.util.ArrayList;
import java.util.Random;

// 기계만 hp+ 
interface Repairable {
	// 표시 인터페이스 : marker
}

// 사람만 hp+ 
interface Heal {

}

abstract class Unit {
	Random rd = new Random();
	int hp;
	int mp;
	final int MAX_HP;
	final int MAX_MP;
	String name;
	int attack; // 공격력

	Unit(String name, int hp, int mp, int attack) {
		this.name = name;
		MAX_HP = hp;
		MAX_MP = mp;
		this.hp = hp;
		this.mp = mp;
		this.attack = attack;
	}

	void attackToOther(Unit unit) {
		int hit = unit.rd.nextInt(attack / 2) + 1;
		unit.hp -= hit;
		System.out.printf("%s %s 를 %d 데미지로 공격 \n", this.name, unit.name, hit);
		System.out.println(unit);

	}

	abstract void skill(Unit unit);

}

abstract class GroundUnit extends Unit {
	int speed; // 최대속력

	GroundUnit(String name, int hp, int mp, int attack) {
		super(name, hp, mp, attack);
	}



}

class AirUnit extends Unit {
	int high; // 최대높이

	AirUnit(String name, int hp, int mp, int attack) {
		super(name, hp, mp, attack);
	}

	@Override
	void skill(Unit unit) {

	}

}

class Tank extends GroundUnit implements Repairable {
	String skill = "바주카포 발사";

	Tank() {
		super("탱크", 200, 100, 100);
	}

	@Override
	public String toString() {
		return "Tank hp :  " + hp + "/ " + MAX_HP + "";
	}

	void skill(Unit unit) {
		unit.hp -= attack;
		this.mp -= MAX_MP / 2;
		System.out.printf("%s 가 스킬  %s 사용  %s %d 데미지 공격 \n", this.name, skill, unit.name, attack);
		System.out.println(unit);
	}

}

class Warrior extends GroundUnit implements Heal {
	Warrior() {
		super("전사", 150, 150, 120);
	}

	@Override
	public String toString() {
		return "hp :  " + hp + "/ " + MAX_HP + "";
	}

	@Override
	void skill(Unit unit) {
	}
	
}

class IronMan extends AirUnit implements Heal, Repairable {

	IronMan() {
		super("아이언맨", 250, 100, 55);
	}

	@Override
	public String toString() {
		return  name+ " hp :  " + hp + "/ " + MAX_HP + "";
	}
	
	
	
}

class Ninja extends GroundUnit implements Heal {

	String skill = "표창던지기";

	Ninja() {
		super("닌자", 130, 90, 85);
	}

	@Override
	public String toString() {
		return "hp :  " + hp + "/ " + MAX_HP + "";
	}

	void skill(Unit unit) {
		unit.hp -= attack;
		this.mp -= MAX_MP / 2;
		System.out.printf("%s 가 스킬  %s 사용  %s %d 데미지 공격 \n", this.name, skill, unit.name, attack);
		System.out.println(unit);
	}
}

class Healer extends AirUnit implements Heal {

	Healer() {
		super("힐러", 100, 200, 50);
	}

	void heal(Heal heal) {
		Unit unit = (Unit) heal;
		System.out.println(unit.name + " 가 힐러에게 힐 받았다  ");
		if (unit.hp <= unit.MAX_HP) {
			unit.hp += 30;
		}

		System.out.println(unit);
	}

}

class SVC extends GroundUnit implements Repairable {

	SVC() {
		super("SVC", 100, 150, 80);
	}

	void repair(Repairable Repairable) {
		Unit unit = (Unit) Repairable;
		System.out.printf(" %s 가 SVC에게 수리받았다 \n ", unit.name);
		if (unit.hp <= unit.MAX_HP) {
			unit.hp += 30;
		}

		System.out.println(unit);
	}

	@Override
	void skill(Unit unit) {
	}

}

public class test {

	public static void main(String[] args) {

		Random rd = new Random();
		IronMan i = new IronMan();
		Tank t = new Tank();
		System.out.println(t);
		Ninja n = new Ninja();
		t.attackToOther(n);

		n.attackToOther(t);
		t.skill(n);

		t.skill(i);
		Healer h = new Healer();
		h.heal(n); // heal 없는 기계는 수리불가

		SVC s = new SVC();
		s.repair(t); // repairable 없는 사람은 수리 불가
		// s.repair(n);

		h.heal(i);
		t.skill(i);
		s.repair(i);

		ArrayList<GroundUnit> groundlist = new ArrayList<GroundUnit>();
		groundlist.add(new SVC());
		groundlist.add(new Ninja());
		groundlist.add(new Tank());
		groundlist.add(new Warrior());
		int idx = rd.nextInt(groundlist.size());
		GroundUnit team1 = groundlist.get(1);
		System.out.println(team1.name);
		// Ninja 안에 만 있는 스킬 사용하려면
		if (team1 instanceof Ninja) {
			// GroundUnit 안에 있는 닌자를
			team1 = (Ninja) team1; // 다운케스팅으로 닌자타입으로 바꿔주고
		}
		team1.skill(t); // 그런 다음에 닌자 안에 있는 skill 사용가능하다

	}
}
