package RPG3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	ArrayList<Unit> pList = new ArrayList<>();
	ArrayList<Unit> mList = new ArrayList<>();
	// Map<String, Unit> playerList = new HashMap<>();
	ArrayList<Unit> fList = new ArrayList<>();

	void printPlayer() {
		int idx = 0;
		System.out.println("\n[플레이어 정보]");
		for (Unit u : pList) {
			System.out.printf("[%d. %-3s] HP: %3d/%3d , MP: %d/%d , 힘: %d\n", idx, u.name, u.hp, u.max_hp, u.mp,
					u.max_mp, u.strength);
			idx++;
		}
	}

	void printMonster() {
		int idx = 0;
		System.out.println("\n[몬스터 정보]");
		for (Unit u : mList) {
			System.out.printf("[%d. %-3s] HP: %3d/%3d , 힘: %d\n", idx, u.name, u.hp, u.max_hp, u.strength);
			idx++;
		}
	}

	void setPlayer() {
		pList.clear();
		pList.add(new Worrior("전사", 100, 20, 20, new SkillDoubleAttack()));
		// playerList.put("전사", new Worrior("전사", 100, 20, 20, new
		// SkillDoubleAttack()));
		pList.add(new Mage("마법사", 30, 50, 10, new SkillFireBall()));
		pList.add(new Healer("치유사", 50, 30, 5, new SkillCure()));
	}

	void setForestMonster() {
		mList.clear();
		mList.add(new Monster("늑대", 100, 5));
		mList.add(new Monster("박쥐", 70, 7));
		mList.add(new Monster("슬라임", 50, 3));

	}

	void setOceanMonster() {
		mList.clear();
		mList.add(new Monster("해파리1", 50, 5));
		mList.add(new Monster("해파리2", 50, 5));
		mList.add(new Monster("상어  ", 100, 10));
		mList.add(new Monster("바다유령", 70, 3));
		mList.add(new Monster("크라켄 ", 150, 8));

	}

	/** 낚시할 플레이어 인덱스 값 선택 */
	int selectPlayer() {
		// setPlayer();
		int idx = 0;
		for (Unit u : pList) {
			System.out.printf("[%d. %-3s] HP: %3d/%3d , 힘: %d , 당기기 성공 확률: %d%%\n", idx, u.name, u.hp, u.max_hp,
					u.strength, u.fishingPercent);
			idx++;
		}
		System.out.println("[낚시할 플레이어 선택]\n[0]전사 [1]마법사 [2]치유사");
		int num = Util.getValue(0, pList.size() - 1);
		return num;

	}
	
	void setPondFish() {
		fList.clear();
		for(int i =0; i<5; i++) {
			fList.add(new Fish("송사리", 10, 10));
		}
		for(int i =0; i<3; i++) {
			fList.add(new Fish("붕어", 30, 7));
			fList.add(new Fish("미꾸라지", 30, 5));
			fList.add(new Fish("피라미", 20, 8));
		}
		fList.add(new Fish("연못왕", 50, 3));
//		for(Unit u : fList) {
//			System.out.println(u.name);
//		}
	}
}
