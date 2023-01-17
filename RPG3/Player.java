package RPG3;

public class Player extends Unit{
	/** mp , max_mp , skill 추가 */
	public Player(String name, int hp,int mp, int strength,Skill skill) {
		super(name, hp, strength);
		this.max_mp = mp;
		this.mp = mp;
		this.skill = skill;
		
	}

}
