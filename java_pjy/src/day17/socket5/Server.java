package day17.socket5;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Server {
	
	private List<Student> list;
	private Socket socket;
	
	public void run() {
		
		Thread t = new Thread(()-> {
			
			try {
				
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				
				//클라이언트가 메뉴를 보내면 서버는 메뉴를 수신
				int menu;
				
				do {
					
					menu = ois.readInt();
					
					//수신한 메뉴에 따라 작업이 달라짐
					runMenu(menu, ois, oos);
					
				} while(menu != 5);
				
				
			} catch (IOException e) {
				System.out.println("[클라이언트 연결이 끊어졌습니다.]");
			}
			
			
		});
		t.start();
		
	}

	private synchronized void runMenu(int menu, ObjectInputStream ois, ObjectOutputStream oos) {
		
		switch(menu) {
		case 1:
			insert(ois, oos);
			break;
		case 2:
			update();
			break;
		case 3:
			delete();
			break;
		case 4:
			search();
			break;
		default:
		}
		
	}

	private void insert(ObjectInputStream ois, ObjectOutputStream oos) {

		try {
			//클라이언트가 학생 정보를 보내줌
			Student std = (Student) ois.readObject();
			boolean res = true;
			
			//중복 확인 후 등록된 정보인 경우 클라이언트에게 false 전송
			if(list.contains(std)) {
				res = false;
			}
			
			//등록되지 않은 정보인 경우 리스트에 추가
			else {
				list.add(std);
			}
			
			oos.writeBoolean(res);
			oos.flush();
			
			System.out.println(list);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	private void update() {
		
		
		
	}

	private void delete() {
		
		
		
	}

	private void search() {
		
		
		
	}
}
