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
		

		char menu;

		int rank = 0;
		
		do {
			printMenu();
			menu = sc.next().charAt(0);
			int cnt = 0;
			
			switch(menu) {
			case '1':
				cnt = runGame();
		//		System.out.println(cnt);
				
				if(rank > cnt || rank == 0) {
					rank = cnt;
				}
				break;
			case '2':
				printRank(rank);
				System.out.print("메뉴로 가려면 엔터를 입력하세요.");
				sc.nextLine(); // 메뉴 + 엔터 처리용
				sc.nextLine(); // 메뉴로 돌아가기 위한 엔터 처리용
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
		System.out.println("       메뉴");
		System.out.println("-----------------");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("▶ 메뉴 선택 : ");
	}
	
	/**
	 * UpDown 게임 메소드
	 * @return cnt - 최고 기록 확인을 위한 return값
	 */
	
	public static int runGame() {
		int rdNum = (int)(Math.random() * 100 + 1); // (int)(Math.random() * (max - min + 1) + min)
		int num;
		int cnt = 0;
		
		do {
			System.out.print("▶ 입력: ");
			num = sc.nextInt();
			cnt++;
			if(num > rdNum) {
				System.out.println("Down!");
	//			System.out.println(cnt);
			} else if(num < rdNum) {
				System.out.println("Up!");
	//			System.out.println(cnt);
			} else {
				System.out.println("정답!");
	//			System.out.println(cnt);
				
			}
		} while(num != rdNum);
		
		return cnt;
	}
	
	/**
	 * 최고 기록 출력 메소드
	 */
	
	public static void printRank(int rank) {
		if(rank == 0) {
			System.out.println("게임을 실행한 기록이 없습니다.");
		} else {
			
			System.out.println("[최고 기록]");
			System.out.println(rank + "회");
		}
	//	System.out.println(rank == 0? "게임을 실행한 기록이 없습니다." : rank + "회");
	}
	
}
