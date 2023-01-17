package RPG3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class GameDAO {

	static GameDAO instance = new GameDAO();
	Map<String, Stage> stageList = new HashMap<>();

	ArrayList<Unit> pList;
	ArrayList<Unit> mList;
	Unit unit;
	boolean turn;

	/** 첫 실행 메뉴화면 */
	void init() {
		stageList.put("Battle", new StageBattle());
		stageList.put("Forest", new StageForest());
		while (true) {
			System.out.println("\n____[ GAME ]____");
			System.out.println("[0]종료 [1]전투 [2]낚시");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				break;
			} else if (sel == 1) {
				changeStage("Battle");
			} else if (sel == 2) {
				changeStage("Fishing");
			}
		}
	}

	/** 메뉴 이동 및 실행 */
	void changeStage(String name) {
		Stage currentStage = stageList.get(name);
		currentStage.init();
		currentStage.setting();
	}

	/** 배틀 페이지 */
	void battle() {
		turn = true;
		while (true) {
			if (turn) {
				// 플레이어턴
				UnitManager.instance.printPlayer();
				UnitManager.instance.printMonster();
				playerTurn();
			} else {
				// 몬스터턴
				monsterTurn();
			}
			turn = !turn;
		}
	}

	/** 플레이어 순서 */
	void playerTurn() {
		pList = UnitManager.instance.pList;
		mList = UnitManager.instance.mList;
		for (int i = 0; i < pList.size(); i++) {
			if (pList.get(i).isDead == true) {
				System.out.println(pList.get(i).name + " 사망으로 행동불능");
			} else {
				System.out.printf("\n[%s 행동]\n", pList.get(i).name);
				System.out.println("[1]공격 [2]스킬");
				int sel = Util.getValue(1, 2);
				if (sel == 1) {
					int num = -1;
					while (num == -1) {
						System.out.println("[공격 대상 선택]");
						num = Util.getValue(0, mList.size() - 1);
						if (num>=0 && num<=mList.size()-1 && mList.get(num).isDead == true) {
							System.out.println("대상은 이미 사망한 상태입니다!");
							num = -1;
						}
					}
					pList.get(i).attack(mList.get(num));
				} else if (sel == 2) {
					int num = -1;
					while (num == -1) {
						System.out.println("[스킬 대상 선택]");
						num = Util.getValue(0, mList.size());
						if (num != -1 && mList.get(num).isDead == true) {
							System.out.println("대상은 이미 사망한 상태입니다!");
							num = -1;
						}
					}
					pList.get(i).useSkill(mList.get(num));
				}
			}
		}
	}

	/** 몬스터 순서 */
	void monsterTurn() {
		System.out.println("TEST");
	}

}