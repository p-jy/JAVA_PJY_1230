package day06.score;

//학생 정보를 관리하는 클래스로 학생 정보를 추가, 조회하는 기능을 가짐
public class StudentManager {
	
	private Student [] std = new Student[5];
	private int count = 0;
	
	private void expend() {
		if(std == null) {
			std = new Student[5];
		}
		
		if(count < std.length) {
			return;
		}
		//확장
		Student tmp[] = new Student[std.length + 5];
		System.arraycopy(std, 0, tmp, 0, std.length);
	}
	
	public void insertStudent(String name, int score) {
		std[count++] = new Student(name, score);
		expend();
	}
	
	public void printStudent() {
		if(std[0] == null) {
			System.out.println("등록된 점수가 없습니다.");
		}
		int sum = 0;
		for(int i = 0; i < count; i++) {
			std[i].printStd();
			sum += std[i].getScore();
		}
		System.out.println("평균 : " + sum/(double)count);
		System.out.println();
	}
}
