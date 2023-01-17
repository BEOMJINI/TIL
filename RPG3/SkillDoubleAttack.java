package RPG3;

public class SkillDoubleAttack implements Skill {

	@Override
	public void skill(Unit u) {
		// TODO Auto-generated method stub
		String name = "더블어택";
		String info = "선택한 대상을 힘 수치 만큼 2번 공격합니다.";

		int useMp = 10;
		for (Unit s : UnitManager.instance.pList) {
			if (s instanceof Worrior) {
				if (s.mp < useMp) {
					System.out.println("MP가 부족합니다!");
					return;
				}
				System.out.println(name);
				System.out.println(info);
				System.out.printf("[%s]에게 [%d]의 데미지\n", u.name, s.strength);
				System.out.printf("[%s]에게 [%d]의 데미지\n", u.name, s.strength);
				s.mp -= useMp;
				u.hp -= s.strength*2;
				if (u.hp <= 0) {
					u.hp = 0;
					u.isDead = true;
					System.out.println(u.name + " 사망");
				}
			}
		}
//		Unit ss = UnitManager.instance.playerList.get("전사");
//		ss.

	}

}
