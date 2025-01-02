package day03;

import java.util.Random;

public class Ex13_Random {

	public static void main(String[] args) {
		/*
		 * min~max 사이의 랜덤한 수를 생성하는 코드
		 */
		
		int min = 1, max = 7;
		
		//Math.random()는 0이상 1미만의 랜덤한 실수를 제공
		/*
		 * 0 <= r < 1
		 * 각 항에 (max - min + 1)을 곱함
		 * => 0 <= r * (max - min + 1) < max - min + 1
		 * => 각 항에 min을 더함
		 * => min <= r * (max - min + 1) + min < max + 1		
		 */
		int r = (int)(Math.random() * (max - min + 1) + min); //min~max 사이의 랜덤한 수를 생성
		System.out.println(r);
		
		Random rd = new Random();
		r = rd.nextInt(max - min + 1) + min; //rd.nextInt(a)는 0에서 a-1사이의 랜덤한 정수를 생성
		System.out.println(r);
	}

}
