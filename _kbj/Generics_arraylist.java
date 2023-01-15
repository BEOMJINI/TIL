package _kbj;

import java.util.ArrayList;

// <> : 제네릭클래스 , <>안에 자료형 클래스 선언(integer, String...) : 기본타입은 사용할수 없고 래퍼클래스(wrapper class)를 사용한다.
/* 기본타입 , 래퍼클래스
 * byte , Byte
 * short , Short
 * int , Integer
 * long , Long
 * float , Float
 * double , Double
 * char , Character
 * boolean , Boolean
*/

// T : 자료형 매개변수. 타입이 정해져있지않음, 그래서 Object. 인스턴스생성될때 클래스 선언해서 선언한 클래스의 타입으로 결정됨.
// 예시 : 106줄
class MyArrayListG<T> {

	Object[] list;

	// arraylist 구동 세부 코드 (배열 컨트롤러)
	// size() add() add() get() set() remove() clear()

	// 추가
	void add(T d) {
		if (list == null) {
			list = new Object[1];
		} else {
			Object[] temp = list;
			list = new Object[list.length + 1];
			for (int i = 0; i < temp.length; i++) {
				list[i] = temp[i];
			}

		}
		list[list.length - 1] = (T) d;
	}

	// 삽입
	void add(int idx, T val) {
		if (idx < 0 || idx > list.length) {
			throw new IndexOutOfBoundsException();
		}
		Object[] temp = list;
		list = new Object[list.length + 1];
		int index = 0;
		for (int i = 0; i < list.length; i++) {
			if (idx == i) {
				list[i] = (T) val;
			} else {
				list[i] = temp[index];
				index++;
			}
		}
	}

	// get 해당 인덱스 번째에 있는 요소를 가져온다
	T get(int idx) {
		if (idx < 0 || idx >= list.length) {
			throw new IndexOutOfBoundsException();
		}
		return (T) list[idx];
	}

	// 수정
	void set(int idx, T val) {
		if (idx < 0 || idx >= list.length) {
			throw new IndexOutOfBoundsException();
		}
		list[idx] = (T) val;
	}

	// 삭제
	void remove(int idx) {
		if (idx < 0 || idx >= list.length) {
			throw new IndexOutOfBoundsException();
		}
		Object[] temp = list;
		list = new Object[list.length - 1];
		int index = 0;
		for (int i = 0; i < temp.length; i++) {
			if (idx != i) {
				list[index] = temp[i];
				index++;
			}
		}
	}

	// length
	int size() {
		if (list == null) {
			return 0;
		}
		return list.length;
	}

	// system.out.println(list);
	@Override
	public String toString() {
		String data = "";
		if (list != null) {
			for (Object val : list) {
				data += val + ",";
			}
			data = data.substring(0, data.length() - 1);
		}
		return "[" + data + "]";
	}

	// 초기화,null
	void clear() {
		list = null;
	}
}

class moist {

	String name;
	int age;

	public moist(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "" + name + ":" + age + "\n";
	}

}

public class Generics_arraylist {

	public static void main(String[] args) {

		// size() : int 길이출력 , .length
		// add(int idx) : void 값 추가
		// add(int idx, int val) : void 값 삽입
		// get(int idx) : int 에 있는 값 불러오기
		// set(int idx, int val): void 값 수정
		// remove(int idx): void 값 삭제
		// clear() : void 값 전부 삭제

		// 래퍼 클래스 : 원시타입의 자료형을 감싼 클래스
		// int 하는 원시타입 : 순수하게 값만 저장
		// Interger 클래스 : 값 저장 + 기능

		// arraylist : 고정된 배열을 가변배열로 활용할 수 있게 하는 클래스다.
		ArrayList<Integer> list = new ArrayList<Integer>();

		System.out.println(list.size()); // length : 길이값을 출력
		list.add(10);
		list.add(20);
		System.out.println(list.size()); // length : 길이값을 출력
		list.add(30);
		list.add(40);
		System.out.println(list.size()); // length : 길이값을 출력
		System.out.println(list);
		// 삭제
		list.remove(0);
		System.out.println(list);
		// 수정
		list.set(1, 10000);
		System.out.println(list);
		// 삽입
		list.add(2, 100);
		// 배열 값 접근
		System.out.println(list.get(0)); // list[0]
		System.out.println(list);
		list.clear(); // 초기화
		System.out.println(list);

		// 예시
		System.out.println("_____________________");
		MyArrayListG<moist> mlist = new MyArrayListG();
		System.out.println(mlist.size());
		mlist.add(new moist("아큐브", 10));
		mlist.add(new moist("렌즈", 90));
		System.out.println(mlist);
		System.out.println(mlist.get(0));
		System.out.println(mlist.get(0).name);
		mlist.add(0, new moist("일회용", 50));
		mlist.set(1, new moist("수정", 30));
		mlist.remove(2);
		System.out.println(mlist);

		// remove 시 주의사항
		System.out.println("_____________________");
		int[] arr = { 1, 1, 3, 2, 2, 3, 3, 4, 4, 5, 5, 4 };
		int val = 3;
		MyArrayListG<Integer> kinder = new MyArrayListG();
		for (int num : arr) {
			kinder.add(num);
		}
		System.out.println(kinder);
		for (int i = 0; i < kinder.size(); i++) {
			if (kinder.get(i) == val) {
				kinder.remove(i);
				i--; // ★
			}
		}
		System.out.println(kinder);
	}

}