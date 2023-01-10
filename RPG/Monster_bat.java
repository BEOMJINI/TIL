package RPG;

public class Monster_bat extends Monster_type {

	public Monster_bat() {
		super("박쥐", 100, 30, 5);
		// TODO Auto-generated constructor stub
		
	}

	@Override
	public String toString() {
		return name + " hp : " + hp + "/" + max_hp + " mp : " + mp + "/" + max_mp + " type : " + type + " strength : "
				+ strength;
	}

	@Override
	void skill(Unit u) {
		String skillName = "흡혈";
		if (this.mp < 5) {
			System.err.println("MP 부족!");
			return;
		}
		u.hp -= strength * 2;
		if (this.hp + strength * 2 <= this.max_hp) {
			this.hp += strength * 2;
		} else {
			this.hp = this.max_hp;
		}
		this.mp -= 5;
		System.out.printf("박쥐의 스킬 [%s] , %s에게 [%d] 데미지\n", skillName,u.name, strength * 2);
		System.out.println(this);
		System.out.println(u);
	}

}
