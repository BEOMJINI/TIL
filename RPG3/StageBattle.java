package RPG3;

public class StageBattle implements Stage {

	@Override
	public void init() {
		// TODO Auto-generated method stub
		// GameDAO.instance.stageList.put(null, null);
		UnitManager.instance.setPlayer();
		
	}

	@Override
	public void setting() {
		// TODO Auto-generated method stub
		while (true) {
			System.out.println("\n____[ Dungeon ]____");
			System.out.println("[0]뒤로가기 [1]숲 [2]바다");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				GameDAO.instance.changeStage("Forest");
			} else if (sel == 2) {
				GameDAO.instance.changeStage("Ocean");
			}
		}
	}

}
