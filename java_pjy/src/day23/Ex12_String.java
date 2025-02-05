package day23;

import java.util.Scanner;

public class Ex12_String {

	public static void main(String[] args) {
		
		/* 다음 코드 중 잘못된 곳을 찾아 수정하세요.
		 * 문자열을 입력받아 출력하고, 문자열이 EXIT인 경우 종료하는 프로그램 */
		
		String str;
		Scanner scan = new Scanner(System.in);
		
		//String은 번지를 비교하기 때문에 equals로 비교해야함.
		do {
			
			System.out.print("입력 : ");
			str = scan.next();
			
			System.out.println("출력 : " + str);
			
		} while (!str.equals("EXIT"));
		
	}

}
