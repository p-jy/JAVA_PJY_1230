package day20;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

public class Server {

	private Socket socket;
	private ObjectInputStream ois;
	private ObjectOutputStream oos;
	private List<Account> list;

	
	public Server(Socket socket, List<Account> list) {
		
		this.socket = socket;
		this.list = list;
		
		if(socket == null) {
			return;
		}
		
		try {
			
			ois = new ObjectInputStream(socket.getInputStream());
			oos = new ObjectOutputStream(socket.getOutputStream());
			
		} catch (Exception e) {
			//e.printStackTrace();
		}
		
	}

	public void run() {
		if(socket == null || oos == null || ois == null || list == null) {
			return;
		}
		try {
			//메뉴를 수신
			int menu = ois.readInt();
			
			//메뉴에 따라 기능을 실행
			runMenu(menu);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void runMenu(int menu) {
		
		switch(menu) {
		case 0: //계좌 개설
			open();
			break;
		case 1: //입금
			deposit();
			break;
		case 2: //출금
			withdrawal();
			break;
		case 3: //조회
			check();
			break;
		default:
		}
		
	}

	private void open() {
		
		try {
			
			Account account = (Account) ois.readObject();

			boolean res = true;
			
			if(list.add(account)) {
				res = false;
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private void deposit() {
		
		try {
			int depositMoney = ois.readInt();
			
		} catch (Exception e) {
			
		}
		
	}

	private void withdrawal() {
		
	}

	private void check() {
		
	}

	

}
