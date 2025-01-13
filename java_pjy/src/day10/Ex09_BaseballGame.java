package day10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class Ex09_BaseballGame {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Integer> user = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		
		//숫자 야구 게임
		ArrayList<Integer> com = new ArrayList<Integer>();
		
		int strike = 0, ball = 0;
		int min = 1, max = 9, size = 3;
		
		System.out.println("야구 게임 시작");
		setCom(min, max, size, com);
		
//		System.out.println(com);
		
		do {
			user.clear();
			getUser(size);
//			System.out.println(user);
			
			strike = getStrike(com, user);
			ball = getBall(com, user);
			
			printResult(strike, ball);
			
		} while (strike != 3);
		

	}
	
	private static void printResult(int strike, int ball) {
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

	private static int getBall(ArrayList<Integer> com, ArrayList<Integer> user) {
		int cnt = 0;
		
		for(int tmp : com) {
			if(user.contains(tmp)) {
				cnt++;
			}
		}
		return cnt - getStrike(com, user);
	}

	private static int getStrike(ArrayList<Integer> com, ArrayList<Integer> user) {
		int strike = 0;
		
		for(int i = 0; i < com.size(); i++) {
			if(com.get(i) == user.get(i)) {
				strike++;
			}
		}
		return strike;
	}

	public static void setCom(int min, int max, int size, ArrayList<Integer> com) {
		HashSet<Integer> set = new HashSet<Integer>();
		
		while (set.size() < size) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			set.add(r);
		} 
//		System.out.println(set);
		
		
		com.addAll(set);
		
		Collections.shuffle(com);

	}
	
	public static void getUser(int size) {
		System.out.print("정수 3개 입력 : ");
		
		for(int i = 0; i < size; i++) {
			user.add(sc.nextInt());
		}
	}

}
