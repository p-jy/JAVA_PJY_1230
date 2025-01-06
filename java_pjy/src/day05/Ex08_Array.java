package day05;

import java.util.Scanner;

public class Ex08_Array {

	public static void main(String[] args) {
		/*
		 * 학생 3명의 국어 성적을 관리하기 위해 배열을 선언하고
		 * 콘솔을 통해 성적을 입력받고, 입력받은 성적을 출력하는 코드를 작성
		 */
		
		int studentCount = 3;
		int kor[] = new int[studentCount];
		
		Scanner sc = new Scanner(System.in);
		
	//	kor[0] = 10;
	//	kor[1] = 100;
	//	kor[2] = 90;
		for(int i = 0; i < studentCount; i++) {
			System.out.print("학생" + (i+1) + " 국어 성적 입력 : ");
			kor[i] = sc.nextInt();
		}
		
	//	System.out.println(kor[0]);
	//	System.out.println(kor[1]);
	//	System.out.println(kor[2]);
		
		for(int i = 0; i < studentCount; i++) {
			System.out.println("학생" + (i+1) + " 국어 성적 : " + kor[i]);
		}
		
		
		// 입력받은 3 학생의 평균을 구해서 출력하는 코드를 작성.
		
		int sum = 0;
		
		for(int i = 0; i < studentCount; i++) {
			sum += kor[i];
		}
		
		System.out.println("학생 " + studentCount + "명의 국어 점수 평균 : " + (sum/(double)studentCount));
	}

}
