package day09;

import java.text.MessageFormat;
import java.util.Scanner;

import javax.management.RuntimeErrorException;

public class Ex12_TryCatch2 {

	public static void main(String[] args) {
		
		/* 두 정수와 산술 연산자를 입력받아 산술 연산 결과를 출력하는 메소드를 작성하세요.
		 * 단, 예외 처리를 적용
		 * 입력 : 1 + 2		입력 : 1 / 2		입력 : 1 % 0					입력 : 1 / 0
		 * 결과 : 3.0			결과 : 0.5		결과 : 0으로 나눌 수 없습니다.		결과 : Infinity
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("입력 : ");
		int num1 = sc.nextInt();
		char op = sc.next().charAt(0);
		int num2 = sc.nextInt();
		
		try {
			double res = calculate(num1, op, num2);
			System.out.println("결과 : " + res);
		} catch (ArithmeticException e) {
			System.out.println("결과 : 0으로 나눌 수 없습니다.");
		} catch (RuntimeException e) {
			System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
		} catch (Exception e) {
			System.out.println(MessageFormat.format("결과 : {0}", e.getMessage()));
		}
		
	}

	private static double calculate(int num1, char op, int num2) throws Exception {
		switch(op) {
		case '+':
			return num1 + num2;
		case '-':
			return num1 - num2;
		case '*':
			return num1 * num2;
		case '%':
			return num1 % num2;
		case '/':
			return num1 / (double)num2;
		default:
			throw new Exception("산술 연산자가 아닙니다.");
		}
	}

}
