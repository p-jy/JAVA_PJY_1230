package day02;

import java.util.Scanner;

public class Ex14_SwitchOperator {

	public static void main(String[] args) {
		/*
		 * switch문을 이용해서 두 정수와 산술 연산 결과를 출력하는 코드를 작성하세요.
		 * 예시
		 * 두 정수와 산술 연산자를 입력하세요. (예: 1 + 2 ) : 1 / 2
		 * 1 / 2 = 0.5
		 */
		
		Scanner sc = new Scanner(System.in);
		int num1, num2;
		char operator;
		
		System.out.print("두 정수와 산술 연산자를 입력하세요(예: 1 + 2) : ");
		num1 = sc.nextInt();
		operator = sc.next().charAt(0);
		num2 = sc.nextInt();
		
		switch(operator) {
		case '+':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 + num2));
			break;
		case '-':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 - num2));
			break;
		case '*':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 * num2));
			break;
		case '/':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 / (double)num2));
			break;
		case '%':
			System.out.println(num1 + " " + operator + " " + num2 + " = " + (num1 % num2));
			break;
		default:
			System.out.println(operator + "는 산술 연산자가 아닙니다.");
		}
		
	}

}
