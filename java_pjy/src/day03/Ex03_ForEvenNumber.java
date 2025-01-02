package day03;

public class Ex03_ForEvenNumber {

	public static void main(String[] args) {
		/* 
		 * 10이하의 짝수를 출력하는 코드를 작성하세요.
		 */
		
		/*
		 * 반복횟수: i는 1부터 10까지 1씩 증가
		 * 규칙성: 
		 * 반복문 종료 후: 없음
		 */
		System.out.println("[1~10] 1씩 증가 짝수인 경우 출력");
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				System.out.print(i + (i != 10? ", " : ""));
			}
		}
		System.out.println("");
		System.out.println("==========================");
		
		/*
		 * 반복횟수: i는 2부터 10까지 2씩 증가
		 * 규칙성: 
		 * 반복문 종료 후: 없음
		 */
		System.out.println("[2~10] 2씩 증가하여 출력");
		for(int i = 2; i <= 10; i+=2) {
			System.out.print(i + (i != 10? ", " : ""));
		}
		System.out.println("");
		System.out.println("==========================");
		
		/*
		 * 반복횟수: i는 1부터 5까지 1씩 증가
		 * 규칙성: 
		 * 반복문 종료 후: 없음
		 */
		System.out.println("[1~5] 1씩 증가 X2하여 출력");
		for(int i = 1; i <= 5; i++) {
			System.out.print(2*i + (i != 5? ", " : ""));
		}
		System.out.println("");
		
	}

}
