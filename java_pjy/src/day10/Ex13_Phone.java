package day10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

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

	private static void insertNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("번호 : ");
		String number = sc.nextLine();
		
		//정규표현식 체크 : 000-0000-0000
		String regex = "^\\d{2,3}(-\\d{4}){2}$";
		
		if(!Pattern.matches(regex, number)) {
			System.out.println("올바른 전화번호가 아닙니다.");
			return;
		}
		
		Number n = new Number(name, number);
		
		num.add(n);
		System.out.println("전화번호를 등록했습니다.");
		
	}

	

	private static void updateNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		ArrayList<Number> tmpList = searchNumberList(name);
		
//		for(int i = 0; i < tmpList.size(); i++) {
//			System.out.println((i+1) + ". " + tmpList.get(i));
//		}
		
		if(!printNumberList(tmpList, true)) {
			return;
		}
		
		System.out.print("수정할 번호 선택 : ");
		int index = sc.nextInt() - 1;
		sc.nextLine();
		
		Number n = tmpList.get(index);
		
		System.out.print("이름 : ");
		String newName = sc.nextLine();
		System.out.print("번호 : ");
		String pNum = sc.nextLine();
		
		n.update(newName, pNum);
		System.out.println("수정이 완료됐습니다.");
		
	}
	
	
	
	private static void deleteNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		ArrayList<Number> tmpList = searchNumberList(name);
		
//		for(int i = 0; i < tmpList.size(); i++) {
//			System.out.println((i+1) + ". " + tmpList.get(i));
//		}
		
		if(!printNumberList(tmpList, true)) {
			return;
		}
		
		System.out.print("삭제할 번호 선택 : ");
		int index = sc.nextInt() - 1;
		
		Number n = tmpList.get(index);
		
		num.remove(n); //Objects.equals() => Object.equals
		System.out.println("전화번호가 삭제 됐습니다.");
				
	}

	
	private static ArrayList<Number> searchNumberList(String name) {
		
		ArrayList<Number> tmpList = new ArrayList<Number>();
		
		for(Number tmp : num) {
			if(tmp.getName().contains(name)) {
				tmpList.add(tmp);
			}
		}
		return tmpList;
	}

	private static void searchNum() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		ArrayList<Number> nList = searchNumberList(name);
		printNumberList(nList, false);
		
//		for(Number tmp : num) {
//			if(tmp.getName().contains(name)) {
//				System.out.println(tmp);
//			}
//		}
		
	}
	
	private static boolean printNumberList(ArrayList<Number> nList, boolean isNumber) {
		if(nList == null || nList.size() == 0) {
			System.out.println("결과가 없습니다.");
			return false;
		}
		for(int i = 0; i < nList.size(); i++) {
			if(isNumber) {
				System.out.print(i + 1 + ". ");
			}
			System.out.println(nList.get(i));
		}
		return true;
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

@Getter
@Setter
@AllArgsConstructor
class Number {
	private String name, number;

	@Override
	public String toString() {
		return name + " : " + number;
	}

	public void update(String newName, String pNum) {
		this.name = newName;
		this.number = pNum;
		
	}
}
