package day03;

public class Ex07_ForSum {

	public static void main(String[] args) {
		/* 
		 * 1부터 10까지의 합을 구하는 코드를 작성하세요
		 * 
		 * 반복횟수: i는 1부터 10까지 1씩 증가
		 * 규칙성: sum += i
		 * 반복문 종료 후: sum 출력
		 */
		
		int sum = 0;
		int num = 10;
		
		for(int i = 1; i <= num; i++) {
			sum += i;
		}
		
		System.out.println("1부터 " + num + "까지의 합: " + sum);
		
		
		System.out.println("=======================");
		/* 1부터 10까지 짝수의 합 */
		
		sum = 0;
		for(int i = 1; i <= num; i++) {
			if(i % 2 == 0) {
				sum += i;
			}
		}
		
		System.out.println("1부터 " + num + "까지 짝수의 합 : " + sum);
	}

}
