package RPG;

// Wolf
interface Wolf {
	// 표시 인터페이스 : marker
}

//사람만 hp+ 
interface Heal {

}

abstract class Skill extends Unit {
	
	
	 public Skill(String name, int hp, int mp, int strength) {
		super(name, hp, mp, strength);
		// TODO Auto-generated constructor stub
	}

	abstract void skill(Unit u);
	
}
