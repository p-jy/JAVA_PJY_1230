package day03;

public class Ex20_NestingAlphabet {
	public static void main(String[] args) {
		/*
		 * 다음과 같이 출력되도록 코드를 작성하세요.
		 * a
		 * ab
		 * abc
		 * ...
		 * abcdefg...xyz
		 * 
		 * 
		 */
		
		for(char lastCh = 'a'; lastCh <= 'z'; lastCh++) {
			for(char ch = 'a'; ch <= lastCh; ch++) {
				System.out.print(ch);
			}
			System.out.println("");
		}
	}
}
