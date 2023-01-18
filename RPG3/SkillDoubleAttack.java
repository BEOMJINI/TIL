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
					System.out.println("MP가 부족합니다!\n스킬은 발동되지 않고 대상을 공격합니다.");
					s.attack(u);
				} else {
					System.out.println(name);
					System.out.println(info);
					System.out.printf("[%s]에게 [%d]의 데미지\n", u.name, s.strength);
					System.out.printf("[%s]에게 [%d]의 데미지\n", u.name, s.strength);
					System.out.printf("[%s]의 MP가 [%d] 만큼 감소합니다.\n", s.name, useMp);
					s.mp -= useMp;
					u.hp -= s.strength * 2;
					if (u.hp <= 0) {
						u.hp = 0;
						u.isDead = true;
						System.out.printf("[%s] 사망했습니다.\n", u.name);
					}
				}
			}
		}
//		Unit ss = UnitManager.instance.playerList.get("전사");
//		ss.

	}

}
