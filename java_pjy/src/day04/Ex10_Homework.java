package day04;

import java.util.Scanner;


public class Ex10_Homework {
	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		/*
		 * 다음과 같이 실행되도록 프로그램을 작성하세요. (UpDown 1~100 게임 참고)
		 * 
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 게임을 실행한 기록이 없습니다.
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 1
		 * 입력 : 50
		 * Down!
		 * 입력 : 25
		 * 정답!
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 2
		 * 2회
		 * (메뉴로 가려면 엔터를 입력하세요.)
		 * 메뉴
		 * 1. UpDown 게임 실행
		 * 2. 최고 기록 확인
		 * 3. 프로그램 종료
		 * 메뉴 선택 : 3
		 * 프로그램을 종료합니다.
		 */
		

		char menu = 0;
		int cnt = 0;
		int count = 0;
		
		do {
			printMenu();
			menu = sc.next().charAt(0);
			
			switch(menu) {
			case '1':
				runGame();
				break;
			case '2':
				switch (count) {
				case 0:
					System.out.println("게임을 실행한 기록이 없습니다.");
				default:
					System.out.println(count + "회");
				}
				break;
			case '3':
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("잘못된 메뉴입니다.");
			}
		} while(menu != '3');

	}
	
	/**
	 * 메뉴 출력 메소드
	 */
	
	public static void printMenu() {
		System.out.println("메뉴");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.print("메뉴 선택 : ");
	}
	
	/**
	 * UpDown 게임 메소드
	 */
	
	public static void runGame() {
		int rdNum = (int)(Math.random() * 100 + 1);
		int num = 0;
		do {
			System.out.print("입력: ");
			num = sc.nextInt();

			if(num > rdNum) {
				System.out.println("Down!");
				cnt++;
				System.out.println(cnt);
			} else if(num < rdNum) {
				System.out.println("Up!");
				cnt++;
				System.out.println(cnt);
			} else {
				System.out.println("정답!");
				cnt++;
				System.out.println(cnt);
				if(count > cnt || count == 0) {
					count = cnt;
				}
			}
		} while(num != rdNum);
	}
	
	
	/**
	 * 정답 맞추기 횟수를 count하는 메소드
	 */
	public static int count() {
		int count = 0;
		int cnt = 0;
		
		return count;
	}
}
