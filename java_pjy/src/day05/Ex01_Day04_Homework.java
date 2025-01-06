package day05;

import java.util.Scanner;

public class Ex01_Day04_Homework {

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
		
		
		int menu, minCount = 0;
		Scanner sc = new Scanner(System.in);
		//반복문
		do {
			//메뉴 출력
			printMenu();
			//메뉴를 입력
			menu = sc.next().charAt(0);
			//메뉴에 맞는 기능을 실행
			minCount = renMenu(menu, minCount);
		} while(menu != '3');

	}

	private static int renMenu(int menu, int minCount) {
		
		//메뉴에 맞는 기능을 실행
		switch(menu) {
		case '1':
			int count = playGame();
			minCount = recordGame(minCount, count);
			break;
		case '2':
			printRecord(minCount);
			break;
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		return minCount;
	}

	private static int recordGame(int minCount, int count) {
		if(minCount == 0) {
			return count;
		}
		
		return minCount > count ? count : minCount;
	}

	private static int playGame() {
		Scanner sc = new Scanner(System.in);
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

	private static void printRecord(int minCount) {
		Scanner sc = new Scanner(System.in);
		
		if(minCount != 0) {
			System.out.println("최고 기록: " + minCount + "회");
		} 
		
	}

	private static void printMenu() {
		System.out.println("       메뉴");
		System.out.println("-----------------");
		System.out.println("1. UpDown 게임 실행");
		System.out.println("2. 최고 기록 확인");
		System.out.println("3. 프로그램 종료");
		System.out.println("-----------------");
		System.out.print("▶ 메뉴 선택 : ");
		
	}

}
