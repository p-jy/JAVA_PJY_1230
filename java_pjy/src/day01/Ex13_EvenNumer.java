package day01;

public class Ex13_EvenNumer {

	public static void main(String[] args) {
		/* 
		 * 주어진 num가 짝수이면 true를 아니면 false가 출력되도록 코드를 작성하세요.
		 * 출력 예시1
		 * 3은 짝수인가? false
		 * 출력 예시2
		 * 4는 짝수인가? true */
		
		int num1 = 3, num2 = 4;
		System.out.println(num1 + "은(는) 짝수인가? " + ((num1%2) == 0));
		System.out.println(num2 + "은(는) 짝수인가? " + ((num2%2) == 0));
		
		//int num = 3;
		//boolean isEven = (num % 2) == 0;
		//System.out.println(num + "는 짝수인가? " + isEven);
	}

}
