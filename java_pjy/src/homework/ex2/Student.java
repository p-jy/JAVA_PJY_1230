package homework.ex2;

import lombok.Data;

//getter, setter, toString, equals 등을 제공
@Data
public class Student {
	
	public int grade, classNum, num;
	public String name; //학생이름
	
	public Subject [] list; //학생 개인의 성적을 담고 있는 배열
	
}
