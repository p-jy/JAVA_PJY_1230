package homework.ex2;

import java.text.MessageFormat;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StudentMain {
	static Scanner sc = new Scanner(System.in);
	
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
		
		Student [] stdList;
		Subject [] subjectList;
		int stdCount = 0;
		int subjectCount = 0;
		
		Student tmp = new Student();
		
//		System.out.println(tmp);
		
		int menu = 0;
		do {
			printMenu();
			try {
				menu = sc.nextInt();
				runMenu(menu);
			} catch(InputMismatchException e) {
				//정수가 아닌 것을 메뉴로 입력한 경우 예외처리
				System.out.println("메뉴의 번호를 입력해주세요.\r\n");
				sc.nextLine();
			} catch (Exception e) {
				//메뉴 번호 잘못 입력한 경우 예외처리
				System.out.println(MessageFormat.format("{0}", e.getMessage())); 
			}
			
			
		} while(menu != 13);
		
		
	}
	
	public static void printMenu() {
		System.out.print("메뉴\r\n"
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
					+ "메뉴 입력 : ");
		
	}
	
	public static void runMenu(int menu) throws Exception {
		switch(menu) {
		case 1:
			
			break;
		case 2:
			
			break;
		case 3:
			
			break;
		case 4:
			
			break;
		case 5:
			
			break;
		case 6:
			
			break;
		case 7:
			
			break;
		case 8:
			
			break;
		case 9:
			
			break;
		case 10:
			
			break;
		case 11:
			
			break;
		case 12:
			
			break;
		case 13:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			throw new Exception("올바른 메뉴가 아닙니다.\r\n");
		}
	}
	
}
