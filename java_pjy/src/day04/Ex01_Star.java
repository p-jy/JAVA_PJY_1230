package day04;

public class Ex01_Star {

	public static void main(String[] args) {
		/*
		 *     *
		 *    **
		 *   ***
		 *  ****
		 * *****
		 */
		
		int num = 5;
		
		for(int i = 1; i <= num; i++) {
			for(int j = num-1; j >= i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		/*
		 *     *
		 *    ***
		 *   *****
		 *  *******
		 * *********
		 */
		
		for(int i = 1; i <= num; i++) {
			for(int j = num-1; j >= i; j--) {
				System.out.print(" ");
			}
			for(int k = 1; k <= (2*i - 1); k++) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		
		/*
		 *     *
		 *    ** *
		 *   *** **
		 *  **** ***
		 * ***** ****
		 */
		
		for(int i = 1; i <= num; i++) {
			for(int j = 1; j <= num-i; j++) {
				System.out.print(" ");
			}
			for(int k = 1; k <= i; k++) {
				System.out.print("*");
			}
			for(int l = 1; l <= i-1; l++) {
				System.out.print("*");
			}
			System.out.println();
		}
		

	}

}
