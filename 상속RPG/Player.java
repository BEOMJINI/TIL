package 상속RPG;

public class Player extends Unit{
	int level;
	int item;
	int position;
	
	public Player(int hp, int power, String name) {
		super(hp, power, name);
	}

	@Override
	public String toString() {
		System.out.println(UnitInfo());
		return "[레벨:" +level+"]" + "[위치:"+ position +"]";
	}

	void movePlayer(int max) {
		if(position < max-1) {
			position++;
		}
	}

	void skill(Unit u) {
		u.hp-=power;
		u.hp-= (power/10*3);
		System.out.printf("[깊게 찌르기] [%s] 에게 공격력의 30%%증가 데미지 [%d] 데미지 공격 \n", u.name,power+power/10*3);
		System.out.println(u.UnitInfo());
	}
	
	void levelUp() {
		level++;
		power+=5;
		hp+=10;
		maxHp+=10;
		item+=1;
		System.out.printf("[레벨업! %d]\n" , level);
	}
	
	void cure () {
		if(item ==0) {
			System.err.println("포션 0개");
			return;
		}
		item--;
		if(hp+50 >= maxHp) {
			hp =maxHp;
		}else {
			hp +=50;
		}
		System.out.println("hp 50 회복");
		System.out.println(this);
	}
	
}
