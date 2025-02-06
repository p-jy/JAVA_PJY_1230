package test1.TCP;

import java.net.InetAddress;
import java.net.Socket;

public class client {

	public static void main(String[] args) {
		
		client c = new client();
		
		c.client();
		
	}
	
	public void client() {
		int port = 3000;
		String serverIP;
		
		try {
			serverIP = InetAddress.getLocalHost().getHostAddress();
			
			
			Socket socket = new Socket(serverIP, port);
			System.out.println("[연결 성공]");
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
