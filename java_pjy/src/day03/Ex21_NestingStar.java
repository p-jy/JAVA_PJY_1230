package day03;

public class Ex21_NestingStar {

	public static void main(String[] args) {
		/* 
		 * 중첩 for문 5X5 별찍기
		 * 
		 * 반복횟수: i는 1부터 5까지 1씩 증가 => 줄
		 * 규칙성: 
		 * 	- 반복횟수: j는 1부터 5까지 1씩 증가
		 * 	- 규칙성: *을 출력 (print)
		 * 	- 반복문 종료 후: 엔터
		 * 반복문 종료 후: 없음
		 */
		int num = 5;
		System.out.println("중첩 for문 5X5 별찍기");
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= 5; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/*
		 * *
		 * **
		 * ***
		 * ****
		 * *****
		 */
		System.out.println("중첩 for문 우측 계단형 별찍기");
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/* [별찍기 연습]
		 *     * i=1 " "=4, *=1
		 *    **
		 *   ***
		 *  ****
		 * *****
		 */
		
		System.out.println("중첩 for문 좌측 계단형 별찍기");
		for(int i = 1; i <= num; i++) {
			for(int j =num-i; j >= 1; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/* [별찍기 연습]
		 * *****
		 * ****
		 * ***
		 * **
		 * *
		 */
		System.out.println("중첩 for문 우측 역계단 별찍기");
		for(int i = num; i >= 1; i--) {
			for(int j = i; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/* [별찍기 연습]
		 * *****
		 *  ****
		 *   ***
		 *    **
		 *     *
		 */
		System.out.println("중첩 for문 좌측 역계단 별찍기");
		for(int i = num; i >= 1; i--) {
			for(int j = num-i; j >= 1; j--) {
				System.out.print(" ");
			}
			for(int k = i; k >= 1; k--) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println();
		
		/* [별찍기 연습]
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */
		System.out.println("중첩 for문 트리형 별찍기");
		for(int i = 1; i <= num; i++) {
			for(int j = num-i; j >= 1; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= 2*i-1; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/* [별찍기 연습]
		 * *********
		 *  *******
		 *   *****
		 *    ***
		 *     *
		 */
		System.out.println("중첩 for문 역트리 별찍기");
		for(int i = num; i >= 1; i--) {
			for(int k = 1; k <= num-i; k++) {
				System.out.print(" ");
			}
			for(int j = 2*i-1; j >= 1; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
