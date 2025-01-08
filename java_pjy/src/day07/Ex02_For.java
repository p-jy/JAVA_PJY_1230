package day07;

public class Ex02_For {

	public static void main(String[] args) {
		/*
		 * 1부터 10까지 합을 구하는 코드를 작성하세요.
		 * 1 - 2 + 3 - 4 + 5 - 6 + 7 - 8 + 9 - 10를 출력하는 코드를 작성하세요.
		 */
		int max = 10;
		int sum = 0;
		
		for(int i = 1; i <= max; i++) {
			sum += i;
		}
		System.out.println("1~10의 합 : " + sum);
		
		sum = 0;
		for(int i = 1; i <= max; i++) {
			if(i % 2 == 1) {
				sum += i;
			} else {
				sum -= i;
			}
		}
		System.out.println("홀수 합 - 짝수 합 : " + sum);

	}

}
