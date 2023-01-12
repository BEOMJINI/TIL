package RPG2;

public class Bat extends Monster {
	
	public Bat() {
		super(100, 30, "박쥐", 5);
		// TODO Auto-generated constructor stub
	
	}
	

	@Override
	public void hitSkill(Unit u) {
		String name = "흡혈";
		int power = this.strength * 2;
		int useMp = 10;

		if (this.mp < useMp) {
			System.err.println("MP 부족 !");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + " -> " + u.name + "\n" + power + " 데미지 " +"\n"+
				+ power + " hp 회복 , " + useMp + " mp 감소");
		u.hp -= power;
		if (this.hp + power <= this.max_hp) {
			this.hp += power * 2;
		} else {
			this.hp = this.max_hp;
		}
		this.mp -= 10;
		System.out.println(this);
		System.out.println(u+"\n");
		

	}

	@Override
	public void buffSkill() {
	}


	@Override
	public void healSkill(Player p) {
	}
	
 
}
