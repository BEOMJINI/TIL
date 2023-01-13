package RPG2;

public class Healer extends Player {

	public Healer() {
		super(50, 100, "힐러", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hitSkill(Unit u) {
	}

	@Override
	public void buffSkill() {
	}

	@Override
	public void healSkill(Unit u) {
		String name = "힐";
		int power = 20;
		int useMp = 10;
		if (this.mp < useMp) {
			System.err.println(this.name+ "MP 부족 !");
			return;
		}
		if (u.isDead()) {
			System.out.println("이미 사망했기에 힐을 줄 수 없다.");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + " -> " + u.name + "\n" + u.name + " " + power + " hp 회복 , "
				+ useMp + " mp 감소");

		if (u.hp + power <= u.max_hp) {
			u.hp += power;
		} else {
			u.hp = u.max_hp;
		}
		this.mp -= 10;
		if (this.equals(u)) {
			System.out.println(u + "\n");
		} else {
			System.out.println(this);
			System.out.println(u + "\n");
		}
	}

}
