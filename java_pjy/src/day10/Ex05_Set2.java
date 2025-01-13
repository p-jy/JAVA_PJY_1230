package day10;

import java.util.HashSet;

public class Ex05_Set2 {

	public static void main(String[] args) {
		// 1에서 9 사이의 랜덤한 수를 생성하여 중복되지 않게 3개 만드는 코드를 작성하세요.
		
		HashSet<Integer> rdNum = new HashSet<Integer>();
		int min = 1, max = 9;
		
		while(rdNum.size() < 3) {
			int num = (int)(Math.random() * (max - min + 1) + min);
			System.out.println(num);
			rdNum.add(num);
		}
		
		System.out.println(rdNum);

	}

}
