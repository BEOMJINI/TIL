package RPG2;

import java.util.ArrayList;

abstract public class Unit{
	int max_hp;
	int max_mp;
	int hp;
	int mp;
	String name;
	int strength;
	
	private static ArrayList<Monster> mlist = new ArrayList<>();
	private static ArrayList<Player> plist = new ArrayList<>();
		
	public Unit(int hp, int mp, String name, int strength) {
		super();
		this.max_hp = hp;
		this.max_mp = mp;
		this.hp = hp;
		this.mp = mp;
		this.name = name;
		this.strength = strength;
	}
	

	public Unit() {
		// TODO Auto-generated constructor stub
	}


	@Override
	public String toString() {
		return name + " : " + hp + "/" + max_hp + " , " + mp + "/" + max_mp + " , " + strength;
	}

	void attack(Unit u) {
		if(u.hp <= 0) {
			System.out.println(u.name + " 이미 죽어있어서 공격할 수 없다.");
			return;
		}
		System.out.printf("%s 가 %s 를 공격\n%d의 데미지 \n", this.name, u.name, this.strength);
		u.hp -= this.strength;
		System.out.println(u+"\n");
		
	}

	boolean isDead() {
		if (hp <= 0) {
			
			return true;
		}
		return false;

	}


	public static ArrayList<Player> getPlist() {
		return plist;
	}


	public static void setPlist(ArrayList<Player> plist) {
		Unit.plist = plist;
	}


	public static ArrayList<Monster> getMlist() {
		return mlist;
	}


	public static void setMlist(ArrayList<Monster> mlist) {
		Unit.mlist = mlist;
	}


}
