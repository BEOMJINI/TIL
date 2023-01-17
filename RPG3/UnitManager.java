package RPG3;

import java.util.ArrayList;

public class UnitManager {
	static UnitManager instance = new UnitManager();
	ArrayList<Unit> pList = new ArrayList<>();
	ArrayList<Unit> mList = new ArrayList<>();
	
	void setPlayer() {
		pList.clear();
		pList.add(new Worrior("전사", 100, 20, 20, new SkillDoubleAttack()));
	}
}
