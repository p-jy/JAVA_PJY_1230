package day22;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class WordNoteProgram implements ConsoleProgram {
	
	private Scanner sc = new Scanner(System.in);
	private String id;
	private List<Word> words;
	private Map<String, List<Word>> myWords;
	
	@Override
	public void run() {
		String wordsFileName = "src/day22/words.txt";
		String myWordsFileName = "src/day22/myWords.txt";
		//불러오기
		words = (List<Word>) load(wordsFileName);
		myWords = (Map<String, List<Word>>) load(myWordsFileName);
		
		//불러오기 실패처리
		if(words == null) {
			words = new ArrayList<Word>();
		}
		if(myWords == null) {
			myWords = new HashMap<String, List<Word>>();
		}
		
		
		
		//아이디 입력
		System.out.print("아이디 : ");
		id = sc.next();
		
		if("admin".equals(id)) {
			WordNoteAdminProgram adminProgram = new WordNoteAdminProgram(sc, words);
			adminProgram.run();
		} else {
			WordNoteUserProgram userProgram = new WordNoteUserProgram(sc, words, myWords, id);
			userProgram.run();
		}
		
		//저장하기
		save(wordsFileName, words);
		save(myWordsFileName, myWords);
	}

}
