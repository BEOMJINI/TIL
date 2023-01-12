package RPG2;

abstract public class Player extends Unit implements Skill {
		 
	public Player(int hp, int mp, String name, int strength) {
		super(hp, mp, name, strength);
		// TODO Auto-generated constructor stub
		getPlist().add(this);
	}

}
