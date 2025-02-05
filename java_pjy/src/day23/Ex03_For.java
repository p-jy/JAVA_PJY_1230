package day23;

public class Ex03_For {

	public static void main(String[] args) {
		
		/* 10부터 1까지 차례대로 출력하는 예제. 잘못된 부분을 찾아 수정하세요. */
		
		//조건식이 잘못됨. i가 1보다 크거나 같아야함
		for(int i = 10; i <= 1; i--) {
			System.out.println(i);
		}
		
		//증감식이 잘못되어 무수히 많이 실행됨(오버플로우 때문에 무한루프는 아님)
		//i++이 아닌 i--여야 함.
		for(int i = 10; i >= 1; i++) {
			System.out.println(i);
		}
	}

}
