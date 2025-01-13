package day10;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex10_Dictionary {
	/* 다음 기능을 갖는 사전 프로그램을 작성하세요.
	 * 
	 * 1. 단어 등록				1. 단어 등록				1. 단어 등록
	 * 2. 단어 수정				2. 단어 수정				2. 단어 수정
	 * 3. 단어 삭제				3. 단어 삭제				3. 단어 삭제
	 * 4. 단어 검색				4. 단어 검색				4. 단어 검색
	 * 5. 종료					5. 종료					5. 종료
	 * 메뉴 선택 : 1				메뉴 선택 : 1				메뉴 선택 : 2
	 * 단어 : apple				단어 : apple				단어 : apple
	 * 의미 : 사과, 회사명			의미 : apple				의미 : 사과, 회사명(애플)
	 * 단어가 등록됐습니다.			이미 등록된 단어입니다.		단어가 수정됐습니다.
	 * ---------------			-----------------		-------------------
	 * 1. 단어 등록				1. 단어 등록				1. 단어 등록
	 * 2. 단어 수정				2. 단어 수정				2. 단어 수정
	 * 3. 단어 삭제				3. 단어 삭제				3. 단어 삭제
	 * 4. 단어 검색				4. 단어 검색				4. 단어 검색
	 * 5. 종료					5. 종료					5. 종료
	 * 메뉴 선택 : 4				메뉴 선택 : 3				메뉴 선택 : 5
	 * 단어 : a					단어 : apple				프로그램을 종료합니다.
	 * apple : 사과, 회사명(애플)	단어가 삭제됐습니다.			
	 * 													
	 * ---------------			-----------------		-------------------
	 */
	
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Word> list = new ArrayList<Word>();
	public static void main(String[] args) {
		

		
		int menu;
		
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
		} while(menu != 5);

	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1: //단어 등록
			insertWord();
			break;
		case 2: //단어 수정
			updateWord();
			break;
		case 3: //단어 삭제
			deleteWord();
			break;
		case 4: //단어 검색
			searchWord();
			break;
		case 5: //종료
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}

	private static void searchWord() {
		System.out.print("단어 : ");
		String wd = sc.nextLine();
		
		int count = 0;
		
		for(Word tmp : list) {
			if(tmp.getWord().contains(wd)) {
				System.out.println(tmp);
				count++;
			}
		}
		if(count == 0) {
			System.out.println("일치하는 단어가 없습니다.");
		}
	}

	private static void deleteWord() {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		
		if(list.remove(new Word(word, ""))) {
			System.out.println("단어가 삭제됐습니다.");
		} else {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
	}

	private static void updateWord() {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		System.out.print("의미 : ");
		String meaning = sc.nextLine();
		
		Word wordObj = new Word(word, meaning);
		int index = list.indexOf(wordObj);
		
		if(index < 0) {
			System.out.println("일치하는 단어가 없습니다.");
			return;
		}
		
		list.set(index, wordObj);
		System.out.println("단어가 수정됐습니다.");
		
	}

	public static void printMenu() {
		System.out.println("------------");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 단어 검색");
		System.out.println("5. 종료");
		System.out.println("------------");
		System.out.print("메뉴 선택 : ");
	}
	
	public static void insertWord() {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		System.out.print("의미 : ");
		String meaning = sc.nextLine();
		Word wordObj = new Word(word, meaning);
		
		if(list.contains(wordObj)) {
			System.out.println("이미 등록된 단어입니다.");
			return;
		} else {
			list.add(wordObj);
			System.out.println("단어를 등록했습니다.");
		}
	}

}

@Data
@AllArgsConstructor
class Word {
	private String word, meaning;

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Word other = (Word) obj;
		return Objects.equals(word, other.word);
	}

	@Override
	public String toString() {
		return word + " : " + meaning;
	}
}
