package day21;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.SocketException;
import java.util.List;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ChatClient {

	private String id;
	private Socket socket;
	private List<Chat> list;
	
	private final String EXIT = "EXIT";
	
	public void receive() {
		Thread t = new Thread(()-> {
			try(ObjectInputStream ois = new ObjectInputStream(socket.getInputStream())) {
				
				
				while(true) {
					//문자열 대신 chat 객체를 받음
					Chat chat = (Chat) ois.readObject();
					
					//채팅 내용이 EXIT와 같으면 종료
					if(chat.getChat().equals(EXIT)) {
						break;
					}

					//받은 객체를 출력
					System.out.println(chat);
					//객체를 채팅내역에 추가
					list.add(chat);
				}
				
			} catch (Exception e) {
				return;
			}
			System.out.println("[상대방이 나갔습니다. 종료하려면 " + EXIT + "를 입력하세요.]");
		});
		t.start();
	}
	
	public void send() {
		Scanner sc = new Scanner(System.in);
		
		try {
			
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
			
			System.out.println("[채팅을 시작합니다.]");
			System.out.println("[종료하려면 " + EXIT + "를 입력하세요.]");
			
			while(true) {
				if(socket == null || socket.isClosed()) {
					throw new SocketException();
				}
				
				String str = sc.nextLine();
				Chat chat = new Chat(id, str);
				
				//문자열이 아닌 chat의 객체를 전송
				oos.writeObject(chat);
				oos.flush();
				
				if(str.equals(EXIT)) {
					break;
				}
				//채팅 기록에 추가
				list.add(chat);
			}
								
		} catch(Exception e) {
			//e.printStackTrace();
		} finally {
			System.out.println("[채팅을 종료합니다.]");
		}
	}
	
	public void run() {
		//send와 receive를 이용하여 호출
		//둘 중 하나만 스레드 이용. 호출한 메소드 중 아래 있는 메소드의 스레드 제거
		//제거하는 이유: 제거하지 않으면 두 메소드가 스레드로 실행되기 때문에 run 메소드가 종료됨
		// -> 채팅이 종료되지 않은 상태에서 종료되어 메인메뉴로 돌아갈 수 있기 때문
		receive();
		send();
	}
	
}
