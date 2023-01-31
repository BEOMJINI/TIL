package enumTest;

import java.util.Arrays;

import enumTest.DAYTable.DAY;

class DAYTable {
	enum DAY {
		SUNDAY("일요일"), MONDAY("월요일"), TUESDAY("화요일"), WEDNESDAY("수요일"), THURSDAY("목요일"), FRIDAY("금요일"), SATURDAY("토요일");
		private String val;
		DAY(String val) {
			this.val = val;
		}
		public String toString() {
			return val;
		}
	}
	DAY d;
}
public class exEnum1 {
	public static void main(String[] args) {
		DAYTable t = new DAYTable();
		System.out.println(t.d.SUNDAY);
		System.out.println("_________________");
		DAYTable.DAY[] arr = DAYTable.DAY.values();
		for(DAYTable.DAY tt : arr) {
			System.out.println(tt);
		}
		System.out.println("_________________");
		for(DAY d : DAY.values()) {
			System.out.println(d);
		}
		System.out.println("_________________");
		System.out.println(Arrays.toString(DAY.values()));
	}
}
