package day02;

public class Ex07_Number {

	public static void main(String[] args) {
		/*
		 * num가 0보다 크면 양수라고 출력하고
		 * num가 0이면 0이라고 출력하고
		 * num가 0보다 작으면 음수라고 출력하는 코드를 작성하세요.
		 */
		
		int num = -10;
		
		if(num > 0) {
			System.out.println(num + "은 양수");
		} else if (num == 0) {
			System.out.println(num + "은 0");
		} else {
			System.out.println(num + "은 음수");
		}

	}

}
