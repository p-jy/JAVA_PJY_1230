package day03;

public class Ex15_WhileEvenNumber {
	public static void main(String[] args) {
		/* 
		 * 1에서 10사이의 짝수를 출력하는 while문 예제
		 * 
		 * 반복횟수: i는 1에서 10까지 1씩 증가
		 * 규칙성: i가 2의 짝수이면 i를 출력
		 * 반복문 종료 후: 없음
		 */
		
		int i = 1;
		
		while(i <= 10) {
			if(i % 2 == 0) {
				System.out.print(i + " ");
			}
			i++;
		}
		System.out.println("");
		System.out.println("==============");
		
		System.out.println("[continue 사용]");
		i = 0;
		//while문에서 continue를 만나면 증감식이 아닌 "조건식"으로 이동
		while(++i <= 10) {
			if(i % 2 != 0) {
				continue;
			}
			System.out.print(i + " ");
		}
	}
}
