package day09;

public class Ex01_String {

	public static void main(String[] args) {
		
		/* 파일명이 주어졌을 때 파일이 이미지인지 아닌지 확인하는 코드를 작성
		 */
		
		String fileName = "test.txt";
		String imgs [] = new String[] {"jpg", "bmp", "gif", "png"};
		
		// . 위치 찾기
		int index = fileName.lastIndexOf(".");
		
		if(index < 0) {
			System.out.println(fileName + "은 이미지 파일이 아닙니다.");
			return;
		}
		// . 위치 이후 문자열 추출
		String prefix = fileName.substring(index+1);
//		System.out.println(prefix);
		// 추출한 문자열이 imgs[] 에 있는지 확인
		boolean result = false;
		for(String img : imgs) {
			if(img.equals(prefix)) {
				result = true;
				break;
			}
		}
		
		//있으면
		if(result) {
			System.out.println(fileName + "은 이미지 파일이 맞습니다.");
		}
		//없으면
		else {
			System.out.println(fileName + "은 이미지 파일이 아닙니다.");
		}
		
	}

}
