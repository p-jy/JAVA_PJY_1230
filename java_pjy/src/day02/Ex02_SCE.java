package day02;

public class Ex02_SCE {

	public static void main(String[] args) {
		int num1 = 10, num2 = 20;
		
		boolean result = num1 < 0 && (num2 = 10) < 0;
		
		System.out.println("결과 값 : " + result);
		System.out.println("num1 : " + num1 + ", num2 : " + num2);

	}

}
