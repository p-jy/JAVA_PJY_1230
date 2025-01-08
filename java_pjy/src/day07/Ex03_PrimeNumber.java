package day07;

public class Ex03_PrimeNumber {

	public static void main(String[] args) {
		/*
		 * 정수 num가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 */
		
		int num = 10;
		int i;
		
		for(i = 2; i < num; i++) {
			if(num % i == 0) {
				break;
			}
		}
		//소수일 때 i는 num, 소수가 아닐때는 num보다 작음
		if(i == num) {
			System.out.println(num + "은 소수");
		} else {
			System.out.println(num + "은 소수가 아님");
		}
		
		if(isPrimeNumber(num)) {
			System.out.println(num + "은 소수");
		} else {
			System.out.println(num + "은 소수가 아님");
		}
		
		/*
		 * 100이하의 소수를 판별하기 위해 배열을 활용해서 작성하세요.
		 */
		//i가 소수이면 i번지에 true를 i가 소수가 아니면 i번지에 false 를 저장하는 배열
		boolean primeArray [] = new boolean[101];
		for(i = 1; i < primeArray.length; i++) {
			if(isPrimeNumber(i)) {
				primeArray[i] = true;
			}
			//boolean 배열 기본값이 false 이므로 아래 else 부분은 없어도 무방함
			else {
				primeArray[i] = false;
			}
			
			System.out.println(i + " : " + primeArray[i]);
		}
		
		//primeArray를 이용하여 소수들만 출력하는 코드를 작성하세요.
		for(i = 1; i < primeArray.length; i++) {
			if(primeArray[i]) {
				System.out.print(i + " ");
			}
		}
		
	}
	
	public static boolean isPrimeNumber(int num) {
		for(int i = 2; i < num; i++) {
			if(num % i == 0) {
				return false; //num의 약수인 i 찾으면 false 리턴
			}
		}
		return num == 1? false : true;
	}

}
