package RPG3;

public class SkillFireBall implements Skill {

	@Override
	public void skill(Unit u) {
		String name = "파이어볼";
		String info = "몬스터 전체에게 데미지를 입힙니다.";
		int power = 20;
		int useMp = 10;
		for (Unit s : UnitManager.instance.pList) {
			if (s instanceof Mage) {
				if (s.mp < useMp) {
					System.out.println("MP가 부족합니다!\n스킬은 발동되지 않고 대상을 공격합니다.");
					s.attack(u);
				} else {
					System.out.println(name);
					System.out.println(info);
					int idx = 0;
					for (Unit m : UnitManager.instance.mList) {
						if (m.isDead == false) {
							m.hp -= power;
							System.out.printf("[%s]에게 [%d]의 데미지\n", m.name, power);
						}

						if (m.hp <= 0) {
							m.hp = 0;
							m.isDead = true;
							System.out.printf("[%s] 사망했습니다.\n", m.name);
						}
						idx++;
					}
					System.out.printf("[%s]의 MP가 [%d] 만큼 감소합니다.\n", s.name, useMp);

					s.mp -= useMp;

				}
			}
		}

	}
}
