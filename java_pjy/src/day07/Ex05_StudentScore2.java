package day07;

import java.util.Scanner;

public class Ex05_StudentScore2 {

	public static void main(String[] args) {
		/*
		 * 학생의 성적을 관리하는 프로그램을 만들기 위해 필요한 Student 클래스를 작성.
		 * 
		 * 메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 1
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 이름 : 홍길동
		 * 과목 : 국어
		 * 성적 : 100
		 *  메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 2
		 * 1학년 1반 1번 홍길동 국어 : 100
		 *  메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 3
		 * 수정할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 국어 
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 95
		 * 성적이 수정되었습니다.
		 *  메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 3
		 * 수정할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 영어
		 * 수정할 학생 정보를 입력하세요.
		 * 성적 : 90
		 * 과목이 없거나 학생 정보가 없습니다.
		 *  메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 4
		 * 삭제할 학생 정보를 입력하세요.
		 * 학년 : 1
		 * 반 : 1
		 * 번호 : 1
		 * 과목 : 국어
		 * 학생 성적을 삭제했습니다.
		 *  메뉴
		 * 1. 학생 성적 추가
		 * 2. 학생 성적 조회
		 * 3. 학생 성적 수정
		 * 4. 학생 성적 삭제
		 * 5. 프로그램 종료
		 * 메뉴 선택: 5
		 * 프로그램을 종료합니다.
		 */
		
		//메뉴를 4를 입력하기 전까지 반복해서 출력하는 코드를 작성.
		Scanner sc = new Scanner(System.in);
		
		int menu, count = 0;
		
		// 학생 성적을 관리하기 위한 10개짜리 배열을 선언하고 생성.
		Student[] list = new Student[10];
		
		//0번지에 1학년 1반 1번 홍길동 국어 100을 가지는 객체를 저장
		list[count] = new Student(1, 1, 1, "홍길동", "국어", 100);
		count++;
		
		do {
			System.out.print("메뉴 \r\n"
					+ "1. 학생 성적 추가\r\n"
					+ "2. 학생 성적 조회\r\n"
					+ "3. 학생 성적 수정\r\n"
					+ "4. 학생 성적 삭제\r\n"
					+ "5. 프로그램 종료\r\n"
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
				Student tmp = new Student(grade, ban, num, name, subject, score);
				
				//grade, ban, num, subject가 일치하는 정보가 list에 있는지 확인
				
				if(indexOf(list, grade, ban, num, subject, count) >= 0) {
					System.out.println("이미 등록된 학생입니다.");
					
				} else {
					list[count] = tmp;
//					list[count].print();  //확인용
					count++;
					System.out.println("학생 성적을 추가했습니다.");
				}
				System.out.println();
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
				
				/*
				 * 0번지부터 count-1번지까지 list에서 하나씩 꺼내서 list에 정보와 위에서 입력받은 학년, 반, 번호, 과목 정보가 같으면 index에 해당 번지를 저장하고 break로 빠져나옴.
				 */
				int index = indexOf(list, grade, ban, num, subject, count);
				
				//index 번지에 있는 학생의 성적을 입력받은 새 성적으로 수정
				if(index >= 0) {
					list[index].setScore(score);
					System.out.println("학생 정보를 수정했습니다.");
//					list[index].print(); //확인용
				} else {
					System.out.println("과목이 없거나 학생 정보가 없습니다.");
				}
				System.out.println();
				break;
			case 4:
				System.out.println("삭제할 학생 정보를 입력하세요.");
				System.out.print("학년 : ");
				grade = sc.nextInt();
				System.out.print("반 : ");
				ban = sc.nextInt();
				System.out.print("번호 : ");
				num = sc.nextInt();
				System.out.print("과목 : ");
				subject = sc.next();
				
				//학생 정보 입력 받아 일치하는 정보가 list에 있는지 확인
				index = indexOf(list, grade, ban, num, subject, count);
				//있는 경우 정보 삭제
				if(index >= 0) {
//					System.out.println("학생 정보를 삭제했습니다.");
//					for(int i = index; i < count-1; i++) {
//						list[i] = list[i+1];
//					}
//					count--;
					if(index != count -1) {
						Student [] arr = new Student[list.length];
						//System.arraycopy(a, b, c, d, e)
						//a: 원본배열, b: 원본 배열의 복사 시작 지점, c: 복사할 배열, d: 복사할 배열의 시작 지점, e: 복사할 요소의 개수
						System.arraycopy(list, 0, arr, 0, count); //현재 있는 데이터를 그대로 복사
						System.arraycopy(list, index+1, arr, index, count - index - 1);
						list = arr;
					}
					count--;
				} else {
					System.out.println("과목이 없거나 학생 정보가 없습니다.");
				}
				System.out.println();
				break;
			case 5:
				System.out.println("프로그램을 종료합니다.");
				break;
			default:
				System.out.println("올바른 메뉴가 아닙니다.\r\n");
			}
		} while(menu != 5);

	}
	
	public static int indexOf(Student [] list, int grade, int ban, int num, String subject, int count) {
		
		for(int i = 0; i < count; i++) {
			if(list[i].equal(grade, ban, num, subject)) {
				return i;
			}
		}
		
		return -1;
	}

}