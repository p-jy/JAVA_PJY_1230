package day03;

import java.util.Scanner;

public class Ex05_ForPrimNumber {

	public static void main(String[] args) {
		/*
		 * 정수를 입력받아 입력받은 정수가 소수인지 아닌지 판별하는 코드를 작성하세요.
		 * 소수: 약수가 1과 자기자신만 있는 수.
		 * 소수: 2, 3, 5, 7, 11, 13, 17
		 * 
		 */
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int count = 0;
		
		for(int i = 1; i <= num; i++) { // i = 2; i < num; i++ => count == 0 && num != 1 소수
			if(num % i == 0) {
				 count++;
			}
		}
		
		if(count == 2) {
			System.out.println(num + "은(는) 소수입니다.");
		} else {
			System.out.println(num + "은(는) 소수가 아닙니다.");
		}
		
	}

}
