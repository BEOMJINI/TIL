package RPG3;

import java.util.Random;

public class SkillCure implements Skill {

	@Override
	public void skill(Unit u) {
		String name = "큐어";
		String info = "선택한 대상을 회복합니다.";
		Random rd = new Random();
		int power = rd.nextInt(5) + 3;
		int useMp = 5;
		for (Unit s : UnitManager.instance.pList) {
			if (s instanceof Healer) {
				if (s.mp < useMp) {
					System.out.println("MP가 부족합니다!");
					// s.attack(u);
//				} else if (u.isDead == true) {
//					System.out.println("대상이 사망한 상태여서 회복할 수 없습니다.");
				} else {
					System.out.println(name);
					System.out.println(info);
					// power = rd.nextInt(5)+3;
					if (power == 7) {
						power = 10;
						System.out.println("Critical !");
					}
					System.out.printf("[%s]에게 [%d]의 회복\n", u.name, power);
					System.out.printf("[%s]의 MP가 [%d] 만큼 감소합니다.\n", s.name, useMp);
					s.mp -= useMp;

					if (u.hp + power <= u.max_hp) {
						u.hp += power;
					} else {
						u.hp = u.max_hp;
					}

				}
			}
		}
	}

}
