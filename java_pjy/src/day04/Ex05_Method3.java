package day04;

public class Ex05_Method3 {

	public static void main(String[] args) {
		/*
		 * 2단에서 9단까지 구구단을 출력하는 코드를 작성하세요. 단, 메소드를 활용해서
		 */
		
		int stDan = 2, endDan = 9;
		multipleTable(stDan, endDan);
		
		for(int num = 2; num <= 9; num++) {
			printMultipleTable(num);
		}
	}
	

	/**
	 * 기능: 시작단~끝단을 출력하는 메소드
	 * @param start 시작단
	 * @param end 끝단
	 */
	public static void multipleTable(int start, int end) {
		for(int i = start; i <= end; i++) {
			System.out.println("[" + i + "단]");
			for(int j = 1; j <= end; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println();
		}
	}
	
	/**
	 * 기능: num단을 출력하는 메소드
	 * @param num 단
	 */
	public static void printMultipleTable(int num) {
		for(int i = 1; i <= 9; i++) {
			System.out.println(num + " X " + i + " = " + num*i);
		}
	}
}
