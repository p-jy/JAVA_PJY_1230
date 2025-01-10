package day09;

import java.util.ArrayList;

public class Ex05_Wrapper {

	public static void main(String[] args) {
		
		int num1 = 10;
		
		Integer num2 = num1; //박싱. 기본형 => 클래스
		
		int num3 = num2; //언박싱. 클래스 => 기본형
		
		System.out.println(num2 + ", " + num3);
		
		//언박식하는 경우 null을 주의
		num2 = null; //래퍼 클래스는 클래스이기 때문에 null을 저장할 수 있음
		
//		num3 = num2; //예외 발생. null을 정수로 만들 수 없음.
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		System.out.println(list);
		
	}

}
