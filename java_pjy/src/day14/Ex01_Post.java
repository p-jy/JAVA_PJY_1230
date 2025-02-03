package day14;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
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
		
		String fileName = "src/day14/post.txt";
		
		list = (ArrayList<Post>)load(fileName);
		
		if(list == null || list.size() == 0) {
			list = new ArrayList<Post>();
		} else {
			int lastIndex = list.size() - 1;
			Post lastPost = list.get(lastIndex);
			int lastNum = lastPost.getNum();
			Post.setCount(lastNum + 1);
		}
		
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
			viewPost();
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
		
	}
	
	private static void updatePost() {
		System.out.print("수정할 게시글 번호 입력 : ");
		int num = sc.nextInt();
		removeBuffer();
		
		//indexOf => Objects.equals(o1, o2) => o1과 o2가 다른 클래스이면 무조건 false
		int index = list.indexOf(new Post(num)); 
		
		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		
		System.out.print("제목 : ");
		String title = sc.nextLine();
		System.out.print("내용 : ");
		String content = sc.nextLine();
		
		Post post = list.get(index);
		
		post.setTitle(title);
		post.setContent(content);
		
		System.out.println("게시글을 수정했습니다.");
		
	}
	
	private static void deletePost() {
		System.out.print("삭제할 게시글 번호 입력 : ");
		int num = sc.nextInt();
		
		
		if(list.remove(new Post(num))) {
			System.out.println("게시글을 삭제했습니다.");
			return;
		}
		
		System.out.println("등록되지 않거나 삭제된 게시글입니다.");
		
		
	}
	
	private static void viewPost() {
		System.out.print("조회할 게시글 번호 입력 : ");
		int num = sc.nextInt();
		
		int index = list.indexOf(new Post(num));
		
		if(index < 0) {
			System.out.println("등록되지 않거나 삭제된 게시글입니다.");
			return;
		}
		
		Post post = list.get(index);
		post.viewPost();
		post.print();
		
	}
	
	private static void removeBuffer() {
		sc.nextLine();
	}

}

@Data
class Post implements Serializable{
	
	private static final long serialVersionUID = 3213525506836040206L;
	
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

	public static void setCount(int count) {
		Post.count = count;
		
	}

	public void viewPost() {
		view++;
		
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
	
	
	public Post(int num) {
		this.num = num;
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