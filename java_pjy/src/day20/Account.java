package day20;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class Account implements Serializable {

	private static final long serialVersionUID = 7089426560014944186L;
	
	private Bank bank; //은행
	private String num, name, pw; //계좌번호, 이름, 비밀번호
	private int money; //잔액

	List<Item> list; //입출금 내역 관리

	public Account(Bank bank, String name, String num, String pw) {
		this.bank = bank;
		this.num = num;
		this.name = name;
		this.pw = pw;
	}
	
	
	
}
