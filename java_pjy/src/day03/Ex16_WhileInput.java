package day03;

import java.util.Scanner;

public class Ex16_WhileInput {

	public static void main(String[] args) {
		/*
		 * 문자를 입력받아 문자가 q일 때 종료하는 코드를 while문을 사용하여 작성하세요.
		 */

		char ch = 'a';
		
		Scanner sc = new Scanner(System.in);
		
		while(ch != 'q') {
			System.out.print("입력 : ");
			ch = sc.next().charAt(0);
		}
		System.out.println("프로그램을 종료합니다.");
	}

}
