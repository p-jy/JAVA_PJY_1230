package day03;

import java.util.Scanner;

public class Study01_DiamondStar {

	public static void main(String[] args) {
		/*
		 *   *
		 *  ***
		 * *****
		 *  ***
		 *   *
		 */
		
		 Scanner sc = new Scanner(System.in);
		 System.out.print("줄 수를 입력하세요(단, 짝수인 경우 줄-1) : ");
		 int line = sc.nextInt();
		 
		 if(line % 2 == 0) {
			 line--;
		 }
		 
		 for(int i = 1; i <= line/2+1; i++) {
			 for(int j = line/2 + 1 - i; j >= 1; j--) {
				 System.out.print(" ");
			 }
			 for(int k = 1; k <= 2*i-1; k++) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }
		 for(int i = line/2+2; i >= line/2-1; i--) {
			 for(int j = 1; j <= line/2-(line/2-1); j++) {
				 System.out.print(" ");
			 }
			 for(int k = 2*i-line; k >= 1; k--) {
				 System.out.print("*");
			 }
			 System.out.println();
		 }

	}

}
