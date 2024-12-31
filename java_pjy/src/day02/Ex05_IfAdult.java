package day02;

public class Ex05_IfAdult {

	public static void main(String[] args) {
		/*
		 * 나이를 저장하는 변수 age를 선언 및 초기화
		 * age가 19세 이상이면 성인, age가 19세 이상이 아니면 미성년자라고 출력하는 코드를 작성
		 */
		int age = 19;
		
		if (age >= 19) {
			System.out.println(age + "세 : 성인");
		}
		
		if (age < 19) {
			System.out.println(age + "세 : 미성년자");
		}
		
	}

}
