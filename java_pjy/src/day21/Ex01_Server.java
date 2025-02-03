package day21;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Ex01_Server {

	/* 1대1 채팅 프로그램을 구현하세요.
	 * - 채팅 기록을 관리하는 기능을 추가
	 * 
	 * 메뉴
	 * - 접속
	 * 	- EXIT를 채팅으로 보내면 채팅을 종료하도록 작성
	 * - 채팅 기록 확인
	 * - 종료
	 */
	private static Scanner sc = new Scanner(System.in);
	private static List<Chat> list = new ArrayList<Chat>();
	
	public static void main(String[] args) {
			
		int menu;
		
		do {
			printMenu();
			menu = sc.nextInt();
			
			runMenu(menu);
		
		} while(menu != 3);
		
	}

	private static void printMenu() {
		System.out.println("-----------------");
		System.out.println("1. 접속");
		System.out.println("2. 채팅 기록 확인");
		System.out.println("3. 종료");
		System.out.println("-----------------");
		System.out.print("메뉴 입력 : ");
	}

	private static void runMenu(int menu) {
		switch(menu) {
		case 1: //접속
			connect();
			break;
		case 2: //채팅 기록 확인
			log();
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[잘못된 메뉴입니다.]");
		}
	}

	private static void connect() {
		int port = 3001;
		
		//아이디 입력
		System.out.print("아이디 : ");
		String id = sc.next();
		
		//서버 소켓 객체 생성
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
		} catch (IOException e) {
			System.out.println("서버 소켓 생성에 실패했습니다.");
			//e.printStackTrace();
			return;
		}
		
		//연결을 기다리다 연결이 성공하면 소켓 객체를 생성
		try(Socket socket = serverSocket.accept()) {
			
			//ChatClient 객체 생성
			ChatClient cc = new ChatClient(id, socket, list);
			//객체 실행 -> 채팅
			cc.run();
				
		} catch (Exception e) {
			//e.printStackTrace();
		} finally {
			if(serverSocket != null && !serverSocket.isClosed()) {
				try {
					serverSocket.close();
				} catch(Exception e) {
					
				}
			}
		}
		
		
	}

	private static void log() {
		//기록된 채팅 리스트 출력
		if(list.isEmpty()) {
			System.out.println("[채팅 기록이 없습니다.]");
			return;
		}
		for(Chat chat : list) {
			System.out.println(chat);
		}
		
	}

}
