package day09;

import java.util.Scanner;

public class Ex02_String2 {

	public static void main(String[] args) {
		/* 파일명을 수정하는 기능을 구현하세요.
		 * 기존 파일명을 입력받고 (확장자 포함)
		 * 수정하려는 파일명을 입력받아 (확장자 제외)
		 * 파일명을 수정하세요.
		 * 
		 * ex.
		 * 입력 : test.txt
		 * 수정 : 연습
		 * 결과 : 연습.txt
		 * 
		 * lastIndexOf, substring, replace
		 */
		
		Scanner sc = new Scanner(System.in);
			
		System.out.print("입력(확장자 포함) : ");
		String fileName = sc.nextLine();
//		System.out.println(fileName);
		System.out.print("수정 : ");
		String edit = sc.nextLine();
//		System.out.println(editName);
		
		int index = fileName.lastIndexOf(".");
		
		if(index < 0) {
			System.out.println("확장자가 없는 파일명입니다.");
			return;
		}
		String editName = fileName.replace(fileName.substring(0, fileName.length()-index), edit);
		
		
		System.out.println("결과 : " + editName);
	}

}
