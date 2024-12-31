package day02;

//import java.util.Scanner;

public class Ex13_SwitchSeason {

	public static void main(String[] args) {
		/*
		 * 월이 주어졌을 때 월에 맞는 계절을 출력하세요.
		 * 봄: 3, 4, 5
		 * 여름: 6, 7, 8
		 * 가을: 9, 10, 11
		 * 겨울: 12, 1, 2
		 * 그외: 잘못된 월
		 */
		
	
		//Scanner sc = new Scanner(System.in);
		
		int month = 3;
		
		//System.out.print("월을 입력해주세요.: "); //월 입력받는 경우
		//int month = sc.nextInt();
		
		switch(month) {
		case 3, 4, 5: //case 3: case4: case 5: <이렇게 입력하는 게 정석 / 현재 입력한 방식은 jdk 버전이 낮은 경우 불가능
			System.out.println(month + "월은 봄입니다.");
			break;
		case 6, 7, 8:
			System.out.println(month + "월은 여름입니다.");
			break;
		case 9, 10, 11:
			System.out.println(month + "월은 가을입니다.");
			break;
		case 12, 1, 2:
			System.out.println(month + "월은 겨울입니다.");
			break;
		default:
			System.out.println("잘못된 월입니다.");
		}

	}

}
