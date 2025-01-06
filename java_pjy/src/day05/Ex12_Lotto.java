package day05;

import java.util.Scanner;

public class Ex12_Lotto {

	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 수 6개를 생성하고, 1개의 보너스 번호를 생성
		 * 1~45 사이의 정수 6개를 입력받아 입력한 정수가 몇등인지 확인하는 코드를 작성하세요.
		 * 1등: 6개 일치
		 * 2등: 5개 일치 + 보너스 번호 일치
		 * 3등: 5개 일치
		 * 4등: 4개 일치
		 * 5등: 3개 일치
		 * 꽝: 나머지
		 */
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 45;
		int [] user = new int[6];
		int count = 0;
		int bonus;

		int [] lottoNum = createRandomArray(min, max, 6);
		printArray(lottoNum); //확인용
		
		do {
			bonus = (int)(Math.random() * (max - min + 1) + min);
		} while(contains(lottoNum, bonus));
		System.out.println("보너스 : " + bonus);
		
		System.out.print("로또 번호를 입력하세요 : ");
		for(int i = 0; i < user.length; i++) {
			user[i] = sc.nextInt();
		}
		
		for(int i = 0; i < lottoNum.length; i++) {
			if(contains(user, lottoNum[i])) {
				count++;
			}
		}
		
		printResult(count, bonus, user);
		
	}
	
	/**
	 * 배열 출력
	 * @param arr
	 */
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	/**
	 * 중복 숫자 여부 판별
	 * @param arr
	 * @param num
	 * @return
	 */
	public static boolean contains(int [] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	
	/**
	 * 배열 생성
	 * @param min
	 * @param max
	 * @param size
	 * @return
	 */
	public static int [] createRandomArray(int min, int max, int size) {
		
		if(size <= 0) {
			return null;
		}
		
		int [] arr = new int [size];
		int count = 0;
		
		while(count < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			if(contains(arr, r)) {
				continue;
			}
			arr[count++] = r;
			
		}
		
		return arr;
	}
	
	/**
	 * 추첨 결과 출력
	 * @param count
	 * @param bonus
	 */
	public static void printResult(int count, int bonus, int[] user) {
		switch (count) {
		case 6:
			System.out.println("1등 당첨");
			break;
		case 5:
			if(contains(user, bonus)) {
				System.out.println("2등 당첨");
			} else {
				System.out.println("3등 당첨");
			}
			break;
		case 4:
			System.out.println("4등 당첨");
			break;
		case 3:
			System.out.println("5등 당첨");
			break;
		default:
			System.out.println("꽝");
		}
	}
}