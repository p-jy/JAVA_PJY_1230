package day17;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		String ip = "127.0.0.1";
		int port = 5001;
		Socket socket = null;
		ObjectOutputStream oos;
		ObjectInputStream ois;
		
		try { //소켓 연결
			
			socket = new Socket(ip, port);
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			System.out.println("[연결 성공]");
			
		} catch (Exception e) {
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다.");
			return;
		}
		
		int menu = 0;
		
		do {
			//메뉴 출력
			printMenu();
			//메뉴 입력
			menu = sc.nextInt();
			sc.nextLine();
			
			//서버로 메뉴 전송
			try {
				
				oos.writeInt(menu);
				oos.flush();
				
			} catch(Exception e) {
				e.printStackTrace();
			}
			
			runMenu(menu, ois, oos);
			
		} while(menu != 3);
		
	}

	private static void printMenu() {
		System.out.println("------------");
		System.out.println("1. 플레이");
		System.out.println("2. 기록 조회");
		System.out.println("3. 종료");
		System.out.println("------------");
		System.out.print("메뉴 입력 : ");
		
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		
		switch(menu) {
		case 1:
			play(ois, oos);
			break;
		case 2:
			rank(ois, oos);
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			
		}
		
	}

	private static void play(ObjectInputStream ois, ObjectOutputStream oos) {
		//야구게임 실행
		ArrayList<Integer> com = new ArrayList<Integer>();
		ArrayList<Integer> user = new ArrayList<Integer>();
		
		int strike = 0, ball = 0, count = 0;
		int size = 3;
		
		setCom(com, size);
		
		do {
			
			user.clear();
			getUser(user, size);
			
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			printResult(strike, ball);
			count++;
			
		} while(strike != 3);
		System.out.println("------------");
		
		//플레이 종료 후 이니셜과 기록을 서버에 전송
		System.out.print("이니셜 입력 : ");
		String str = sc.next();
		
		try {
			
			oos.writeUTF(str);
			oos.writeInt(count);
			oos.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
	}

	private static void setCom(ArrayList<Integer> com, int size) {
		HashSet<Integer> c = new HashSet<Integer>();
		int min = 1, max = 9;
		
		while(c.size() < size) {
			int r = (int) (Math.random() * (max - min + 1) + min);
			c.add(r);
		}
		
		com.addAll(c);
		
		Collections.shuffle(com);
		
	}

	private static void getUser(ArrayList<Integer> user, int size) {
		System.out.print("숫자 3개 입력 : ");
		for(int i = 0; i < size; i++) {
			user.add(sc.nextInt());
		}
		
	}
	
	private static int getStrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		int strike = 0;
		
		for(int i = 0; i < com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				strike++;
			}
		}
		
		return strike;
	}

	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		int cnt = 0;
		
		for(int i : com)
			if(user.contains(i)) {
				cnt++;
			}
		
		return cnt - getStrike(com, user);
	}

	private static void printResult(int strike, int ball) {
		
		if(strike == 3) {
			System.out.println("3S");
			System.out.println("프로그램을 종료합니다.");
		} else if(ball > 0 && strike > 0) {
			System.out.println(strike + "S " + ball + "B");
		} else if(strike > 0 && ball == 0)  {
			 System.out.println(strike + "S");
		} else if(ball > 0 && strike == 0) {
			System.out.println(ball + "B");
		} else {
			System.out.println("3O");
		}
		
	}

	private static void rank(ObjectInputStream ois, ObjectOutputStream oos) {
		//서버에 상위 5개의 랭킹 요청 후 출력
		try {
			List<Record> list = (List<Record>) ois.readObject();
//			System.out.println(list);
			if(!printList(list)) {
				return;
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean printList(List<Record> list) {
		if(list == null || list.size() == 0) {
			System.out.println("등록된 기록이 없습니다.");
			return false;
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println((i+1) + ". " + list.get(i));
		}
		System.out.println("------------");
		
		return true;
	}

}
