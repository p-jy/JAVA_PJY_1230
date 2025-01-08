package day07;

import java.util.Scanner;

public class Ex06_AccountBook {
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		/*
		 * 가계부에 필요한 클래스를 선언.					메뉴
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
		
		
		
		Item[] list = new Item[10];
		int menu, count = 0;
		
		list[count++] = new Item("수입", "월급", "1월 월급", 1000000, "2025-01-08");
		
		//반복 : 종료를 선택하기 전까지
		do {
			//메뉴 출력
			System.out.print("메뉴\r\n"
					+ "1. 가계부 등록\r\n"
					+ "2. 가계부 수정\r\n"
					+ "3. 가계부 삭제\r\n"
					+ "4. 가계부 조회\r\n"
					+ "5. 종료\r\n"
					+ "메뉴 선택 : ");
			//메뉴 선택
			menu = sc.nextInt();
			System.out.println("-----------------");
			//선택한 메뉴에 따른 기능 실행
			switch(menu) {
			case 1:
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
				System.out.println("-----------------");
				
				list[count] = new Item(income, type, content, money, date);
				count++;
				break;
			case 2:
				printList(list, count);
				System.out.print("수정할 내역의 번호를 입력하세요 : ");
				int change = sc.nextInt();
				
				if(change <= count) {
					System.out.print("금액 : ");
					money = sc.nextInt();
					list[change-1].setMoney(money);
				
					System.out.println("수정이 완료됐습니다.");
				} else {
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 3:
				printList(list, count);
				System.out.print("삭제할 내역의 번호를 입력하세요 : ");
				int delete = sc.nextInt();
				
				if(delete <= count) {
					for(int i = delete-1; i < count - 1; i++) {
						list[i] = list[i+1];
					}
					count--;
					System.out.println("삭제가 완료됐습니다.");
				} else {
					System.out.println("잘못 입력했습니다.");
				}
				break;
			case 4:
				printList(list, count);
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				System.out.println("-----------------");
				break;
			default:
				System.out.println("올바른 메뉴가 아닙니다.");
				System.out.println("-----------------");
			}
		} while (menu != 5);
	}
	
	public static void printList(Item[] list, int count) {
		for(int i = 0; i < count; i++) {
			list[i].print(i+1);
		}
		System.out.println("-----------------");
	}

}

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
	
	public boolean equal(int num) {
		
		return false;
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
