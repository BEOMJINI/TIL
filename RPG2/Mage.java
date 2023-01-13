package RPG2;

public class Mage extends Player {
	//int po = 0;

	public Mage() {
		super(50, 50, "마법사", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hitSkill(Unit u) {
		String name = "파이어볼";
		int power = 20;
		int useMp = 10;

		if (this.mp < useMp) {
			System.err.println(this.name+ "MP 부족 !");
			return;
		}
		System.out.println(
				this.name + " 스킬 " + name + " -> " + u.name + "\n" + power + " 데미지 " + "\n" + useMp + " mp 감소");
		u.hp -= power;
		this.mp -= useMp;
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
