package day03;
import java.util.Random;
import java.util.Scanner;

public class Ex14_UpDown {

	public static void main(String[] args) {
		/*
		 * 1에서 100사이의 랜덤한 수를 생성해서 맞추는 게임을 구현하세요.
		 * 예)
		 * 랜덤한 수: 30
		 * 입력 : 50
		 * DOWN!
		 * 입력 : 10
		 * UP;
		 * 입력 : 30
		 * 정답! (종료)
		 */

		Random rd = new Random();
		Scanner sc = new Scanner(System.in);
		
		int min = 1, max = 100;
		int rdNum = rd.nextInt(max - min + 1) + min;
		int num;
		
		for(; ; ) {
			System.out.print("입력: ");
			num = sc.nextInt();
			if(num == rdNum) {
				System.out.println("정답!");
				break;
			} else if(num > rdNum) {
				System.out.println("DOWN!");
			} else {
				System.out.println("UP!");
			}
		}
	}

}
