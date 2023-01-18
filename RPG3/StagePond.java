package RPG3;

public class StagePond implements Stage {

	@Override
	public void init() {
		// 물고기세팅
		// 낚시할 플레이어세팅
		UnitManager.instance.setPlayer();
		UnitManager.instance.setPondFish();
		System.out.println("[호수 낚시터에 입장했습니다.]");
	}

	@Override
	public void setting() {
		// gamedao 에서 낚시 메서드
		GameDAO.instance.fishing();
	}

}
