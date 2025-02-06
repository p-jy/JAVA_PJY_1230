package test1;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;

public class MyCollection {

	public static void main(String[] args) {
		MyCollection mc = new MyCollection();
		mc.test();
	}

	public void test() {
		ArrayList<Fruit> list = new ArrayList<Fruit>();
		
		list.add(new Fruit("사과", "빨강"));
		list.add(new Fruit("메론", "초록"));
		list.add(new Fruit("포도", "보라"));
//		list.add("맛있는 과일");
		
		for(int i = 0; i <= list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		
	}
	
}

@Data
@AllArgsConstructor
class Fruit {
	private String name;
	private String color;
}
