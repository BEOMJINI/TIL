package RPG3;

public class StageForest implements Stage{

	@Override
	public void init() {
		// player set , stagebattle 에서
		// 숲 몬스터 set 
		UnitManager.instance.setForestMonster();
		System.out.println("[숲 던전에 입장했습니다.]");
	}

	@Override
	public void setting() {
		// TODO Auto-generated method stub
		GameDAO.instance.battle();
	}

}
