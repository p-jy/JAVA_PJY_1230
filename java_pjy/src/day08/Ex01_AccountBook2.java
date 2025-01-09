package day08;

import java.util.Scanner;

public class Ex01_AccountBook2 {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
			
		
		
		Item[] list = new Item[10];
		int menu, count = 0;
		
		list[count++] = new Item("수입", "월급", "1월 월급", 1000000, "2025-01-08");
		
		//반복 : 종료를 선택하기 전까지
		do {
			//메뉴 출력
			printBar('-', 15);
			printMenu("가계부 등록",
					  "가계부 수정",
					  "가계부 삭제",
					  "가계부 조회",
					  "종료");
						//메뉴 선택
			menu = sc.nextInt();
			//선택한 메뉴에 따른 기능 실행
			count = runMenu(menu, list, count);
		} while (menu != 5);
	}
	
	public static void printBar(char bar, int count) {
		for(int i = 1; i <= count; i++) {
			System.out.print(bar);
		}
		System.out.println();
	}
	
	public static void printMenu(String ... menus) {
		if(menus.length == 0) {
			System.out.println("메뉴 없음");
			return;
		}
		for(int i = 0; i < menus.length; i++) {
			String menu = menus[i];
			System.out.println(i+1 + ". " + menu);
		}
		printBar('-', 15);
		System.out.print("메뉴 선택 : ");
	}
	
	public static int runMenu(int menu, Item[] list, int count) {
		switch(menu) {
		case 1:
			list[count++] = inputItem();
			break;
		case 2:
			updateItemList(list, count);
			break;
		case 3:
			count = deleteItemList(list, count);
			break;
		case 4:
			printItems(list, count);
			printBar('-', 15);
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			printBar('-', 15);
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			printBar('-', 15);
		}
		
		return count;
	}
	
	public static boolean printItems(Item[] list, int count) {
		if(count == 0 || list == null) { //등록된 내역이 없는 경우 예외 처리
			System.out.println("등록된 내역이 없습니다.");
			return false;
		}
		for(int i = 0; i < count; i++) {
			list[i].print(i+1);
		}
		printBar('-', 15);
		
		return true;
	}
	
	public static Item inputItem() {
		System.out.print("수입/지출 : ");
		String income = sc.next();
		System.out.print("분류 : ");
		String type = sc.next();
		System.out.print("내용 : ");
		sc.nextLine(); //next()에서 입력한 엔터를 처리
		String content = sc.nextLine();
		System.out.print("금액 : ");
		int money = sc.nextInt();
		System.out.print("일시 : ");
		sc.nextLine();
		String date = sc.nextLine();
		
		Item item = new Item(income, type, content, money, date);
		
		return item;
	}
	
	public static boolean checkIndex(int index, int count) {
		if(index < count && index >= 0) {
			return true;
		}
		
		return false;
		//return index >= 0 && index < count; 위와 동일
	}

	public static void updateItemList(Item[] list, int count) {
		if(!printItems(list, count)) {
			return;
		}
		
		System.out.print("수정할 내역의 번호를 입력하세요 : ");
		int index = sc.nextInt() - 1;
		
		//입력한 번호가 올바른 번호인지를 확인
		if(!checkIndex(index, count)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return;
		}
		
		System.out.print("금액 : ");
		int money = sc.nextInt();
		list[index].setMoney(money);
		
		System.out.println("수정이 완료됐습니다.");
		
	}
	
	public static void deleteItem(Item[] list, int count, int index) {
		for(int i = index + 1; i < count; i++) {
			list[i-1] = list[i];
		}
	}
	
	public static int deleteItemList(Item[] list, int count) {
		if(!printItems(list, count)) {
			return count;
		}
		System.out.print("삭제할 내역의 번호를 입력하세요 : ");
		int index = sc.nextInt() - 1;
		
		if(!checkIndex(index, count)) {
			System.out.println("잘못된 번호를 선택했습니다.");
			return count;
		}
		
		deleteItem(list, count, index);
		count--;
		System.out.println("삭제가 완료됐습니다.");
		
		return count;
	}
	
}

/* 가계부에 필요한 클래스를 선언.
 * 					메뉴
 * 											1. 가계부 등록
 * 메뉴										2. 가계부 수정
 * 1. 가계부 등록								3. 가계부 삭제
 * 2. 가계부 수정								4. 가계부 조회
 * 3. 가계부 삭제								5. 종료
 * 4. 가계부 조회								메뉴 선택 : 4
 * 5. 종료									-------------------
 * 메뉴 선택 : 1								1. 수입/월급/1월 월급/2000000/2025-01-08
 * -------------------						-------------------
 * 수입/지출 : 수입								메뉴
 * 분류 : 월급									1. 가계부 등록
 * 내용 : 1월 월급								2. 가계부 수정
 * 금액 : 1000000								3. 가계부 삭제
 * 일시 : 2025-01-08							4. 가계부 조회
 * -------------------						5. 종료
 * 가계부 등록이 완료됐습니다.						-------------------
 * -------------------						1. 수입/월급/1월 월급/2000000/2025-01-08
 * 메뉴										삭제할 내역의 번호를 선택하세요 : 1
 * 1. 가계부 등록								-------------------
 * 2. 가계부 수정								삭제가 완료됐습니다.
 * 3. 가계부 삭제								-------------------
 * 4. 가계부 조회								메뉴
 * 5. 종료									1. 가계부 등록
 * 메뉴 선택 : 2								...
 * -------------------						5. 종료
 * 1. 수입/월급/1월 월급/1000000/2025-01-08		메뉴 선택 : 5
 * 수정할 내역의 번호를 입력하세요 : 1				-------------------
 * 금액 : 2000000								프로그램을 종료합니다.
 * -------------------						-------------------
 * 수정이 완료됐습니다.
 */


class Item {
	String income;
	String type;
	String content;
	int money;
	String date;
	
	public Item(String income, String type, String content, int money, String date) {
		this.income = income;
		this.type = type;
		this.content = content;
		this.money = money;
		this.date = date;
	}

	public void print() {
		System.out.println(income + "/" + type + "/" + content + "/" + money + "/" + date);
	}
	
	public void print(int num) {
		System.out.print(num + ". ");
		print();
	}
	
	public void setMoney(int money) {
		this.money = money;
	}
}
