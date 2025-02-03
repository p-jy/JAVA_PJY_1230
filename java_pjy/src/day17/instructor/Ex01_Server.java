package day17.instructor;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ex01_Server {
	
	private static List<Record> list = new ArrayList<Record>();
	
	public static void main(String[] args) {
		
		int port = 5002;
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(port);
			
			if(list == null) {
				list = new ArrayList<Record>();
			}
			
			
			while(true) {
				Socket socket = serverSocket.accept();
				Thread t = new Thread(()-> {
					try {
						
						System.out.println("[연결 성공]");
						
						ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
						ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
						
						while(true) {
							int menu = ois.readInt();
							
							runMenu(menu, ois, oos);
						}
						
					} catch(Exception e) {
						System.out.println("[연결 해제]");
					}
				});
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		
		switch(menu) {
		case 1:
			insertRecord(ois, oos);
			break;
		case 2:
			recordView(ois, oos);
			break;
		default:
		}
		
	}

	private static void recordView(ObjectInputStream ois, ObjectOutputStream oos) {
		//클라이언트에게 기록 리스트를 전송 (최대 5개)
		try {
			List<Record> tmp = new ArrayList<Record>();
			tmp.addAll(list.subList(0, Math.min(5, list.size())));
			oos.writeObject(tmp);
			oos.flush();
			
			if(list == null || list.isEmpty()) {
				return;
			}
		} catch (IOException e) {
			System.out.println("[기록 조회 시 예외 발생]");
		}
		
		
		
		
	}

	private static void insertRecord(ObjectInputStream ois, ObjectOutputStream oos) {
		try {
			Record r = (Record) ois.readObject();
			boolean res = list.add(r);
			
			Collections.sort(list, (o1, o2)-> {
				Record r1 = (Record)o1;
				Record r2 = (Record)o2;
				if(r1.getCount() != r2.getCount()) {
					return r1.getCount() - r2.getCount();
				}
				if(!r1.getDate().equals(r2.getDate())) {
					return r1.getDate().compareTo(r2.getDate());
				}
				return r1.getNickName().compareTo(r2.getNickName());
			});
			
			oos.writeBoolean(res);
			oos.flush();
			
			
		} catch(Exception e) {
			System.out.println("[기록 추가 시 예외 발생]");
		}
		
	}

}
