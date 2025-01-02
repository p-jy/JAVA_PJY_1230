package day03;

import java.util.Scanner;

public class Ex01_Test {

	public static void main(String[] args) {
		/* 
		 * 세 학생의 국어 성적을 입력받아 총점과 평균을 구하는 코드를 작성하세요.
		 */
		
		int kor1, kor2, kor3;
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("세 학생의 국어 성적을 입력하세요 : ");
		kor1 = sc.nextInt();
		kor2 = sc.nextInt();
		kor3 = sc.nextInt();
		
		int sum = kor1 + kor2 + kor3;
		
		double avg = sum / 3.0;
		
		System.out.println("총점: " + sum + ", 평균: " + avg);
	}

}
