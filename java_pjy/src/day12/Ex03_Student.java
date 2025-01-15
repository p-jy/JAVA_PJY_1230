package day12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex03_Student {
	/* 다음 기능을 갖는 프로그램을 작성하세요
	 * 1. 학생 추가
	 * 	- 학년, 반, 번호, 이름 입력
	 * 2. 학생 삭제
	 * 	- 이름을 입력받아 학생들을 출력하고, 그 중 선택된 학생을 삭제
	 * 3. 학생 조회
	 * 4. 종료
	 * 
	 * 3-1. 학년 조회: 학년
	 * 3-2. 반 조회: 학년, 반
	 * 3-3. 번호 조회: 학년, 반, 번호
	 * 3-4. 전체 조회: X
	 * 
	 * - 학생 클래스 추가
	 * - List를 이용해서 학생들을 관리
	 * - Stream과 람다식을 이용해서 출력을 구현
	 */
	
	static Scanner sc = new Scanner(System.in);
	static List<Student> std = new ArrayList<Student>();
	
	public static void main(String[] args) {
		
		std.add(new Student(1, 1, 1, "홍길동"));
		std.add(new Student(1, 1, 2, "임꺽정"));
		std.add(new Student(2, 1, 1, "둘리"));
		std.add(new Student(3, 1, 1, "고길동"));
		std.add(new Student(3, 2, 1, "또치"));
		
		
		int menu;
		
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
		} while(menu != 4);
		
	}

	private static void printMenu() {
		System.out.println("1. 학생 등록");
		System.out.println("2. 학생 삭제");
		System.out.println("3. 학생 조회");
		System.out.println("4. 종료");
		System.out.print("메뉴 입력 : ");
		
	}

	private static void runMenu(int menu) {
		
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			deleteStudent();
			break;
		case 3:
			searchStudent();
			break;
		case 4:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	
	private static void insertStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		System.out.print("이름 : ");
		String name = sc.next();
		
		Student student = new Student(grade, classNum, num, name);
		std.add(student);
		
		System.out.println("---------------");
		System.out.println("학생을 등록했습니다.");
		System.out.println("---------------");
	}

	private static void deleteStudent() {

		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		List<Student> tmpList =
				std
				.stream()
				.filter(s -> s.getName().contains(name))
				.collect(Collectors.toList());
		print(tmpList, s-> true, true);
		System.out.println("---------------");
		
		
		System.out.print("삭제할 학생 선택 : ");
		int count = sc.nextInt();
		
		Student tmp = tmpList.get(count-1);
		
		std.remove(tmp);
		System.out.println("---------------");
		System.out.println("학생이 삭제됐습니다.");
		System.out.println("---------------");
		
	}
	
	private static void searchStudent() {
		System.out.println("---------------");
		System.out.println("1. 학년 조회");
		System.out.println("2. 반 조회");
		System.out.println("3. 번호 조회");
		System.out.println("4. 전체 조회");
		System.out.print("조회 방식 선택: ");
		int search = sc.nextInt();
		
		runSearch(search);
		
	}
	
	

	private static void runSearch(int search) {
		switch(search) {
		case 1:
			searchGrade();
			break;
		case 2:
			searchClassNum();
			break;
		case 3:
			searchNum();
			break;
		case 4:
			searchAll();
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
			System.out.println("---------------");
		}
	}


	private static void searchGrade() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		
		
		System.out.println("---------------");
		print(std, s-> s.getGrade() == grade);
		System.out.println("---------------");
		
	}
	
	private static void searchClassNum() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		
		System.out.println("---------------");
		print(std, s-> s.getGrade() == grade && s.getClassNum() == classNum);
		System.out.println("---------------");
		
	}
	
	private static void searchNum() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("반 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		System.out.println("---------------");
		print(std, s-> s.getGrade() == grade && s.getClassNum() == classNum && s.getNum() == num);
		System.out.println("---------------");
	}
	
	private static void searchAll() {
		print(std, s-> true);
	}
	
	private static void print(List<Student> list, Predicate<Student> p) {
		print(std, p, false);
	}
	
	private static void print(List<Student> list, Predicate<Student> p, boolean isCount) {
		Stream<Student> stream = std.stream();
		AtomicInteger index = new AtomicInteger(1);
		stream
			.filter(p)
			.forEach(s->{
				int num = index.getAndIncrement();
				System.out.println((isCount? num + ". " : "") + s);
			});
	}
	
	

}

@Data
@AllArgsConstructor
class Student {
	private int grade, classNum, num;
	private String name;
	@Override
	public String toString() {
		return grade + "학년 " + classNum + "반 " + num + "번 " + name;
	}
	
	
}