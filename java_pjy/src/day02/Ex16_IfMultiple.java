package day02;

public class Ex16_IfMultiple {

	public static void main(String[] args) {
		/*
		 * 정수 num가 2의 배수인지, 3의 배수인지, 6의 배수인지, 2,3,6의 배수가 아닌지를 판별하는 코드를 작성하세요.
		 * 2 : 2의 배수
		 * 3 : 3의 배수
		 * 4 : 2의 배수
		 * 5 : 2, 3, 6의 배수가 아님
		 * 6 : 6의 배수
		 */
		
		int num = 126;
		
		System.out.println("====== [순서에 상관 없이] ======");
		if(num % 2 == 0 && num % 3 == 0) {
			System.out.println(num + "은 6의 배수입니다.");
		} else if(num % 2 == 0 && num % 3 != 0) {
			System.out.println(num + "은 2의 배수입니다.");
		} else if(num % 2 != 0 && num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		} else {
			System.out.println(num + "은 2, 3, 6의 배수가 아닙니다.");
		}
		System.out.println("");
		
		
		System.out.println("======== [순서가 중요] ========");
		if(num % 6 == 0) {
			System.out.println(num + "은 6의 배수입니다.");
		} else if(num % 2 == 0) {
			System.out.println(num + "은 2의 배수입니다.");
		} else if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		} else {
			System.out.println(num + "은 2, 3, 6의 배수가 아닙니다.");
		}
		System.out.println("");
		
		
		System.out.println("========= [중첩 if] =========");
		if(num % 2 == 0) {
			if(num % 3 == 0) {
				System.out.println(num + "은 6의 배수입니다.");
			} else {
				System.out.println(num + "은 2의 배수입니다.");
			}
		} else if(num % 3 == 0) {
			System.out.println(num + "은 3의 배수입니다.");
		} else {
			System.out.println(num + "은 2, 3, 6의 배수가 아닙니다.");
		}
		
	}

}
