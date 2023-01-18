package RPG3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class GameDAO {

	static GameDAO instance = new GameDAO();
	Map<String, Stage> stageList = new HashMap<>();

	ArrayList<Unit> pList;
	ArrayList<Unit> mList;
	Unit unit;
	boolean turn;
	ArrayList<Unit> fList;

	/** 첫 실행 메뉴화면 */
	void init() {
		stageList.clear();
		stageList.put("Battle", new StageBattle());
		stageList.put("Forest", new StageForest());
		stageList.put("Ocean", new StageOcean());
		stageList.put("Fishing", new StageFishing());
		stageList.put("Pond", new StagePond());
		stageList.put("Lake", new StageLake());
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

		System.out.println("\n[플레이어 차례]");
		for (int i = 0; i < pList.size(); i++) {
			if (Util.allDead(mList)) {
				System.out.println("\n[몬스터 전멸]\n전투 승리 !\nGAME 화면으로 돌아갑니다.");
				init();
			}
			System.out.printf("\n[%s 행동]\n", pList.get(i).name);
			if (pList.get(i).isDead == true) {
				System.out.println("[사망] 행동불능");
			} else {
				System.out.println("[1]공격 [2]스킬");
				int sel = Util.getValue(1, 2);
				if (sel == 1) {
//					int num = -1;
//					while (num == -1) {
//						System.out.println("[공격 대상 선택]");
//						num = Util.getValue(0, mList.size() - 1);
//						if (num>=0 && num<=mList.size()-1 && mList.get(num).isDead == true) {
//							System.out.println("대상은 이미 사망한 상태입니다!");
//							num = -1;
//						}
//					}
					int num = Util.getIdx("[공격 대상 선택]", mList);
					pList.get(i).attack(mList.get(num));
				} else if (sel == 2) {
					if (pList.get(i) instanceof Healer) {

						int num = Util.getIdx("[스킬 대상 선택]", pList);
						pList.get(i).useSkill(pList.get(num));
					} else {
						int num = Util.getIdx("[스킬 대상 선택]", mList);
						pList.get(i).useSkill(mList.get(num));
					}
				}
			}
		}

	}

	/** 몬스터 순서 */
	void monsterTurn() {
		// System.out.println("TEST");
		pList = UnitManager.instance.pList;
		mList = UnitManager.instance.mList;
		System.out.println("\n[몬스터 차례]");
		for (int i = 0; i < mList.size(); i++) {
			if (Util.allDead(pList)) {
				System.out.println("\n[플레이어 전멸]\n전투 패배 !\nGAME 화면으로 돌아갑니다.");
				init();
			}
			System.out.printf("\n[%s 행동]\n", mList.get(i).name);
			if (mList.get(i).isDead == true) {
				System.out.println("[사망] 행동불능");
			} else {
				int num = Util.getRandomIdx(pList);
				if (num != -1) {
					mList.get(i).attack(pList.get(num));
				}
			}
		}

	}

	/** 낚시 페이지 */
	void fishing() {
		// Random rd = new Random();
		fList = UnitManager.instance.fList;
		FishingThread fThread = new FishingThread();
		int pIdx = UnitManager.instance.selectPlayer();
		int fIdx = randomFish();
		if (pIdx == -1) {
			System.out.println("플레이어 선택 오류입니다.");
			return;
		}
		System.out.println("TEST pIdx" + pIdx);
		System.out.println("TEST fIdx" + fIdx);
		Unit user = UnitManager.instance.pList.get(pIdx);
		Unit fish = fList.get(fIdx);
		while (true) {
			System.out.printf("\n[%s 행동]\n", user.name);
			System.out.println("[0]낚시 그만하기 [1]낚싯대 던지기");
			int select = Util.getValue(0, 1);
			if (select == 0) {
				System.out.printf("[%s가 낚싯대를 접습니다.]\nGAME 화면으로 돌아갑니다.\n",user.name);
				init();
			} else if (select == 1) {
				if (user.isDead == true) {
					System.out.printf("\n[%s의 체력이 다했습니다.]\n낚시를 종료합니다.\nGAME 화면으로 돌아갑니다.\n",user.name);
					init();
				}
				System.out.println("[낚시를 시작합니다.]");
				// 3 .. 2.. 1 쓰레드 가능한가요.
				fThread.run();
				System.out.printf("[%s] 가 미끼를 물었습니다 !\n", fish.name);
				System.out.println("\n[행동 선택]");
				System.out.println("[1]당기기 [2]풀기");
				int sel = Util.getValue(1, 2);
				if (sel == 1) {
					if (user instanceof Worrior) {

					} else if (user instanceof Mage) {

					} else if (user instanceof Healer) {

					}
				} else if (sel == 2) {
					// runpoint 를 줄여주고 , 물고기 힘만큼 체력달고,
					// 그러려면 물고기에 힘말고 int 변수 값 하나 줘야 runpoint랑 같아지면 도망가게
					// 물고기 힘은 약할수록 작고 , 새로 줄 변수값은 약할수록 크게,
				}
			}
		}
	}

	/** 랜덤 물고기 인덱스 값 */
	int randomFish() {
		Random rd = new Random();
		fList = UnitManager.instance.fList;
//		System.out.println("[낚시를 시작합니다.]");
//		// 3 .. 2.. 1 쓰레드 가능한가요.
//		int idx = rd.nextInt(fList.size());
//		System.out.printf("[%s] 가 미끼를 물었습니다 !\n", fList.get(idx));
		int num = rd.nextInt(fList.size());
		return num;

	}

}