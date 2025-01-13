package day10;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex13_Phone {
	/* 전화번호를 관리하는 프로그램을 작성하세요.
	 * 
	 * 1. 전화번호 추가
	 * 	- 이름과 전화번호를 입력받아 추가
	 * 	- 동명이인이 있을 수 있음. => 중복되어도 추가
	 * 2. 전화번호 수정
	 * 	- 이름을 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 수정하려는 전화번호를 선택
	 * 	- 새 전화번호를 입력받아 수정
	 * 3. 전화번호 삭제
	 * 	- 이름을 입력
	 * 	- 이름과 일치하는 목록을 출력
	 * 	- 삭제하려는 전화번호를 선택
	 * 	- 선택한 전화번호를 삭제
	 * 4. 전화번호 조회
	 * 	- 이름을 입력
	 * 	- 이름이 포함된 전화번호를 출력
	 * 5. 종료
	 */
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Number> num = new ArrayList<Number>();
	
	public static void main(String[] args) {
		
		int menu;
		
		do {
			
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
		} while(menu != 5);
		
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1: //등록
			insertNum();
			break;
		case 2: //수정
			updateNum();
			break;
		case 3: //삭제
			deleteNum();
			break;
		case 4: //조회
			searchNum();
			break;
		case 5: //종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴를 입력해주세요.");
		}
		
	}

	private static void searchNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int count = 0;
		
		for(Number tmp : num) {
			if(tmp.getName().contains(name)) {
				System.out.print(count + 1 + ". ");
				System.out.println(tmp);
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println("일치하는 항목이 없습니다.");
		}
		System.out.println("---------------------");
		
	}

	private static void deleteNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int count = 0;
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(Number tmp : num) {
			if(tmp.getName().contains(name)) {
				System.out.print(count + 1 + ". ");
				System.out.println(tmp);
				int idx = num.indexOf(tmp);
				System.out.println(idx);
				index.add(idx);
				count++;
			}
		}
		
		if(count == 0) {
			System.out.println("일치하는 항목이 없습니다.");
			return;
		}
		System.out.println("---------------------");
		
		System.out.print("삭제할 번호를 선택하세요 : ");
		int delete = sc.nextInt();

		num.remove(index.get(delete - 1));
		System.out.println("번호를 삭제했습니다.");
		
	}

	private static void updateNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		int count = 0;
		ArrayList<Integer> index = new ArrayList<Integer>();
		
		for(Number tmp : num) {
			if(tmp.getName().contains(name)) {
				System.out.print(count + 1 + ". ");
				System.out.println(tmp);
				int idx = num.indexOf(tmp);
				System.out.println(idx);
				index.add(idx);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("일치하는 항목이 없습니다.");
			return;
		}
		System.out.println("---------------------");
		
		System.out.print("수정할 번호를 선택하세요 : ");
		int update = sc.nextInt();
		
		System.out.print("수정할 번호를 입력해주세요 : ");
		sc.nextLine();
		String newNum = sc.nextLine();
		
		Number tmp = new Number(name, newNum);
		
		num.set(index.get(update - 1), tmp);
		System.out.println("번호를 수정했습니다.");
		
	}

	private static void insertNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("번호 : ");
		String number = sc.nextLine();
		
		Number n = new Number(name, number);
		
		num.add(n);
		System.out.println("전화번호를 등록했습니다.");
		
	}

	private static void printMenu() {
		System.out.println("------------------");
		System.out.println("1. 전화번호 추가");
		System.out.println("2. 전화번호 수정");
		System.out.println("3. 전화번호 삭제");
		System.out.println("4. 전화번호 조회");
		System.out.println("5. 종료");
		System.out.println("------------------");
		System.out.print("메뉴 선택 : ");
		
	}

}

@Data
@AllArgsConstructor
class Number {
	private String name, number;

	@Override
	public String toString() {
		return name + " : " + number;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Number other = (Number) obj;
		return Objects.equals(name, other.name);
	}
	
	
}
