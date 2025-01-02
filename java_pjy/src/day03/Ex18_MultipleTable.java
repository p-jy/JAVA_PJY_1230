package day03;

public class Ex18_MultipleTable {

	public static void main(String[] args) {
		/*
		 * 2~9단을 출력하는 코드를 작성하세요.
		 */
		
		for(int i = 2; i < 10; i++) {
			System.out.println("[" + i + "단]");
			for(int j = 1; j < 10; j++) {
				System.out.println(i + " X " + j + " = " + (i*j));
			}
			System.out.println("");
		}
	}

}
