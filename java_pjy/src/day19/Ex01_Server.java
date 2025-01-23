package day19;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

import day18.Post;

public class Ex01_Server {
	
	private static List<Record> list = new ArrayList<Record>();
	
	public static void main(String[] args) {
		/* 숫자 야구 게임을 구현.
		 * 단, 기록은 서버에 통신을 이용하여 저장.
		 * 기록은 영문3자와 횟수를 기록. ex PJY 3
		 * 기록이 같은 경우 먼저 등록된 순으로 순위를 출력.
		 * 기록은 상위 5명만 출력
		 * */
		
		int port = 5001;
		String fileName = "src/day19/data.txt";
		String fileName2 = "src/day19/count.txt";
		
		try {
			
			ServerSocket serverSocket = new ServerSocket(port);
			list = (List<Record>) load(fileName);
			Integer count = (Integer) load(fileName2);
			count = count == null? 0 : count;
			
			if(list == null) {
				list = new ArrayList<Record>();
			}
			
			while(true) {
				
				try {
					Socket socket = serverSocket.accept();
					System.out.println("[연결 완료]");
					System.out.println();
					
					ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
					ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
					
					while(true) {
						int menu = ois.readInt();
						
						runMenu(menu, ois, oos);
					}
				
					
				} catch(Exception e) {
					System.out.println("[연결 종료]");
					save(fileName, list);
					save(fileName, Post.getCount());
				}
				
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
			oos.writeObject(obj);
					
		} catch (Exception e) {
			System.out.println("-------------");
			System.out.println("저장하기 실패");
			System.out.println("-------------");
		}
		
	}
	private static Object load(String fileName) {
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
		} catch (Exception e) {
			System.out.println("-------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------");
		}
		
		return null;
	}

	private static void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		switch(menu) {
		case 1:
			
			try {
				//플레이 기록 추가
				//클라이언트가 보낸 이니셜과 기록을 저장하여 정렬(기록순, 등록순)
				String name = ois.readUTF();
				int record = ois.readInt();
//				System.out.println(name + record);
				Record rec = new Record(name, record);
				
				list.add(rec);
				sort();
//				System.out.println(list);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
			break;
		case 2:
			try {
			//플레이 기록 전송
			//등록된 기록 중 0~4번지의 기록을 전송
				List<Record> tmpList = new ArrayList<Record>();
				
				if(list.size() >= 5) {
					for(int i = 0; i < 5; i++) {
						tmpList.add(list.get(i));
					}
				} else {
					for(int i = 0; i < list.size(); i++) {
						tmpList.add(list.get(i));
					}
				}
				
				oos.writeObject(tmpList);
				oos.flush();
				
				if(list == null || list.isEmpty()) {
					return;
				}
				
			} catch(Exception e) {
				
			}
			
			break;
		default:
			
		}
		
		
	}

	private static void sort() {
		list.sort((o1, o2)-> {
			if(o1.getRecord() != o2.getRecord()) {
				return o1.getRecord() - o2.getRecord();
			}
			if(!o1.getDate().equals(o2.getDate())) {
				return o1.getDate().compareTo(o2.getDate());
			}
			return o1.getName().compareTo(o2.getName());
		});
		
	}

	

}
