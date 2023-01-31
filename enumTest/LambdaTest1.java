package enumTest;

@FunctionalInterface
interface Calculate{
	public int result(int num1 , int num2); 

}
class cal {
	static int add(int a,int b) {return a+b;};
	static int mi(int a,int b) {return a-b;};
	static int multi(int a,int b) {return a*b;};
	
}
public class LambdaTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Calculate plus = (int a , int b)->{
			int c = a+b;
			return c;
		};
		System.out.println(plus.result(1, 1));
		System.out.println("=======");
		Calculate minus = (int a , int b)->{
			int c = a-b;
			return c;
		};
		System.out.println(minus.result(2, 1));
		System.out.println("=======");
		Calculate Multiplication = (int a , int b)->{
			int c = a*b;
			return c;
		};
		System.out.println(Multiplication.result(2, 2));
		
		System.out.println("----------------------------------");
		System.out.println("축약형");
		Calculate add = (a,b) -> a+b;
		Calculate mi = (a,b) -> a-b;
		Calculate gob = (a,b) -> a*b;
		System.out.println(add.result(1, 1));
		System.out.println(mi.result(2, 1));
		System.out.println(gob.result(2, 2));
		
		System.out.println("----------------------------------");
		Calculate add2 = (a,b)->{
			return cal.add(a, b);
		};
		Calculate mi2 = (a,b) -> cal.mi(a,b);
		Calculate multi2 = (a,b) -> cal.multi(a, b);
		System.out.println(add2.result(1, 1));
		System.out.println(mi2.result(2, 1));
		System.out.println(multi2.result(2, 2));
		
	}

}
