package RPG;

import java.util.Random;

public class Monster_wolf extends Monster {

	public Monster_wolf() {
		super("늑대", 200, 20, 10);
		// TODO Auto-generated constructor stub
	}

//	@Override
//	public String toString() {
//		return name + " hp : " + hp + "/" + max_hp + " mp : " + mp + "/" + max_mp + " type : " + type + " strength : "
//				+ strength;
//	}

	@Override
	void skill(Unit u) {
		String skillName = "하울링";
		if (this.mp < 10) {
			System.err.println("MP 부족!");
			return;
		}
		this.mp -= 10;
		System.out.printf("늑대의 스킬 [%s] , [%d] 만큼 자신의 힘 증가\n",skillName,strength);
		this.strength = strength * 2;
		System.out.println(this);
	}

//	@Override
//	String rdType() {
//		Random rd = new Random();
//		String typeName="";
//		int rdType = rd.nextInt(3);
//		if(rdType == 0) {
//			type = "Fire";
//		}else if(rdType == 1) {
//			type = "Water";
//		}else  {
//			type = "Grass";
//		}
//		return typeName;
//	}

}
