package RPG3;


import java.util.HashMap;
import java.util.Map;

public class GameDAO {

	static GameDAO instance = new GameDAO();
	Map<String, Stage> stageList  = new HashMap<>();
	/** 첫 실행 메뉴화면 */
	void init() {
		stageList.put("Battle", new StageBattle());
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
}