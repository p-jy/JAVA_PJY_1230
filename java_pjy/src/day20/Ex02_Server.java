package day20;

import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


public class Ex02_Server {
	
	public static void main(String[] args) {
		
		ServerSocket serverSocket;
		List<Account> list = new ArrayList<Account>();
		
		//클라이언트와 연결
		Socket socket = null;
		
		//클라이언트를 실행
		Server server = new Server(socket, list);
		server.run();
		
	}

}
