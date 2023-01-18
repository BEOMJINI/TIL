package RPG3;

public class StageOcean implements Stage{

	@Override
	public void init() {
		UnitManager.instance.setOceanMonster();
		System.out.println("[바다 던전에 입장했습니다.]");
	}

	@Override
	public void setting() {
		GameDAO.instance.battle();
	}

}
