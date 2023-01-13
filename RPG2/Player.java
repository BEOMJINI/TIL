package RPG2;

public class Player extends Unit implements Skill {
	
	public int position;

	
	public Player(int hp, int mp, String name, int strength) {
		super(hp, mp, name, strength);
		// TODO Auto-generated constructor stub
		Game.getPlist().add(this);
	}

	public Player() {
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

	}

}
