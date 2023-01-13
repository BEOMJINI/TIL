package RPG2;

import java.util.ArrayList;

abstract public class Monster extends Unit implements Skill{
	
	public Monster(int hp, int mp, String name, int strength) {
		super(hp, mp, name, strength);
		// TODO Auto-generated constructor stub
		Game.getMlist().add(this);
	}
	

	
	
}
