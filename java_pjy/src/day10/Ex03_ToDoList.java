package day10;

import java.util.ArrayList;
import java.util.Scanner;

public class Ex03_ToDoList {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<String> list = new ArrayList<String>();
	
	public static void main(String[] args) {
		/* 다음 기능을 갖는 프로그램을 작성하세요.
		 * 1. 할일 등록		1. 할일 등록		1. 할일 등록			1. 할일 등록		1. 할일 등록
		 * 2. 할일 삭제		2. 할일 삭제		2. 할일 삭제			2. 할일 삭제		2. 할일 삭제
		 * 3. 할일 조회		3. 할일 조회		3. 할일 조회			3. 할일 조회		3. 할일 조회
		 * 4. 종료			4. 종료			4. 종료				4. 종료			4. 종료
		 * 메뉴 선택 : 1		메뉴 선택 : 1		메뉴 선택 : 2			메뉴 선택 : 3		메뉴 선택 : 4
		 * 등원				수업				1. 등원				1. 수업			프로그램을 종료합니다.
		 * 									2. 수업
		 * 									삭제할 할일을 선택 : 1
		 * 									삭제 되었습니다.
		 */
		
		
		
		int menu;
		
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
			
		} while(menu != 4);
		
	}
	
	public static void printMenu() {
		System.out.print("1. 할일 등록\r\n"
				+ "2. 할일 삭제\r\n"
				+ "3. 할일 조회\r\n"
				+ "4. 종료\r\n"
				+ "메뉴 선택 : ");
	}
	
	public static boolean printToDoList() {
		if(list.size() == 0) {
			System.out.println("등록된 할일이 없습니다.");
			return false;
		}
		
		System.out.println("---------------");
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i + 1) + ". " + list.get(i));
		}
		System.out.println("---------------");
		
		return true;
	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertToDo();
//			print(list);
			break;
		case 2:
			deleteToDo();
//			print(list);
			break;
		case 3: 
			printToDoList();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}
	
	public static void insertToDo() {
		System.out.print("할일 : ");
		String tmp = sc.next();
		list.add(tmp);
		System.out.println("할일을 등록했습니다.");
		System.out.println("---------------");
	}
	
	public static void deleteToDo() {
		if(!printToDoList()) {
			return;
		}
		
		System.out.print("삭제할 할일을 선택 : ");
		int delete = sc.nextInt() - 1;
		
		if(delete >= list.size() || delete < 0) {
			System.out.println("잘못된 번호입니다.");
			return;
		}
		list.remove(delete);
		System.out.println("할일이 삭제되었습니다.");
		System.out.println("---------------");
	}

}




