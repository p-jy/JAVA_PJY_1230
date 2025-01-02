package day03;

import java.util.Scanner;

public class Ex04_ForDivisor {

	public static void main(String[] args) {
		/*
		 * 입력받은 num의 약수를 출력하는 코드를 작성하세요.
		 * 약수: 나누었을 때 나머지가 0이 되는 수
		 * 12의 약수: 1, 2, 3, 4, 6, 12
		 * 
		 * 반복횟수 : i는 1부터 num까지 1씩 증가
		 * 규칙성 : (num % i == 0)이면 출력
		 * 반복문 종료 후 : 없음
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력해주세요 : ");
		int num = sc.nextInt();
		
		System.out.print(num + "의 약수: ");
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				System.out.print(i + (i != num? ", " : ""));
			}
		}
	}
}
