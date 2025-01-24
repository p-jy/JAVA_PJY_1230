package day20;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientProgram {

	private Scanner sc;
	
	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	
	public ClientProgram(Socket socket) {
		
		this.socket = socket;
		this.sc = new Scanner(System.in);
		
		if(socket == null) {
			return;
		}
		
		try {
			
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
		
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		
		if(socket == null || ois == null || oos == null) {
			System.out.println("서버 연결에 실패했습니다.");
			return;
		}
		
		int menu;
		do {
			
			printMenu();
			menu = sc.nextInt();
			
			reunMenu(menu);
			
		} while(menu != 3);
		
	}

	private void printMenu() {
		
		System.out.println("");
		
	}

	private void reunMenu(int menu) {
		
		switch(menu) {
		case 1:
			login();
			break;
		case 2:
			open();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
		}
		
	}

	private void login() {
		
		Account account = inputAccount();
		System.out.println("[접속 중]");
		System.out.println("[같은 계정으로 다른 사용자가 먼저 사용 중이면 대기할 수 있습니다.]");
		
		//서버와 통신해서 account가 일치하는지 확인. => 서버에게 ccount와 일치하는 계좌 정보를 달라고 요청
		
		//일치하지 않으면 안내문구 출력
		
		System.out.println("[계좌에 접속했습니다.]");
		
		int menu;
		do {
			
			printLoginMenu();
			menu = sc.nextInt();
			
			runLoginMenu(menu, account);
			
		} while(menu != 4);
		
	}

	private Account inputAccount() {
		
		System.out.print("은행 : ");
		String bank = sc.next();
		Bank b = Bank.valueOf(bank);
		System.out.print("이름 : ");
		String name = sc.next();
		System.out.print("계좌번호 : ");
		String num = sc.next();
		System.out.print("비밀번호 : ");
		String pw = sc.next();
		
		return new Account(b, name, num, pw);
	}

	private void printLoginMenu() {
		
		System.out.println("1. 예금 조회");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 이전");
		System.out.print("메뉴 입력 : ");
		
	}

	private void runLoginMenu(int menu, Account account) {
		
		switch(menu) {
		case 1:
			deposit(account);
			break;
		case 2:
			withdrawal(account);
			break;
		case 3:
			check(account);
			break;
		case 4:
			
			break;
		default:
		}
		
	}

	private void deposit(Account account) {
		
		System.out.print("입금할 금액 입력 : ");
		int depositMoney = sc.nextInt();
		
		try {
			//서버에 입금할 금액 전달
			oos.writeInt(depositMoney);
			oos.flush();
			
			//처리결과 받음 => 결과에 따라 알림 출력
			boolean res = ois.readBoolean();
			int money = ois.readInt();
			
			if(res) {
				System.out.println(depositMoney + "원을 입금하였습니다.");
				System.out.println("입금 후 잔액 : " + money + "원");
			} else {
				System.out.println("입금 실패");
				System.out.println("현재 잔액 : " + money + "원");
			}
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	private void withdrawal(Account account) {
		
		System.out.print("출금할 금액 입력 : ");
		int withdrawalMoney = sc.nextInt();
		
		try {
			
			oos.writeInt(withdrawalMoney);
			oos.flush();
			
			boolean res = ois.readBoolean();
			int money = ois.readInt();
			
			if(res) {
				System.out.println(withdrawalMoney + "원을 출금하였습니다.");
				System.out.println("출금 후 잔액 : " + money + "원");
			} else {
				System.out.println("잔액이 부족합니다.");
				System.out.println("현재 잔액 : " + money + "원");
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
	}

	private void check(Account account) {
		
		try {
			
			int money = ois.readInt();
			System.out.println("현재 잔액 : " + money + "원");
			
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
	}

	private void open() {
		
		Account account = inputAccount();
		
		try {
			
			oos.writeObject(account);
			oos.flush();
			
			boolean res = ois.readBoolean();
			
			if(res) {
				System.out.println("계좌 개설 완료");
			} else {
				System.out.println("계좌 개설 실패");
			}
			
		} catch(Exception e) {
			//e.printStackTrace();
		}
		
	}
	
}
