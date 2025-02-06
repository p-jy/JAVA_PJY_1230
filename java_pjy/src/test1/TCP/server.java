package test1.TCP;

import java.net.ServerSocket;
import java.net.Socket;

public class server {

	public static void main(String[] args) {
		
		server s = new server();
		s.server();
		
	}
	
	public void server() {
		int port = 3000;
		
		ServerSocket server;
		
		try {
			server = new ServerSocket(port);
			
			System.out.println("[연결 대기중]");
			
			while(true) {
				Socket client = server.accept();
				System.out.println("[연결 성공]");
				
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
