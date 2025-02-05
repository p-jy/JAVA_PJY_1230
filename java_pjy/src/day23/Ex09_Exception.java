package day23;

public class Ex09_Exception {

	public static void main(String[] args) {
		
		/* 0으로 나누었을 때 0으로 나눌 수 없습니다. 를 처리하도록 수정 */
		
		double num1 = 1, num2 = 0;
		
		// num2가 0이면 예외를 발생시켜서 try catch 로 예외 처리
		
		try {
			if(num2 == 0) {
				throw new Exception();
			}
			System.out.println(num1 + "/" + num2 + "=" + num1/num2);
		} catch(Exception e) {
			System.out.println("0으로 나눌 수 없습니다.");
		}
		
	}

}
