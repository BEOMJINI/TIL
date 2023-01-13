package RPG2;

public class Zombie extends Monster {

	public Zombie() {
		super(50, 10, "좀비", 10);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void hitSkill(Unit u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void buffSkill() {
		// TODO Auto-generated method stub

	}

	@Override
	public void healSkill(Unit u) {
		// TODO Auto-generated method stub
		u = this;
		String name = "자가치유";	//최대체력 이상 회복
		int power = 50;
		int useMp = 10;
		if (this.mp < useMp) {
			System.err.println(this.name+ "MP 부족 !");
			return;
		}
		System.out.println(this.name + " 스킬 " + name + " 사용\n" + power + " hp 회복 , " + useMp + " mp 감소");
		u.hp += 50;
		this.mp -= 10;
		System.out.println(this);
	}

}
