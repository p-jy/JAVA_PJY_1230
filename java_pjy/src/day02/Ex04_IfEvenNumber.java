package day02;

public class Ex04_IfEvenNumber {

	public static void main(String[] args) {
		
		/*
		 * if문을 이용한 홀짝 판별 예제
		 */
		
		int num = 4;
		
		/*
		 * num가 짝수라면 짝수라고 출력
		 */
		if(num % 2 == 0) {
			System.out.println(num + "는 짝수");
		}
		
		/*
		 * num가 홀수라면 홀수라고 출력
		 */
		
		if(num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}

	}

}
