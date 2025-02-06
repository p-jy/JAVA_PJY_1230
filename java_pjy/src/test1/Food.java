package test1;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Food implements Serializable { //직렬화 선언

	private static final long serialVersionUID = 1L;
	
	//String 타입의 name과 int 타입의 kcal 필드를 선언
	private String name;
	private int kcal;
	
	public Food() {
		this.name = name;
		this.kcal = kcal;
	}
	
	public Food(String name, int kcal) {
		this.name = name;
		this.kcal = kcal;
	}
	
	@Override
	public String toString() {
		return name + " : " + kcal + "kcal";
	}
	
	
	public void fileSave(String fileName) {

		File file = new File(fileName);
		
		Food food = new Food("사과", 20);
		

		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file))) {
			
			oos.writeObject(food);
			oos.flush();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
}
