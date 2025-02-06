package test1;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Test2 {
	public static void main(String[] args) {
		
		Person[] pArr = new Person[3];
		
		pArr[0] = new Person("홍길동");
		pArr[1] = new Person("고길동");
		pArr[2] = new Person("둘리");
		
		for(int i = 0; i < pArr.length; i++) {
			System.out.println(pArr[i].getName());
		}
		
	}
	
}

@Data
@AllArgsConstructor
class Person {
	private String name;
	
	
}