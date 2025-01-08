package day07;

import java.util.Scanner;

public class Ex04_StudentScore1 {

	public static void main(String[] args) {
		/*
		 * 학생의 성적을 관리하는 프로그램을 만들기 위해 필요한 Student 클래스를 작성.
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택: 1
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 이름 : 홍길동
		 * 과목 : 국어
		 * 성적 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택: 2
		 * 1학년 1반 1번 홍길동 국어 : 100
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택: 3
		 * 수정할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 국어 
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 95
		 * 성적이 수정되었습니다.
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택: 3
		 * 수정할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 영어
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 90
		 * 과목이 없거나 학생 정보가 없습니다.
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 프로그램 종료
		 * 메뉴 선택: 4
		 * 프로그램을 종료합니다.
		 */
		
		//메뉴를 4를 입력하기 전까지 반복해서 출력하는 코드를 작성.
		Scanner sc = new Scanner(System.in);
		
		int menu, count = 0;
		
		// 학생 성적을 관리하기 위한 10개짜리 배열을 선언하고 생성.
		Student [] list = new Student[10];
		
		//0번지에 1학년 1반 1번 홍길동 국어 100을 가지는 객체를 저장
		list[count] = new Student(1, 1, 1, "홍길동", "국어", 100);
		count++;
		
		do {
			System.out.print("메뉴 \r\n"
					+ "1. 학생 성적 추가\r\n"
					+ "2. 학생 성적 조회\r\n"
					+ "3. 학생 성적 수정\r\n"
					+ "4. 프로그램 종료\r\n"
					+ "메뉴 선택: ");
			menu = sc.nextInt();
			
			switch(menu) {
			case 1:
				System.out.print("학년 : ");
				int grade = sc.nextInt();
				System.out.print("반 : ");
				int ban = sc.nextInt();
				System.out.print("번호 : ");
				int num = sc.nextInt();
				System.out.print("이름 : ");
				String name = sc.next(); //이름에 띄어쓰기 허용할 시 nextLine()
				System.out.print("과목 : ");
				String subject = sc.next();
				System.out.print("성적 : ");
				int score = sc.nextInt();
				System.out.println();
				Student tmp = new Student(grade, ban, num, name, subject, score);
				list[count] = tmp;
//				list[count].print();  //확인용
				count++;
				break;
			case 2:
				/*
				 * 0번지부터 count-1번지까지 1씩 증가하면서 list에 있는 학생 정보를 출력하는 코드 작성
				 */
				for(int i = 0; i < count; i++) {
					list[i].print();
				}
				System.out.println();
				break;
			case 3:
				System.out.println("수정할 학생 정보를 입력하세요.");
				System.out.print("학년 : ");
				grade = sc.nextInt();
				System.out.print("반 : ");
				ban = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				System.out.print("과목 : ");
				subject = sc.next();
				System.out.println("수정할 성적을 입력하세요.");
				System.out.print("성적 : ");
				score = sc.nextInt();
				
				int index = -1;
				/*
				 * 0번지부터 count-1번지까지 list에서 하나씩 꺼내서 list에 정보와 위에서 입력받은 학년, 반, 번호, 과목 정보가 같으면 index에 해당 번지를 저장하고 break로 빠져나옴.
				 */
				for(int i = 0; i < count; i++) {
					if(list[i].equal(grade, ban, num, subject)) {
						index = i;
						break;
					}
				}
				//index 번지에 있는 학생의 성적을 입력받은 새 성적으로 수정
				if(index >= 0) {
					list[index].setScore(score);
					System.out.println("학생 정보를 수정했습니다.");
//					list[index].print(); //확인용
				} else {
					System.out.println("과목이 없거나 학생 정보가 없습니다.");
				}
				break;
			case 4:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바른 메뉴가 아닙니다.\r\n");
			}
		} while(menu != 4);

	}

}

class Student {
	private int grade, ban, num;
	private String name;
	private String subject;
	private int score;
	

	public Student(int grade, int ban, int num, String name, String subject, int score) {
		this.grade = grade;
		this.ban = ban;
		this.num = num;
		this.name = name;
		this.subject = subject;
		this.score = score;
	}

	/*
	 * 주어진 학년, 반, 번호, 과목이 내 정보와 일치하는지를 알려주는 메소드
	 * 매개변수: 학년 반 번호 과목 => int grade, int ban, int num, String subject
	 * 리턴타입: 일치하는지 않는지 => boolean
	 * 메소드명: equal
	 */
	public boolean equal(int grade, int ban, int num, String subject) {
		if(this.grade != grade) {
			return false;
		}
		if(this.ban != ban) {
			return false;
		}
		if(this.num != num) {
			return false;
		}
		if(!this.subject.equals(subject)) {
			return false;
		}
		return true;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void print() {
		System.out.println(grade + "학년 " + ban + "반 " + num + "번 " + name + " " + subject + " : " + score);
	}
}
