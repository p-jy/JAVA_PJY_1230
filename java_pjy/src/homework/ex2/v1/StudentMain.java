package homework.ex2.v1;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMain {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Student> studentList = new ArrayList<Student>();
	static ArrayList<Subject> subjectList = new ArrayList<Subject>();
	
	/* 학생 성적 관리 프로그램을 작성하세요
	 * 1. 학생 등록
	 * 	- 학년, 반, 번호, 이름을 입력받아 등록
	 * 	- 이미 등록된 학생 정보(학년, 반, 번호가 같은 경우) => 등록X
	 * 2. 학생 수정
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는지 찾고, 있으면 수정
	 * 	- 수정하는 정보: 학년, 반, 번호, 이름을 수정
	 * 	- 이미 등록된 학생 정보로 수정하려고 하면 수정X
	 * 3. 학생 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생이 있는 지 찾고 있으면 삭제
	 * 4. 과목 등록
	 * 	- 학년, 학기, 과목명을 입력받아 없으면 등록
	 * 5. 과목 수정
	 * 	- 학년, 학기, 과목명을 입력받아 있으면 학년, 학기, 과목명을 입력받아 수정
	 * 	- 수정하려는 과목이 이미 등록된 과목이라면 수정하지 않음
	 * 6. 과목 삭제
	 * 	- 학년, 학기, 과목을 입력받아 있으면 삭제
	 * 7. 성적 등록
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 학생O > 과목을 출력 (1학년 1학기 국어 <과목은 이렇게 출력됨)
	 * 	- 과목을 선택
	 * 	- 성적을 입력해서 학생 성적을 등록
	 * 8. 성적 수정
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 학생O > 학년, 학기, 과목명을 입력받고 있으면 성적을 입력받아 수정
	 * 9. 성적 삭제
	 * 	- 학년, 반, 번호를 입력받아 학생을 찾음
	 * 	- 학생O > 학년, 학기, 과목명을 입력받고 있으면 삭제
	 * 10. 학생 조회
	 * 	- 학년, 반을 입력하면 학생들을 조회
	 * 11. 과목 조회
	 * 	- 등록된 과목 전체를 조회
	 * 12. 성적 조회
	 * 	- 학년, 반, 번호를 입력 > 학생O > 학생 성적을 조회
	 */

	public static void main(String[] args) {
		final int EXIT = 13;
		int menu = 0;
		
		String stdFileName = "src/homework/ex2/v1/student.txt";
		String subjectFileName = "src/homework/ex2/v1/subject.txt";
		//불러오기
		studentList = (ArrayList<Student>) load(stdFileName);
		if(studentList == null) {
			studentList = new ArrayList<Student>();
		}
		
		subjectList = (ArrayList<Subject>) load(subjectFileName);
		if(subjectList == null) {
			subjectList = new ArrayList<Subject>();
		}
		
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				
				removeBuffer();
				
				runMenu(menu);
			} catch(InputMismatchException e) {
				//정수가 아닌 것을 메뉴로 입력한 경우 예외처리
				System.out.println("올바른 입력이 아닙니다.");
				removeBuffer();
			} 
			
			
		} while(menu != EXIT);
		
		//저장하기
		save(stdFileName, studentList);
		save(subjectFileName, subjectList);
		
	}
	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
				
			oos.writeObject(obj);
				
		} catch (Exception e) {
			System.out.println("----------------");
			System.out.println("저장하기 실패");
			System.out.println("----------------");
		}
		
	}

	private static Object load(String fileName) {
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
					
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("----------------");
			System.out.println("불러오기 실패.");
			System.out.println("----------------");
		}
		return null;
	}

	//입력 버퍼에 남아 있는 엔터를 제거하는 메소드
	private static void removeBuffer() {
		sc.nextLine();
	}

	public static void printMenu() {
		System.out.print("----------------\r\n"
					+ "메뉴\r\n"
					+ " 1. 학생 등록\r\n"
					+ " 2. 학생 수정\r\n"
					+ " 3. 학생 삭제\r\n"
					+ " 4. 과목 등록\r\n"
					+ " 5. 과목 수정\r\n"
					+ " 6. 과목 삭제\r\n"
					+ " 7. 성적 등록\r\n"
					+ " 8. 성적 수정\r\n"
					+ " 9. 성적 삭제\r\n"
					+ "10. 학생 조회\r\n"
					+ "11. 과목 조회\r\n"
					+ "12. 성적 조회\r\n"
					+ "13. 종료\r\n"
					+ "----------------\r\n"
					+ "메뉴 입력 : ");
		
	}
	
	public static void runMenu(int menu) {
		switch(menu) {
		case 1:
			insertStudent();
			break;
		case 2:
			updateStudent();
			break;
		case 3:
			deleteStudent();
			break;
		case 4:
			insertSubject();
			break;
		case 5:
			updateSubject();
			break;
		case 6:
			deleteSubject();
			break;
		case 7:
			insertScore();
			break;
		case 8:
			updateScore();
			break;
		case 9:
			deleteScore();
			break;
		case 10:
			searchStudent();
			break;
		case 11:
			searchSubject();
			break;
		case 12:
			searchScore();
			break;
		case 13:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
	}

	private static void insertStudent() {
		//학년, 반, 번호, 이름 입력
		Student std = inputStudent();
		//입력 받은 학년, 반, 번호, 이름을 이용하여 객체 생성 => 리스트에 있는 기능을 활용하기 위해
		
		//생성한 객체가 리스트에 있는지 확인하여 있으면 종료 => Student 클래스의 equals를 오버라이딩
		//리스트.indexOf(객체2) => Objects.equals(객체1, 객체2) => 객체1.equals(객체2)
		if(studentList.contains(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
			
		//없으면 리스트에 추가 후 안내 문구
		studentList.add(std);
		System.out.println("학생을 등록헸습니다.");
//		System.out.println(studentList); //확인용
		
	}

	private static void updateStudent() {
		//학년, 반, 번호 입력
		//입력한 학생 정보를 객체 생성
		Student std = inputBaseStudent();
		//생성한 객체가 리스트에 있으면 번지를 가져옴
		int index = studentList.indexOf(std);
		//번지가 음수이면(없으면) 안내문구 출력 후 종료
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("수정할 학생 정보를 입력하세요.");
		System.out.println("----------------");
		//아니면(있으면) 수정할 학년, 반, 번호, 이름을 입력
		//입력받은 정보로 객체를 생성
		Student newStd = inputStudent();
		
		//새 학생 정보가 등록된 학생 정보인지 확인해서 맞으면 알림 후 종료
		std = studentList.remove(index);
		if(studentList.contains(newStd)) {
			System.out.println("이미 등록된 학생입니다.");
			studentList.add(index, std);
			return;
		}
		studentList.add(index, std);
		
		//번지에 있는 객체를 위에서 생성한 객체로 변경
		studentList.get(index).update(newStd);
		System.out.println("학생을 수정했습니다.");
		
		
	}

	private static void deleteStudent() {
		//학년, 반, 번호를 입력
		//입력받은 정보로 객체 생성
		Student std = inputBaseStudent();
		//생성한 객체를 이용하여 리스트에서 삭제
		//삭제에 성공하면 성공알림 문구
		if(studentList.remove(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림문구 출력
		System.out.println("일치하는 학생이 없습니다.");
		
		
	}

	private static void insertSubject() {
		//학년, 학기, 과목명을 입력
		Subject subject = inputSubject();
		//이미 등록된 과목이면 알림 후 종료 => Subject 클래스의 equals를 오버라이딩
		if(subjectList.contains(subject)) {
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		//과목을 추가 후 알림.
		subjectList.add(subject);
		System.out.println("과목을 등록했습니다.");
		System.out.println(subjectList); //확인용
		
		
	}

	private static void updateSubject() {
		//학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성
		Subject subject = inputSubject();
		//등록된 과목이 아니면 알림 후 종료 <= indexOf로 번지를 가져와서 사용.
		int index = subjectList.indexOf(subject);
		if(index < 0) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("수정할 과목을 입력하세요.");
		System.out.println("----------------");
		//새 과목 정보를 입력(학년, 학기, 과목)
		Subject newSubject = inputSubject();
		
		//등록된 과목이면 알림 후 종료
		if(subjectList.contains(newSubject)) {
			System.out.println("이미 등록된 과목입니다.");
			return;
		}
		//아니면 수정
			//새 객체를 추가
		subjectList.set(index, newSubject);
		System.out.println("과목을 수정했습니다.");
		
		
	}

	private static void deleteSubject() {
		System.out.println("----------------");
		System.out.println("과목 정보를 입력하세요.");
		System.out.println("----------------");
		// 학년, 학기, 과목명을 입력
		//입력한 정보로 객체를 생성	
		Subject subject = inputSubject();
		//리스트에서 생성한 객체를 제거해서 성공하면 성공 알림
		if(subjectList.remove(subject)) {
			System.out.println("과목을 삭제했습니다.");
		}
		//실패하면 실패 알림
		System.out.println("일치하는 과목이 없습니다.");
	}

	private static void insertScore() {
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		int index = studentList.indexOf(std);
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인 지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//성적을 입력해서 과목 정보와 성적을 이용하여 객체를 생성(Score)
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(subject, score);
		//학생을 선택하여 객체 저장 list.get(XX).update() => tmp.update()
		if(studentList.get(index).insertScore(subjectScore)) {
			System.out.println("성적을 추가했습니다.");
			return;
		}
		
		System.out.println("이미 등록된 성적입니다.");
		
	}

	private static void updateScore() {
		
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		int index = studentList.indexOf(std);
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인 지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		//새 과목 정보를 입력(학년, 학기, 과목)을 입력
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		
		Subject newSubject = inputSubject();
		//과목 리스트에 등록된 과목인지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(newSubject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		//성적을 입력
		System.out.print("성적 : ");
		int score = sc.nextInt();
		//새 과목 정보와 성적을 이용하여 성적 객체를 생성
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		//학생에서 기존 과목 정보와 성적 정보를 주면서 수정하라고 요청한 후 성공하면 알림
		if(studentList.get(index).updateScore(subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		//실패하면 알림
		System.out.println("이미 등록된 성적입니다.");
		
	}

	private static void deleteScore() {
		
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		//리스트에 있는지 확인해서 없으면 알림 후 종료 => indexOf
		int index = studentList.indexOf(std);
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//학년, 학기, 과목을 입력
		//입력한 정보로 객체를 생성(Subject)
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		//과목리스트에 등록된 과목인 지 확인 후 아니면 알림 후 종료
		if(!subjectList.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		//학생에서 과목 정보를 주면서 성적을 삭제하라고 요청하고 성공하면 성공 알림
		if(studentList.get(index).deleteScore(subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		//실패하면 실패 알림
		System.out.println("일치하는 성적이 없습니다.");
		
	}

	private static void searchStudent() {
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		Student std = inputBaseStudent();
		//리스트에서 일치하는 학생이 있으면 정보를 출력
		int index = studentList.indexOf(std);
		if(index >= 0) {
			studentList.get(index).print();
			return;
		}
		//없으면 없다고 알림
		System.out.println("일치하는 학생이 없습니다.");
	}

	private static void searchSubject() {
		//등록된 과목 전체 출력
		if(subjectList.size() == 0) {
			System.out.println("등록된 과목이 없습니다.");
			return;
		}
		
		for(Subject subject : subjectList) {
			System.out.println(subject);
		}
		
		
	}

	private static void searchScore() {
		System.out.println("----------------");
		System.out.println("조회하려는 학생 정보를 입력하세요.");
		System.out.println("----------------");
		//학년, 반, 번호를 입력
		//입력한 정보로 객체를 생성(Student)
		Student std = inputBaseStudent();
		//리스트에 학생이 없으면 알림 후 종료
		int index = studentList.indexOf(std);
		if(index < 0) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		//학년, 학기, 과목명을 입력
		System.out.println("----------------");
		System.out.println("조회하려는 과목 정보를 입력하세요.");
		System.out.println("----------------");
		//과목 정보로 객체를 생성
		Subject subject = inputSubject();
		//리스트에서 학생을 선택
		Student selectStd = studentList.get(index);
		//선택한 학생에게 과목정보를 주면서 성적을 출력하라고 요청
		selectStd.printScore(subject);
	}
	
	/** 학년, 반, 번호를 입력하면 객체를 반환하는 메소드 */
	public static Student inputBaseStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("학급 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		return new Student(grade, classNum, num, "");
	}
	
	/** 학년, 반, 번호, 이름을 입력하면 객체를 반환하는 메소드 */
	public static Student inputStudent() {
		Student tmp = inputBaseStudent();
		
		removeBuffer();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		tmp.setName(name);
		
		return tmp;
	}
	
	/** 학년, 학기, 과목명을 입력하여 과목 객체를 생성하는 메소드 */
	public static Subject inputSubject() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("학기 : ");
		int semester = sc.nextInt();
		removeBuffer();
		System.out.print("과목 : ");
		String name = sc.nextLine();
		
		return new Subject(grade, semester, name);
	}
	
}
