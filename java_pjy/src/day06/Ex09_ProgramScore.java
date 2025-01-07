package day06;

import java.util.Scanner;

public class Ex09_ProgramScore {

	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 학생의 국어 성적을 관리하는 프로그램을 작성.
		 * 
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름: 홍길동
		 * 성적: 100
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 1
		 * 이름: 임꺽정
		 * 성적: 90
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 2
		 * 홍길동: 100
		 * 임꺽정: 90
		 * 평균: 95
		 * 메뉴
		 * 1. 학생 국어 성적 추가
		 * 2. 학생 국어 성적 전체 조회
		 * 3. 종료
		 * 메뉴 선택 : 3
		 * 프로그램이 종료되었습니다.
		 */
		
		Student [] std = new Student[5];

		char menu;
		int count = 0; //저장된 학생 수
		
		do {
		//반복문 (do while문 메뉴가 3이 아니면 반복)
			//메뉴 출력
			printMenu();
			//메뉴 입력받음
			menu = sc.next().charAt(0);
			//입력받은 메뉴 기능 출력
			count = runMenu(menu, std, count);
			std = expend(std, count); //학생 배열이 다 차면 늘려주는 기능 (더 큰 배열을 새로 만들면서 기존 배열 복사해오는 방식)
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
	
	private static int runMenu(char menu, Student[] std, int count) {
		switch(menu) {
		//1: 성적 추가 (이름, 성적)
		case '1':
			count = insertScore(std, count);
			break;
			//2: 전체 성적 조회
		case '2':
			printStudent(std, count);
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
		return count;
	}
	
	private static int insertScore(Student[] std, int count) {
		System.out.print("이름 : ");
		String name = sc.next(); //next() 앞의 공백 제거 후 문자 입력 인식 / nextLine() 앞에 남아있는 엔터를 처리.
		System.out.print("점수 : ");
		int score = sc.nextInt();
		std[count] = new Student(name, score); //Student student = new Student(name, score);
		System.out.println();				   //std[count] = student;
		return count + 1;
	}
	
	private static Student[] expend(Student[] std, int count) {
		if(std == null) {
			return new Student[5];
		}
		
		if(count < std.length) {
			return std;
		}
		//확장
		Student tmp[] = new Student[std.length + 5];
		System.arraycopy(std, 0, tmp, 0, std.length);
		
		return tmp;
	}
	
	private static void printStudent(Student[] std, int count) {
		if(std[0] == null) {
			System.out.println("등록된 점수가 없습니다.");
		}
		int sum = 0;
		for(int i = 0; i < count; i++) {
			std[i].printStd();
			sum += std[i].getScore();
		}
		System.out.println("평균 : " + sum/(double)count);
		System.out.println();
	}
}

class Student{
	private String name;
	private int score;
	
	public Student(String name, int score) {
		this.name = name;
		this.score = score;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	public void printStd() {
		System.out.println(name + " : " + score);
	}
}
