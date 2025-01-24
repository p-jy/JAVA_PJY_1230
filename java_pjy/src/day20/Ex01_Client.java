package day20;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ex01_Client {
	
	/* 은행 계좌 관리 프로그램
	 * - 접속
	 * 	- 은행, 이름, 계좌번호, 비밀번호
	 * - 계좌 개설
	 * 	- 은행, 이름, 계좌번호, 비밀번호, 비밀번호 확인
	 * - 종료
	 * 
	 * 	- 예금 조회
	 * 	- 입금
	 * 	- 출금
	 * 	- 이전
	 * *주의*
	 * - 한 계좌에 여러명이 동시에 접근하는 경우 > 먼저 접근한 사람이 사용하도록 처리
	 */
	
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//서버와 소켓으로 연결 : 실패 시 프로그램 종료
		Socket socket = null;
		
		
		//프로그램 구현
		ClientProgram program = new ClientProgram(socket);
		program.run();
		
	}
	
}