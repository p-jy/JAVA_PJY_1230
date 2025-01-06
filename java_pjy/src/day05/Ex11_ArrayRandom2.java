package day05;

public class Ex11_ArrayRandom2 {

	public static void main(String[] args) {
		/*
		 * 1~10 사이의 중복되지 않은 랜덤한 수 6개를 배열에 저장하는 코드를 작성하세요.
		 */
		
		int size = 6, min = 1, max = 7;
		int [] arr = new int[size];
		int count = 0;

		while(count < arr.length) { //반복 저장된 개수가 size가 될때까지
			int r = (int)(Math.random() * (max - min + 1) + min); //랜덤한 수 생성
			boolean result = false;
			
			for(int i = 0; i < arr.length; i++) {
				if(arr[i] == r) {
					result = true;
					break;
				}
			}
			
			if(result) {
				continue;
			} 
			arr[count] = r;
			count++;
			//arr[count++] = r; // 위 두 줄과 동일.
			
		}
		
		printArray(arr);
		
		int [] arr2 = createRandomArray(min, max, size);
		printArray(arr2);
		
		
	}
	
	
	public static void printArray(int [] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public static boolean contains(int [] arr, int num) {
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == num) {
				return true;
			}
		}
		return false;
	}
	
	public static int [] createRandomArray(int min, int max, int size) {
		
		if(size <= 0) {
			return null;
		}
		
		int [] arr = new int [size];
		int count = 0;
		
		while(count < arr.length) {
			int r = (int)(Math.random() * (max - min + 1) + min);
			
			if(contains(arr, r)) {
				continue;
			}
			arr[count++] = r;
			
		}
		
		return arr;
	}
}