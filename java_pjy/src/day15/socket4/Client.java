package day15.socket4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Client {
	
	private String id;
	private Socket socket;
	
	private final static String EXIT = "EXIT";
	
	//연결된 소켓으로 데이터를 받아오는 기능
	public void receive() {
		Thread t2 = new Thread(()-> {
			try {
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				
				System.out.println("종료하려면 " + EXIT + "를 입력하세요.");
				while(true) {
					
					String id = ois.readUTF();
					String str = ois.readUTF();
					
					
					if(str.equals(EXIT)) {
						break;
					}
					System.out.println(id + " : " + str);
					
				}
				System.out.println("[수신 기능을 종료합니다.]");
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		});
		t2.start();
	}
	
	//연결된 소켓으로 데이터를 전송하는 기능
	public void send() {
		Thread t1 = new Thread(()-> {
			Scanner sc = new Scanner(System.in);
			
			try {
				
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				while(true) {
					
					String chat = sc.nextLine();
					
					oos.writeUTF(id);
					oos.writeUTF(chat);
					oos.flush();
					
					if(chat.equals(EXIT)) {
						break;
					}
				}
				System.out.println("[전송 기능을 종료합니다.]");
									
			} catch(Exception e) {
				e.printStackTrace();
			}
			
		});
		
		t1.start();
	}
	
}
