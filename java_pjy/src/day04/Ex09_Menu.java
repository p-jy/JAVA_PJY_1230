package day04;

import java.util.Scanner;

public class Ex09_Menu {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		
		/*
		 * 다음과 같이 실행되는 코드를 작성하세요.
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 :  1
		 * 문자를 입력하세요(종료하려면 q) : 1
		 * 문자를 입력하세요(종료하려면 q) : a
		 * 문자를 입력하세요(종료하려면 q) : q
		 * 메뉴
		 * 1. 프로그램 실행
		 * 2. 종료
		 * 메뉴 선택 : 2
		 * 프로그램을 종료합니다.
		 */
		
		char menu = 0;
		do {
			printFirstMenu();
			menu = sc.next().charAt(0);
			System.out.println();
			
			runMenu(menu);
			
		} while(menu != '2');
		
		
	//	for( ; ; ) {
	//		printFirstMenu();
	//		char menu1 = sc.next().charAt(0);
	//		if(menu1 == '1') {
	//			printSecondMenu();
	//		} else if(menu1 == '2') {
	//			System.out.println("프로그램을 종료합니다.");
	//			break;
	//		} else {
	//			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
	//			System.out.println();
	//		}
	//	}
		
	}
	
	/*
	 * 첫번째 메뉴 출력하는 메소드
	 */
	
	public static void printFirstMenu() {
		
		System.out.println("    MENU");
		System.out.println("-------------");
		System.out.println("1. 프로그램 실행");
		System.out.println("2. 종료");
		System.out.println("-------------");
		System.out.print("▶ 메뉴 선택: ");

	}
	
	
	/*
	 * q 입력 전까지 반복하여 두번째 메뉴 출력하는 메소드
	 */
	
	public static void printSecondMenu() {
		char menu = 0;
		do {
			System.out.print("문자를 입력하세요(종료하려면 q) : ");
			menu = sc.next().charAt(0);			
		} while(menu != 'q');
		System.out.println();
	}
	
	/**
	 * 메뉴에 따라 기능을 실행하는 메소드
	 * @param menu 선택한 메뉴
	 * @return -
	 */
	
	public static void runMenu(char menu) {
		switch (menu) {
		case '1':
			printSecondMenu();
			break;
		case '2':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("잘못입력하셨습니다. 다시 입력해주세요.");
			System.out.println();
		}
	}
}
