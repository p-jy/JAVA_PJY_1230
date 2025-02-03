package day16;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.Data;

@Data
public class Post implements Serializable, Cloneable {
	
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
	
	public static int getCount() {
		return count;
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

	public Post(Post p) {
		
		this(p.title, p.content, p.writer);
		
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
	
	@Override
	public String toString() {
		return num + " | " + title + " | " + writer + " | " + getDateStr() + " | " + view;
	}
	
	@Override
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

}