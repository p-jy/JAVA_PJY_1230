package day02;

import java.util.Scanner;

public class Ex15_SwitchGrade {

	public static void main(String[] args) {
		/* 
		 * 주어진 성적에 맞는 학점을 출력하세요.
		 * A : 90~109 //switch문으로 만들기 위해 억지로 만든 예제이기 때문에 범위가 비정상적
		 * B : 80~89
		 * C : 70~79
		 * D : 60~69
		 * F : -9~59
		 * 잘못된 성적 : 110이상, 0미만
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("성적을 입력하세요 : ");
		int score = sc.nextInt();
		
		switch(score / 10) {
		case 9, 10:
			System.out.println(score + "점은 A 입니다.");
			break;
		case 8:
			System.out.println(score + "점은 B 입니다.");
			break;
		case 7:
			System.out.println(score + "점은 C 입니다.");
			break;
		case 6:
			System.out.println(score + "점은 D 입니다.");
			break;
		case 0, 1, 2, 3, 4, 5:
			System.out.println(score + "점은 F 입니다.");
			break;
		default:
			System.out.println("잘못된 성적입니다.");
		}
		
	}

}
