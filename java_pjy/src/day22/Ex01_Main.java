package day22;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Main{

	/* 단어장 프로그램을 구현하세요.
	 * - 관리자
	 * 	- 단어 등록
	 * 	- 단어 수정
	 * 	- 단어 삭제
	 * - 사용자
	 * 	- 단어 검색
	 * 	  - 검색할 단어를 입력 후, 조회된 단어 중 하나를 선택
	 * 	- 내 검색 단어 보기
	 * 	  - 단어 검색에서 선택한 단어를 출력
	 * 
	 * [주의]
	 * - 중복 단어 허용
	 * - 단어, 품사, 뜻 으로 구성
	 * - 사용자는 아이디로 구분. -> 아이디 중복X
	 * - 사용자는 회원가입을 따로 하지 않음.
	 * - 관리자는 admin으로 고정
	 * - 저장과 불러오기 필수.
	 * 
	 * 메뉴 출력 전 아이디 입력 받음
	 * 아이디가 admin인 경우 -> 관리자 메뉴 출력
	 * 아이디가 admin이 아닌 경우 -> 사용자 메뉴 출력
	 */

	
	public static void main(String[] args) {
		
		WordNoteProgram program = new WordNoteProgram();
		program.run();
		
	}

}
