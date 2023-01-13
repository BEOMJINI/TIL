package RPG2;

public class Wolf extends Monster {

	public Wolf() {
		super(30, 10, "늑대", 15);
		// TODO Auto-generated constructor stub

	}

	@Override
	public void hitSkill(Unit u) {
	}

	@Override
	public void buffSkill() {
		String name = "하울링";
		int buff = this.strength * 2;
		int useMp = 10;

		if (this.mp < useMp) {
			System.err.println(this.name+ "MP 부족 !");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + "\n" + "힘 2배 증가" + "\n" + +buff + " 힘");
		this.mp -= 10;
		this.strength = buff;
		System.out.println(this+"\n");
	}

	@Override
	public void healSkill(Unit u) {
	}

}
