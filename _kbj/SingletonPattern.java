package _kbj;

// 싱글톤 패턴 : 자바 Gof 디자인 패턴 중 1개
// 클래스의 객체를 단 1개만 생성하는 패턴 
// 알아야하는 개념 : 접근제어자, static , get set 캡슐화 
class Company {
	// 1.
	private Company() {}	// 1.  private으로 생성자를 막아준다. , company클래스 내부에서만 접근가능
	private static Company instance;	// static 사용해 외부에서 객체 생성없이 company 이름으로 외부에서 접근가능하게 함. 25번째줄
										// static만 사용하면 외부에서 접근해 값을 수정할 수 있는 문제가 생김. 26번째줄. 그래서 얘도 숨기기위해 private. 
	static Company getInstance() {		// 그러므로 get 캡슐화해서 간접접근하게. 얘도 static
		if (instance == null) {			// 9번째줄 private static Company instance = new company(); 대신에.(선택차이) 33번째줄 참고
			instance = new Company();
//			System.out.println("최소 한번 실행");
		}
//		}else {
//			System.out.println("두번째 호출");
//		}
		return instance;
	}
}

public class SingletonPattern {

	public static void main(String[] args) {
		// Company com1 = Company.instance;//new Company();
		// com1.instance = null;
		Company com2 = Company.getInstance();
		Company com3 = Company.getInstance();
		
	}
	/*
	private company() {}
	private static company instance = new company();
	static company getinstance() {
		return instance;
	}
	*/
}