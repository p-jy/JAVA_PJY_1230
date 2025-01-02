package day03;

import java.util.Scanner;

public class Ex10_ForInput {

	public static void main(String[] args) {
		/*
		 * 문자를 입력받아 입력받은 문자가 q이면 종료되도록 코드를 작성하세요.
		 */
		
		Scanner sc = new Scanner(System.in);
		
		String ch;
		for(int i = 0; ; i++) {
			System.out.print("문자를 입력하세요 : ");
			ch = sc.next();
			if(ch.equals("q")) {
				System.out.println("프로그램이 종료되었습니다.");
				break;
			}
		}
	}

}
