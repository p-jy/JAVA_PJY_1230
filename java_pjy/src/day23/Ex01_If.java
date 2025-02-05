package day23;

public class Ex01_If {

	public static void main(String[] args) {
		
		/* 홀짝 판별하는 예제입니다.
		 * 잘못된 부분을 찾아 수정하세요.
		 */
		
		int num = 2;
		//if문 ;이 포함되어 문제
		if(num % 2 == 0); {
			System.out.println(num + "는 짝수");
		}
		if(num % 2 != 0) {
			System.out.println(num + "는 홀수");
		}
		
	}

}
