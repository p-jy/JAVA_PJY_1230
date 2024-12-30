package day01;

public class Ex05_VariableBoolean {

	public static void main(String[] args) {
		boolean isAdult = true; //또는 false로 초기화
		int age = 10;
		isAdult = age > 18; //19세 이상이면 성인
		System.out.println(age + "살인 성인? " + isAdult);
	}

}
