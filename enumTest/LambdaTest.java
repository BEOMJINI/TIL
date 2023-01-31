package enumTest;

import java.util.function.Function;

@FunctionalInterface
interface Type1{
	void call();
}
@FunctionalInterface
interface Type2{
	void call(int num ,String msg);
	
}

@FunctionalInterface
interface Type3{
	int call();
}

@FunctionalInterface
interface Type4{
	boolean call(int num);
}


public class LambdaTest {

	public static void main(String[] args) {

		Type1 t1 = () -> System.out.println("type1 호출");
		t1.call();
		System.out.println("===============");
		Function<Integer, String> t2;
		t2 = Integer -> "2";
		t2 = String -> "type2 호출";
		System.out.println(t2.apply(2));
		System.out.println("===============");
		Type2 t22 = (int a , String b) ->{
			System.out.println("type2 호출 int = " +a);
			System.out.println(b);
		};
		t22.call(-1, "dd");
		System.out.println("===============");
		Type3 t3 = () -> 3;
		System.out.println(t3.call());
		System.out.println("===============");
		Type4 t4 = (integer) -> true;
		System.out.println(t4.call(3));
		System.out.println("===============");
		Type4 t44 = (int c )->{
			if(c>100) return true;
			else return false;
		};
		System.out.println(t44.call(50));
		System.out.println(t44.call(150));
	}

}
