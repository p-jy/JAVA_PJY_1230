package day21;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex02_Main{

	/* 단어장 프로그램을 구현하세요.
	 * - 관리자
	 * 	- 단어 등록
	 * 	- 단어 수정
	 * 	- 단어 삭제
	 * - 사용자
	 * 	- 단어 검색
	 * 	- 내 검색 단어 보기
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
	
	static Scanner sc = new Scanner(System.in);
	static List<User> users = new ArrayList<User>();
	static List<Word> list = new ArrayList<Word>();
	
	public static void main(String[] args) {
		String fileName1 = "src/day21/word.txt";
		String fileName2 = "src/day21/user.txt";
		
		list = (List<Word>) load(fileName1);
		users = (List<User>) load(fileName2);
		
		if(list == null || list.size() == 0) {
			list = new ArrayList<Word>();
		}
		if(users == null || users.size() == 0) {
			users = new ArrayList<User>();
		}
		
		//아이디 입력 받음
		System.out.print("아이디 : ");
		String id = sc.next();
		int menu;
		
		//입력받은 아이디가 admin -> 관리자 메뉴 출력
		if(id.equals("admin")) {
			do {
				printAdminMenu();
				menu = sc.nextInt();
				sc.nextLine();
				
				runAdminMenu(menu);
				
				
			} while (menu != 4);

			save(fileName1, list);
			save(fileName2, users);
		}
		//입력받은 아이디가 admin이 아님 -> 사용자 메뉴 출력
		else {
			do {
				User user = new User(id);
				
				printUserMenu();
				menu = sc.nextInt();
				sc.nextLine();
				
				runUserMenu(menu, id);
				
				
			} while(menu != 3);

			save(fileName1, list);
			save(fileName2, users);
		}
	}
	
	private static void save(String fileName, Object obj) {
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
			oos.writeObject(list);
					
		} catch (Exception e) {
			System.out.println("-------------");
			System.out.println("저장하기 실패");
			System.out.println("-------------");
			e.printStackTrace();
		}
		
	}
	private static Object load(String fileName) {
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
			
			return ois.readObject();
			
		} catch (Exception e) {
			System.out.println("-------------");
			System.out.println("불러오기 실패");
			System.out.println("-------------");
		}
		
		return null;
	}

	private static void printAdminMenu() {
		System.out.println("-----------");
		System.out.println("[관리자 메뉴]");
		System.out.println("1. 단어 등록");
		System.out.println("2. 단어 수정");
		System.out.println("3. 단어 삭제");
		System.out.println("4. 종료");
		System.out.println("-----------");
		System.out.print("메뉴 입력 : ");
	}

	private static void printUserMenu() {
		System.out.println("----------------");
		System.out.println("[사용자 메뉴]");
		System.out.println("1. 단어 검색");
		System.out.println("2. 내 검색 단어 보기");
		System.out.println("3. 종료");
		System.out.println("----------------");
		System.out.print("메뉴 입력 : ");
	}

	private static void runAdminMenu(int menu) {
		switch(menu) {
		case 1:
			insertWord();
			break;
		case 2:
			updateWord();
			break;
		case 3:
			deleteWord();
			break;
		case 4:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[올바른 메뉴가 아닙니다.]");
		}
	}

	private static void insertWord() {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		System.out.print("품사 : ");
		String partOfSpeech = sc.next();
		sc.nextLine();
		System.out.print("의미 : ");
		String meaning = sc.nextLine();
		
		list.add(new Word(word, partOfSpeech, meaning));
		System.out.println("단어를 등록했습니다.");
	}

	private static void updateWord() {
		System.out.print("수정할 단어 : ");
		String word = sc.nextLine();
		
		ArrayList<Word> wList = searchWordList(word);
		if(!printWordList(wList, true)) {
			return;
		}
		
		System.out.print("수정할 단어 선택 : ");
		int index = sc.nextInt() - 1;
		sc.nextLine();
		
		Word w = wList.get(index);
		
		System.out.print("단어 : ");
		word = sc.nextLine();
		System.out.print("품사 : ");
		String partOfSpeech = sc.next();
		sc.nextLine();
		System.out.print("의미 : ");
		String meaning = sc.nextLine();
		
		w.update(word, partOfSpeech, meaning);
		System.out.println("[수정이 완료됐습니다.]");
		
	}

	private static void deleteWord() {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		
		ArrayList<Word> wList = searchWordList(word);
		if(!printWordList(wList, true)) {
			return;
		}
		
		System.out.print("수정할 단어 선택 : ");
		int index = sc.nextInt() - 1;
		sc.nextLine();
		
		Word w = wList.get(index);
		
		if(list.remove(w)) {
			System.out.println("[단어가 삭제됐습니다.]");
		} else {
			System.out.println("[잘못 선택하였습니다.]");
		}
	}

	private static ArrayList<Word> searchWordList(String word) {
		ArrayList<Word> tmpList = new ArrayList<Word>();
		
		for(Word tmp : list) {
			if(tmp.getWord().contains(word)) {
				tmpList.add(tmp);
			}
		}
		
		return tmpList;
	}

	private static void runUserMenu(int menu, String id) {
		switch(menu) {
		case 1:
			searchWord(id);
			break;
		case 2:
			viewUserWord(id);
			break;
		case 3:
			System.out.println("[프로그램을 종료합니다.]");
			break;
		default:
			System.out.println("[올바른 메뉴가 아닙니다.]");
		}
	}

	private static void searchWord(String id) {
		System.out.print("단어 : ");
		String word = sc.nextLine();
		
		ArrayList<Word> wList = searchWordList(id, word);
		printWordList(wList, false);
		
		
		
	}

	private static ArrayList<Word> searchWordList(String id, String word) {
		
		ArrayList<Word> tmpList = new ArrayList<Word>();
		
		for(Word tmp : list) {
			if(tmp.getWord().contains(word)) {
				tmpList.add(tmp);
			}
		}
		
		User user = users.get(users.indexOf(new User(id)));
		user.addWord(id, word);
		
		return tmpList;
	}

	private static boolean printWordList(ArrayList<Word> wList, boolean isWord) {
		if(wList == null || wList.size() == 0) {
			System.out.println("[검색 결과가 없습니다.]");
			return false;
		}
		for(int i = 0; i < wList.size(); i++) {
			if(isWord) {
				System.out.print(i + 1 + ". ");
			}
			System.out.println(wList.get(i));
		}
		return true;
	}

	private static void viewUserWord(String id) {
		User user = users.get(users.indexOf(new User(id)));
		
		
	}

}
