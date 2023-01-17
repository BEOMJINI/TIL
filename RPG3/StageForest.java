package RPG3;

public class StageForest implements Stage{

	@Override
	public void init() {
		// player set , stagebattle 에서
		// 숲 몬스터 set 
		UnitManager.instance.setForestMonster();
	}

	@Override
	public void setting() {
		// TODO Auto-generated method stub
		GameDAO.instance.battle();
	}

}
