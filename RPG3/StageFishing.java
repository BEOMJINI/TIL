package RPG3;

public class StageFishing implements Stage{

	@Override
	public void init() {
	}

	@Override
	public void setting() {
		while (true) {
			System.out.println("\n____[ Fishing ]____");
			System.out.println("[0]뒤로가기 [1]연못 [2]호수");
			int sel = Util.getValue(0, 2);
			if (sel == 0) {
				return;
			} else if (sel == 1) {
				GameDAO.instance.changeStage("Pond");
			} else if (sel == 2) {
				GameDAO.instance.changeStage("Lake");
			}
		}
	}

}
