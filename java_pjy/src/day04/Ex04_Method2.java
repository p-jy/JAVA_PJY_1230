package day04;

public class Ex04_Method2 {

	public static void main(String[] args) {
		/*
		 * 100이하의 소수를 출력하는 코드를 작성하세요 단, 메소드를 활용.
		 */
		System.out.println("[100이하의 소수 출력]");
		for(int i = 1; i <= 100; i++) {
			if(pNum(i) == 2) {
				System.out.print(i + " ");
			}
		}
		System.out.println();
		
		//교수님 코드
		for(int num = 1; num <= 100; num++) {
	//		if(isPrimeNumber(num)) {
	//			System.out.print(num + " ");
	//		}
			System.out.print(isPrimeNumber(num)? num + " " : "");
		}
		System.out.println();
		System.out.println();
		
		/*
		 * 10이 소수인지 아닌지 판별하는 코드를 작성하세요. 단, 메소드를 활용해서
		 */
		int num = 1;
		
		System.out.println("[" + num + "이 소수인지 판별]");

		
		if(pNum(num) == 2) {
			System.out.println(num + "은 소수입니다.");
		} else {
			System.out.println(num + "은 소수가 아닙니다.");
		}
		
	//	if(isPrimeNumber(num)) {
	//		System.out.println(num + "는 소수입니다.");
	//	} else {
	//		System.out.println(num + "는 소수가 아닙니다.");
	//	}
		
		System.out.println(isPrimeNumber(num)? num + "는 소수입니다." : num + "는 소수가 아닙니다.");
		
		System.out.println();
		System.out.println();
	}
	

	/**
	 * 기능: 약수의 개수를 count
	 * @param num 약수의 개수를 카운트할 정수
	 * @return 카운트된 숫자를 출력
	 */
	public static int pNum(int num) {
		int count = 0;
		
		for(int i = 1; i <= num; i++) {
			if(num % i == 0) {
				 count++;
			}
		}
		
		return count;
	}

	
	// 교수님 코드
	/**
	 * 정수가 소수인지 아닌지 판별하는 메소드
	 * @param num 정수
	 * @return 소수인지 아닌지 boolean (true/false)
	 */
	public static boolean isPrimeNumber(int num) {
		if(num == 1) {
			return false;
		}
		for(int i = 2; i < num; i++) {
			if(num% i == 0) {
				return false;
			}
		}
		return true;
	}
}
