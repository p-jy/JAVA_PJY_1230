package day02;

public class Study02_for {

	public static void main(String[] args) {
		/*
		 * for문과 변수를 사용하여 '안녕하세요1, 안녕하세요2…, 안녕하세요10'까지 차례로 출력하는 프로그램을 작성해 보세요.
		 */
		
		for(int i = 1; i <= 10; i++) {
			System.out.print("안녕하세요" + i /* + (i != 10 ? ", " : "")*/); //if문 없이 한줄로 처리하는 방법. (마지막에 ,로 끝나지 않도록)
			if (i != 10) {
				System.out.print(", ");
			}
		}

	}

}
