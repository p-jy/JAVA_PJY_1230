package day06;

public class Ex01_Swap {

	public static void main(String[] args) {
		
		/*
		 * 두 정수의 값을 바꾸는 코드를 작성하세요.
		 */
		
		int num1 = 10, num2 = 20;
		
		//num1에 20이, num2에 10이 저장되도록 코드를 작성하고, 출력해서 확인
		
		int num3; //값을 저장해둘 변수 하나 선언
		
		num3 = num2; //num2의 값을 num3에 저장
		num2 = num1; //num1의 값을 num2에 저장
		num1 = num3; //num3에 저장해두었던 값(num2)을 num1에 저장
		
		System.out.println("num1 : " + num1 + ", num2 : " + num2);

	}

}
