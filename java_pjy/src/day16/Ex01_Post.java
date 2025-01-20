package day16;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import lombok.Data;

public class Ex01_Post {
	static Scanner sc = new Scanner(System.in);
	static List<Post> list = new ArrayList<Post>();
	
	public static void main(String[] args) {
		/* 게시글 프로그램을 위한 클래스를 선언
		 * 게시글 등록
		 * - 제목, 내용, 작성자를 입력
		 * 게시글 수정
		 * - 게시글 번호 선택
		 * - 제목, 내용 수정
		 * 게시글 삭제
		 * - 게시글 번호 선택하여 삭제
		 * 게시글 조회
		 * - 게시글 번호를 이용하여 조회하고 조회수 1증가
		 */
		
		int menu;
		final int EXIT = 5;
		
		String fileName = "src/day16/post.txt";
		
		list = (ArrayList<Post>) load(fileName);
		
		do {
			
			printMenu();
			menu = sc.nextInt();
			removeBuffer();
			
			runMenu(menu);
			
			
		} while(menu != EXIT);
		
		save(fileName, list);
		
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
	private static ArrayList<Post> load(String fileName) {
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
		} catch (Exception e) {
			System.out.println("-------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------");
		}
		
		return null;
	}
	private static void printMenu() {
		System.out.println("-------------");
		System.out.println(" 메뉴");
		System.out.println("1. 게시글 등록");
		System.out.println("2. 게시글 수정");
		System.out.println("3. 게시글 삭제");
		System.out.println("4. 게시글 조회");
		System.out.println("5. 종료");
		System.out.println("-------------");
		System.out.print("메뉴 선택 : ");
		
	}
	private static void runMenu(int menu) {
		switch (menu) {
		case 1:
			writePost();
			break;
		case 2:
			updatePost();
			break;
		case 3:
			deletePost();
			break;
		case 4:
			searchPost();
			break;
		case 5:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}
	private static void writePost() {
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		System.out.print("작성자 : ");
		String writer = sc.nextLine();
		Post post = new Post(title, content, writer);
		
		list.add(post);
		for(Post post1 : list) { //확인용
			post1.print();
		}
		
	}
	
	private static void updatePost() {
		System.out.print("수정할 게시글 번호 입력 : ");
		int num = sc.nextInt() - 1;
		
		if(num >= list.size()) {
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		
		removeBuffer();
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		
		list.get(num).updatePost(title, content);
		
		System.out.println("게시글을 수정했습니다.");
		
	}
	
	private static void deletePost() {
		System.out.print("삭제할 게시글 번호 입력 : ");
		int index = sc.nextInt() - 1;
		
		if(index >= list.size()) {
			System.out.println("일치하는 게시글이 없습니다.");
		}
		
		Post tmp = list.get(index);
		list.remove(tmp);
		System.out.println("게시글을 삭제했습니다.");
		
	}
	
	private static void searchPost() {
		System.out.print("조회할 게시글 번호 입력 : ");
		int index = sc.nextInt() - 1;
		
		if(index >= list.size()) {
			System.out.println("일치하는 게시글이 없습니다.");
			return;
		}
		
		list.get(index).searchPost(list, index);
		
	}
	
	private static void removeBuffer() {
		sc.nextLine();
	}

}

@Data
class Post {

	private static int count;
	private int num;
	private String title, content, writer;
	private Date date;
	private int view;
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Post other = (Post) obj;
		return num == other.num;
	}

	public void searchPost(List<Post> list, int index) {
		++view;
		
		list.get(index).print();
		
	}

	public void updatePost(String title, String content) {
		
		if(title == null || content == null) {
			return;
		}
		
		this.title = title;
		this.content = content;
		
	}

	public Post(String title, String content, String writer) {
		num = ++count;
		this.title = title;
		this.content = content;
		this.writer = writer;
		date = new Date();
	}
	
	
	public void print() {
		System.out.println("-------------------------");
		System.out.println("번호 : " + num);
		System.out.println("제목 : " + title);
		System.out.println("내용 : " + content);
		System.out.println("작성자 : " + writer);
		System.out.println("작성일 : " + getDateStr());
		System.out.println("조회수 : " + view);
		System.out.println("-------------------------");
	}

	private String getDateStr() {
		//Date 클래스를 String으로
		//yyyy-MM-dd HH:mm:ss
		
		if(date == null ) {
			return null;
		}
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return format.format(date);
	}

}