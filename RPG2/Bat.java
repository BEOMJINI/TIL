package RPG2;

public class Bat extends Monster {
	
	public Bat() {
		super(20, 30, "박쥐", 5);
		// TODO Auto-generated constructor stub
	
	}
	

	@Override
	public void hitSkill(Unit u) {
		String name = "흡혈";
		int power = this.strength * 2;
		int useMp = 10;

		if (this.mp < useMp) {
			System.err.println(this.name+ "MP 부족 !");
			return;
		}
		if (u.hp <= 0) {
			System.out.println("대상이 이미 사망했기에 스킬을 사용할 수 없다.");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + " -> " + u.name + "\n" + power + " 데미지 " +"\n"+
				+ power + " hp 회복 , " + useMp + " mp 감소");
		u.hp -= power;
		if (this.hp + power <= this.max_hp) {
			this.hp += power;
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
	public void healSkill(Unit u) {
	}
	
 
}
