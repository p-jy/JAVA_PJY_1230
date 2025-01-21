package day17.socket3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Ex04_Client {

	public static void main(String[] args) {
		int port = 5001;
		String ip = "127.0.0.1";
		
		try {
			//서버 소켓 생성
			Socket socket = new Socket(ip, port);
			
			System.out.println("[연결 성공]");
			
			Client c = new Client(socket);
			c.receive();
			c.send();
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
