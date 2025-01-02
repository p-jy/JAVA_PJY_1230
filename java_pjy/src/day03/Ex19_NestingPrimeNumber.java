package day03;

public class Ex19_NestingPrimeNumber {

	public static void main(String[] args) {
		/*
		 * 100이하의 소수를 출력하는 코드를 작성하세요.
		 */
		
		int num;
		int count;
		
		for(num = 2; num <= 100; num++) {
			count = 0;
			for(int i = 1; i <= num; i++) {
				if(num % i == 0) {
					count++;
				}
			}
			
			if(count == 2) {
				System.out.print(num + " ");
			}
		}
		
	}

}
