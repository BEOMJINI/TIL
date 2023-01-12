package RPG2;

public class Healer extends Player {

	public Healer() {
		super(10, 100, "힐러", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hitSkill(Unit u) {
	}

	@Override
	public void buffSkill() {
	}

	@Override
	public void healSkill(Player p) {
		String name = "힐";
		int power = 20;
		int useMp = 10;
		if (this.mp < useMp) {
			System.err.println("MP 부족 !");
			return;
		}
		if (p.hp <= 0) {
			System.out.println("이미 사망했기에 힐을 줄 수 없다.");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + " -> " + p.name + "\n" + p.name + " " + power + " hp 회복 , "
				+ useMp + " mp 감소");

		if (p.hp + power <= p.max_hp) {
			p.hp += power;
		} else {
			p.hp = p.max_hp;
		}
		this.mp -= 10;
		System.out.println(this);
		System.out.println(p + "\n");
	}

}
