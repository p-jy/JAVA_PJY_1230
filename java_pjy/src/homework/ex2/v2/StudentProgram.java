package homework.ex2.v2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;




public class StudentProgram implements ConsoleProgram {
	
	private Scanner sc = new Scanner(System.in);
	
	private StudentManager studentManager = new StudentManager();
	private SubjectManager subjectManager = new SubjectManager();
	
	public void run() {
		
		int menu = 0;
		final int EXIT = 13;
		
		String studentFileName = "src/homework/ex2/v2/student.txt";
		String subjectFileName = "src/homework/ex2/v2/subject.txt";
		
		List<Student> students = (ArrayList<Student>) load(studentFileName);
		List<Subject> subjects = (ArrayList<Subject>) load(subjectFileName);
		
		studentManager = new StudentManager(students);
		subjectManager = new SubjectManager(subjects);
		
		
		
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
		save(studentFileName, studentManager.getList());
		save(subjectFileName, subjectManager.getList());
	}
	
	@Override
	public void printMenu() {
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

	@Override
	public void runMenu(int menu) {
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
	
	private void insertStudent() {
		//학생 정보를 입력받아 객체를 생성
		Student std = inputStudent();
		//생성된 학생 정보를 매니저에게 전달하여 등록 요청 후 성공 여부 반환
		if(!studentManager.insertStudent(std)) {
			System.out.println("이미 등록된 학생입니다.");
			return;
		}
		System.out.println("학생을 등록헸습니다.");
		
		
	}

	private void updateStudent() {
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();

		Student selStd = studentManager.getStudent(std);
		
		if(selStd == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("새 학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student newStd = inputStudent();
		
		if(studentManager.updateStudent(selStd, newStd)) {
			System.out.println("학생을 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 학생입니다.");

	}

	private void deleteStudent() {
		Student std = inputBaseStudent();
		
		if(studentManager.deleteStudent(std)) {
			System.out.println("학생을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 학생이 없습니다.");
		
	}

	private void insertSubject() {
		Subject subject = inputSubject();
		
		if(!subjectManager.insertSubject(subject)) {
			System.out.println("과목을 추가했습니다.");
			return;
		}
		System.out.println("이미 등록된 과목입니다.");
		
	}

	private void updateSubject() {
		
		System.out.println("----------------");
		System.out.println("과목 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("새 과목 정보를 입력하세요.");
		System.out.println("----------------");
		
		Subject newSubject = inputSubject();
		
		if(subjectManager.updateSubject(subject, newSubject)) {
			System.out.println("과목을 수정했습니다.");
			return;
		}
		
		System.out.println("이미 등록된 과목입니다.");
	}

	private void deleteSubject() {
		System.out.println("----------------");
		System.out.println("과목 정보를 입력하세요.");
		System.out.println("----------------");
		
		Subject subject = inputSubject();
		
		if(subjectManager.deleteSubject(subject)) {
			System.out.println("과목을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 과목이 없습니다.");
		
	}

	private void insertScore() {
		
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.print("성적 : ");
		int score = sc.nextInt();
		
		SubjectScore subjectScore = new SubjectScore(subject, score);
		
		if(studentManager.insertScore(std, subjectScore)) {
			System.out.println("성적을 추가했습니다.");
			return;
		}
		
		System.out.println("이미 등록된 성적입니다.");


	}

	private void updateScore() {	
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
	
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
	
		Subject newSubject = inputSubject();
		if(!subjectManager.contains(newSubject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		System.out.print("성적 : ");
		int score = sc.nextInt();
		SubjectScore subjectScore = new SubjectScore(newSubject, score);
		if(studentManager.updateScore(std, subject, subjectScore)) {
			System.out.println("성적을 수정했습니다.");
			return;
		}
		System.out.println("이미 등록된 성적입니다.");
		
	}

	private void deleteScore() {
		System.out.println("----------------");
		System.out.println("학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println("성적 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		if(!subjectManager.contains(subject)) {
			System.out.println("일치하는 과목이 없습니다.");
			return;
		}
		
		if(studentManager.deleteScore(std, subject)) {
			System.out.println("성적을 삭제했습니다.");
			return;
		}
		System.out.println("일치하는 성적이 없습니다.");
	}

	private void searchStudent() {
		Student std = inputBaseStudent();
		
		studentManager.printStudent(std);
		
	}

	private void searchSubject() {
		
		subjectManager.print();
		
		
	}

	private void searchScore() {
		
		System.out.println("----------------");
		System.out.println("조회하려는 학생 정보를 입력하세요.");
		System.out.println("----------------");
		Student std = inputBaseStudent();
		if(studentManager.getStudent(std) == null) {
			System.out.println("일치하는 학생이 없습니다.");
			return;
		}
		System.out.println("----------------");
		System.out.println("조회하려는 과목 정보를 입력하세요.");
		System.out.println("----------------");
		Subject subject = inputSubject();
		
		studentManager.printScore(std, subject);
	}
	
	private void removeBuffer() {
		sc.nextLine();
	}
	
	/** 학년, 반, 번호를 입력하면 객체를 반환하는 메소드 */
	public Student inputBaseStudent() {
		System.out.print("학년 : ");
		int grade = sc.nextInt();
		System.out.print("학급 : ");
		int classNum = sc.nextInt();
		System.out.print("번호 : ");
		int num = sc.nextInt();
		
		return new Student(grade, classNum, num, "");
	}
	
	/** 학년, 반, 번호, 이름을 입력하면 객체를 반환하는 메소드 */
	public Student inputStudent() {
		Student tmp = inputBaseStudent();
		
		removeBuffer();
		
		System.out.print("이름 : ");
		String name = sc.nextLine();
		
		tmp.setName(name);
		
		return tmp;
	}
	
	/** 학년, 학기, 과목명을 입력하여 과목 객체를 생성하는 메소드 */
	public Subject inputSubject() {
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
