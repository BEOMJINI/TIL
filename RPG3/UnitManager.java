package RPG3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	ArrayList<Unit> pList = new ArrayList<>();
	ArrayList<Unit> mList = new ArrayList<>();
	// Map<String, Unit> playerList = new HashMap<>();

	void printPlayer() {
		int idx=0;
		System.out.println("\n[플레이어 정보]");
		for (Unit u : pList) {
			System.out.printf("[%d. %-3s] HP: %3d/%3d , MP: %d/%d , 힘: %d\n",idx, u.name, u.hp, u.max_hp, u.mp, u.max_mp, u.strength);
			idx++;
		}
	}

	void printMonster() {
		int idx=0;
		System.out.println("\n[몬스터 정보]");
		for (Unit u : mList) {
			System.out.printf("[%d. %-3s] HP: %3d/%3d , 힘: %d\n",idx, u.name, u.hp, u.max_hp, u.strength);
			idx++;
		}
	}

	void setPlayer() {
		pList.clear();
		pList.add(new Worrior("전사", 100, 20, 20, new SkillDoubleAttack()));
		// playerList.put("전사", new Worrior("전사", 100, 20, 20, new
		// SkillDoubleAttack()));
	}

	void setForestMonster() {
		mList.clear();
		mList.add(new Monster("늑대", 100, 5));
		mList.add(new Monster("박쥐", 70, 7));
		mList.add(new Monster("슬라임", 50, 3));

	}
}
