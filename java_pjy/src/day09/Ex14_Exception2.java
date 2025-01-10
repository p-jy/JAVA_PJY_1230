package day09;

import java.util.Arrays;

import javax.management.RuntimeErrorException;

public class Ex14_Exception2 {

	public static void main(String[] args) {
		
		int[] arr = new int [] {1,2,3,4,5};
		//정상적인 경우
		arr = expend(arr, 5);
		System.out.println(Arrays.toString(arr));
	
		
		try {
		//예외 : 축소하는 경우 복사하는 과정에서 문제가 발생할 수 있음.
//			arr = expend(arr, -10);
		
		//예외 : 배열이 null이어서 예외가 발생.
			arr = null;
			arr = expend(arr, 10);
		} catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}
		
		
		System.out.println("프로그램 종료");
		
	}
	
	public static int [] expend(int [] arr, int addSize) {
		//arr배열에 addSize 만큼 크기를 늘려서 새로운 배열을 만들어 반환하는 메소드
		
		if(addSize < 0) {
			throw new RuntimeException("배열을 축소할 수 없습니다.");
		}
		if(arr == null) {
			throw new NullPointerException("없는 배열을 확장할 수 없습니다.");
		}
		
		int tmp[] = new int[arr.length + addSize];
		System.arraycopy(arr, 0, tmp, 0, arr.length);
		
		return tmp;
	}

}
