package day06;

import java.util.Scanner;

public class Ex07_BaseballGame {

	public static void main(String[] args) {
		/*
		 * 숫자 야구 게임을 구현하세요. (1~9)
		 * S : 숫자가 있고 위치가 같은 경우
		 * B : 숫자는 있지만 위치가 다른 경우
		 * 3O : 일치하는 숫자가 하나도 없는 경우
		 * 
		 * 랜덤 수 : 3 7 1
		 * 입력 : 1 2 3
		 * 2B
		 * 입력 : 4 5 6
		 * 3O
		 * 입력 : 8 7 9
		 * 1S
		 * 입력 : 3 1 7
		 * 1S 2B
		 * 입력 : 3 7 1
		 * 3S
		 * 프로그램을 종료합니다.
		 */
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 9;
		int strike, ball;
		
		System.out.println("야구 게임 시작");
		System.out.println();

		int [] com = createRandomArray(min, max, 3);
	//	print(com); //확인용
		
		int [] user = new int[3];
		
		do {
			strike = 0;
			
			user = new int[3];
			if(!getUser(user)) {
				continue;
			}
			
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			
			//		print(user); //확인용
			
			printResult(strike, ball);
			
		} while (strike != 3); //strike < 3 으로 입력해도 무방.

	}
	
	public static int [] createRandomArray(int min, int max, int size) {
		//max과 min를 반대로 쓴 경우
		if(max < min) {
			int tmp = max;
			max = min;
			min = tmp;
		}
		//랜덤 범위보다 size가 큰 경우
		if(max - min + 1 < size) {
			return null;
		}
		
		if(size <= 0) {
			return null;
		}
		
		int [] arr = new int [size];
		int count = 0;
		
		do {
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			if(contains(arr, r)) {
				continue;
			}
			arr[count++] = r;
			
		} while(count < 3);
		
		return arr;
	}
	
	public static boolean contains(int [] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static void print(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static int getStrike(int[] com, int[] user) {
		int strike = 0;
		for(int i = 0; i < com.length; i++) {
			if(com[i] == user[i]) {
				strike++;
			}
		}
		return strike;
	}
	
	public static int getBall(int[] com, int[] user) {
		int cnt = 0;
	
		for(int i = 0; i < com.length; i++) {
			if(contains(com, user[i])) {
				cnt++;
			}
		}
		return cnt - getStrike(com, user);
	}
	
	public static boolean getUser(int [] user) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("정수 3개 입력(1~9, 중복X) : ");
		
		boolean outOfBounds = false;
		boolean duplicated = false;
		
		for(int i = 0; i < user.length; i++) {
			int tmp = sc.nextInt();
			if(tmp < 1 || tmp > 9) {
				outOfBounds = true;
			}
			if(contains(user, tmp)) {
				duplicated = true;
			}
			
			user[i] = tmp;
		}
		if(outOfBounds || duplicated) {
			System.out.println("범위를 벗어나거나 중복된 수가 있습니다.");
		}
		
		return !outOfBounds && !duplicated;

	}
	
	public static void printResult(int strike, int ball) {

		if(strike == 3) {
			System.out.println("3S");
			System.out.println("프로그램을 종료합니다.");
		} else if(ball > 0 && strike > 0) {
			System.out.println(strike + "S " + ball + "B");
		} else if(strike > 0 && ball == 0)  {
			 System.out.println(strike + "S");
		} else if(ball > 0 && strike == 0) {
			System.out.println(ball + "B");
		} else {
			System.out.println("3O");
		}
	}
	
}
