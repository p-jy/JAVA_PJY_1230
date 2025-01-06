package day05;

public class Ex05_Static2 {

	public static void main(String[] args) {
		
		System.out.println(sum1(1, 2));
		
		Ex05_Static2 s = new Ex05_Static2();
		System.out.println(s.sum2(1, 2));
		
		Ex01_Day04_Homework.main(args);
		
	}
	
	public static int sum1(int num1, int num2) {
		return num1 + num2;
	}
	
	public int sum2(int num1, int num2) {
		return num1 + num2;
	}

}

class StaticTest {
	
	int a;
	static int sa;
	
	public void printA() {
		a = 10;
		sa = 10;
	}
	
	public static void printSa() {
//		a = 10; //객체 변수는 정적 메소드에서 사용할 수 없음.
		StaticTest st = new StaticTest(); //객체 생성
		st.a = 10; //객체 변수 사용을 위해 객체를 생성한 후 사용하면 가능.
		
		sa = 10;
	}
	
	public void test() {
		printA();
		printSa();
	}
	
	public static void staticTest() {

//		printA(); //객제 메소드는 정적 메소드에서 사용할 수 없음.
		StaticTest st = new StaticTest(); //객체 생성
		st.printA(); //객체 메소드를 사용하기 위해 객체를 생성한 후 사용하면 가능.
		printSa();
		
	}
	
}