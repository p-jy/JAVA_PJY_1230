package homework.ex2.v1;

import java.util.List;

import lombok.Data;

//getter, setter, toString, equals 등을 제공
@Data
public class Student {
	
	public int grade, classNum, num;
	public String name; //학생이름
	
	public List<SubjectScore> list; //학생 개인의 성적을 담고 있는 배열
	
	//equals를 오버라이딩. 학년, 반, 번호를 이용.
	
}
