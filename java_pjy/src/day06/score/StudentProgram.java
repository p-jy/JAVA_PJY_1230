package day06.score;

import java.util.Scanner;

//학생 성적을 관리하는 프로그램
public class StudentProgram {

	
	static Scanner sc = new Scanner(System.in);
	public void run() {
		StudentManager sm = new StudentManager();
		Student [] std = new Student[5];

		char menu;
		
		do {
		//반복문 (do while문 메뉴가 3이 아니면 반복)
			//메뉴 출력
			printMenu();
			//메뉴 입력받음
			menu = sc.next().charAt(0);
			//입력받은 메뉴 기능 출력
			runMenu(menu, sm);
		} while(menu != '3');
	}
	
	private static void printMenu() {
		System.out.println("        MENU");
		System.out.println("---------------------");
		System.out.println("1. 학생 국어 성적 추가");
		System.out.println("2. 학생 국어 성적 전체 조회");
		System.out.println("3. 종료");
		System.out.println("---------------------");
		System.out.print("▶ 메뉴 선택: ");
	}
	
	private static void runMenu(char menu, StudentManager sm) {
		switch(menu) {
		//1: 성적 추가 (이름, 성적)
		case '1':
			insertStudent(sm);
			break;
			//2: 전체 성적 조회
		case '2':
			sm.printStudent();
			//이름: 성적 \n 평균: 평균성적
			//등록된 학생&성적 없는 경우 : 등록된 성적이 없습니다.
			break;
		//3: 프로그램 종료
		case '3':
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertStudent(StudentManager sm) {
		System.out.print("이름 : ");
		String name = sc.next(); //next() 앞의 공백 제거 후 문자 입력 인식 / nextLine() 앞에 남아있는 엔터를 처리.
		System.out.print("점수 : ");
		int score = sc.nextInt();
		
		System.out.println();				 
		
		sm.insertStudent(name, score);
		
	}
	
}
