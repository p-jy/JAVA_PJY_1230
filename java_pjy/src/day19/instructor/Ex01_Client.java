package day19.instructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Ex01_Client {
	
	static private Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//서버와 연결
		String ip = "127.0.0.1";
		int port = 5002;
		Socket socket = null;
		
		
		ObjectInputStream ois;
		ObjectOutputStream oos;
		
		try {
			
			socket = new Socket(ip, port);
			System.out.println("[연결 성공]");
			
			//IO스트림 생성
			oos = new ObjectOutputStream(socket.getOutputStream());
			ois = new ObjectInputStream(socket.getInputStream());
			
		} catch(Exception e) {
			System.out.println("[서버 연결 실패]");
			System.out.println("서버와 연결이 되지 않아 프로그램을 종료합니다.");
			return;
		}
		
		int menu;
		do {
			
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu, ois, oos);
			
		} while(menu != 3);
		
	}

	private static void printMenu() {
		
		System.out.println("1. 플레이");
		System.out.println("2. 기록 조회");
		System.out.println("3. 종료");
		System.out.print("메뉴 입력 : ");
		
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		
		switch(menu) {
		case 1:
			//IO스트림을 넘겨줌
			play(menu, ois, oos);
			break;
		case 2:
			//IO스트림을 넘겨줌
			recordView(menu, ois, oos);
			break;
		case 3:
			System.out.println("프로그램 종료");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void play(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		//랜덤 리스트 생성
		List<Integer> nums = randomList(1, 9, 3);
		
		Record r = playGame(nums);
		
		//서버에 전송
		sendRecord(r, ois, oos);
	}

	private static void sendRecord(Record r, ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//메뉴를 전송
			oos.writeInt(1);
			//기록을 전송
			oos.writeObject(r);
			oos.flush();
			//서버에게 결과를 확인받고 실패한 경우 알림
			boolean res = ois.readBoolean();
			
			if(!res) {
				System.out.println("결과가 기록되지 않았습니다.");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	private static List<Integer> randomList(int min, int max, int size) {
		List<Integer> list = new ArrayList<Integer>();
		Set<Integer> set = new HashSet<Integer>();
		
		while(set.size() < size) {
			set.add(random(min, max));
		}
		
		list.addAll(set);
		Collections.shuffle(list);
		
		return list;
	}

	private static void recordView(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		
		try {
			//메뉴 전송
			oos.writeInt(2);
			oos.flush();
			
			List<Record> list = (List<Record>) ois.readObject();
			
			printRecord(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void printRecord(List<Record> list) {
		if(list == null || list.isEmpty()) {
			System.out.println("등록된 기록이 없습니다.");
			System.out.println("지금 플레이하면 1등");
		}
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(i+1 + ". " + list.get(i));
		}
	}

	
	private static Record playGame(List<Integer> nums) {
		int strike, ball;
		List<Integer> user = new ArrayList<Integer>();
		int count = 0;
		
		do {
			user.clear();
			System.out.print("입력 : ");
			
			//사용자가 중복되지 않게 입력했다고 가정.
			while(user.size() < 3) {
				user.add(sc.nextInt());
			}
			++count;
			
			strike = getStrike(nums, user);
			ball = getBall(nums, user);
			
			printResult(strike, ball);
			
		}while (strike < 3);
		
		System.out.print("이니셜 입력(최대 3자) : ");
		String nickName = sc.next();
		
		return new Record(count, nickName);
	}
	
	private static int getStrike(List<Integer> nums, List<Integer> user) {
		int count = 0;
		for(int i = 0; i < nums.size(); i++) {
			if(nums.get(i) == user.get(i)) {
				count++;
			}
		}
		return count;
	}

	private static int getBall(List<Integer> nums, List<Integer> user) {
		int count = 0;
		for(int num : nums) {
			if(user.contains(num)) {
				count++;
			}
		}
		
		return count - getStrike(nums, user);
	}

	private static void printResult(int strike, int ball) {
		if(strike != 0) {
			System.out.print(strike + "S ");
		}
		if(ball != 0) {
			System.out.print(ball + "B");
		}
		if(strike == 0 && ball == 0) {
			System.out.print("3O");
		}
		
		System.out.println();
	}

	private static int random(int min, int max) {
		if(max < min) {
			int tmp = min;
			min = max;
			max = tmp;
		}
		return (int)(Math.random()*(max - min + 1) + min);
	}

}
