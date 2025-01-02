package day03;

import java.util.Scanner;

public class Ex02_Test2 {

	public static void main(String[] args) {
		/* 
		 * 월을 입력받고 월의 마지막 일을 출력하는 코드를 작성하세요.
		 * 31: 1 3 5 7 8 10 12
		 * 30: 4 6 9 11
		 * 28: 2 
		 * 잘못된 월입니다. : 1~12가 아닌 경우
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("월을 입력해주세요 : ");
		int month = sc.nextInt();
		
		switch(month) {
		case 1, 3, 5, 7, 8, 10, 12:
			System.out.println(month + "월은 31일까지 있습니다.");
			break;
		case 4, 6, 9, 11 :
			System.out.println(month + "월은 30일까지 있습니다.");
			break;
		case 2:
			System.out.println(month + "월은 28일까지 있습니다.");
			break;
		default:
			System.out.println(month + "월은 잘못된 월입니다.");
		}
		
		//교수님 코드
		/* 
		 * int lastDay = 0; //print를 여러번 입력하지 않도록 변수 추가
		 * switch(month) {
		 * 	case 1, 3, 5, 7, 8, 10, 12:
		 * 		lastDay = 31;
		 * 		break;
		 * 	case 4, 6, 9, 11:
		 * 		lastDay = 30;
		 * 		break;
		 * 	case 2:
		 * 		lastDay = 28;
		 * }
		 * 
		 * if(lastDay == 0) {
		 * 	System.out.println(month + "월은 잘못된 월입니다.");
		 * } else {
		 * 	System.out.println(month + "월은 " + lastDay + "일까지 있습니다.");
		 * }
		 */
	}

}
