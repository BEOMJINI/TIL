package RPG;

public class _Main {

	public static void main(String[] args) {
		
		Monster_bat b = new Monster_bat();
		Monster_wolf w = new Monster_wolf();
		b.skill(w);
		w.skill(b);
		System.out.println("_____________________");
		b.skill(w);
		w.skill(b);
		System.out.println("_____________________");
		b.skill(w);
		w.skill(b);
		System.out.println("_____________________");
		b.attack(w);
		w.attack(b);
		
	}

}
