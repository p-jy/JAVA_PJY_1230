package day04;

import java.util.Random;
import java.util.Scanner;

public class Ex03_Method {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		System.out.println(num1 + "과 " + num2 + "의 최대공약수 : " + gcd(num1, num2));
		System.out.println(num1 + "과 " + num2 + "의 최소공배수 : " + lcm(num1, num2));
		System.out.println(num1 + "과 " + num2 + "의 최소공배수 : " + lcm2(num1, num2));
		
		int min = 1, max = 10;
		System.out.println(min + "과 " + max + " 사이의 랜덤한 수: " + random(min, max));
	}
	
	/*
	 * 
	 */
	
	/**
	 * 기능: 두 정수의 최대공약수를 알려주는 메소드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 최대 공약수 (gcd)
	 */
	public static int gcd(int num1, int num2) {
		int gcd = 0;
		for(int i = 1; i <= num1; i++) {
			if(num1 % i == 0 && num2 % i == 0) {
				gcd = i;
			}
		}
		
		return gcd;
	}
	
	/**
	 * 기능: 두 정수의 최소 공배수를 알려주는 메소드
	 * @param num1 정수1
	 * @param num2 정수2
	 * @return 두 정수의 최소공배수 (lcm)
	 */
	public static int lcm(int num1, int num2) {
		
		for(int i = num1; ; i += num1) {
			if(i % num2 == 0) {
				return i;
			}
		}
	}
	
	/*
	 * 최대 공약수를 알 때 최소 공배수를 계산
	 * A: Ga, B: Gb
	 * L: Gab => A*B/G
	 */
	public static int lcm2(int num1, int num2) {
		return num1 * num2 / gcd(num1, num2);
	}

	/**
	 * 기능: 최소값과 최대값 사이의 랜덤한 수를 생성하는 메소드
	 * @param min 최소값
	 * @param max 최대값
	 * @return 랜덤 숫자 r
	 */
	public static int random(int min, int max) {
		return (int)(Math.random()*(max - min +1) + min);
	}

}
