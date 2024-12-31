package day02;

public class Ex08_IfGrade {

	public static void main(String[] args) {
		/* 
		 * 정수 성적이 주어지면 주어진 성적에 맞는 학점을 출력하는 코드를 작성하세요.
		 * A: 90~100
		 * B: 80~89
		 * C: 70~79
		 * D: 60~69
		 * F: 0~59
		 * 잘못된 점수: 0보다 작거나 100보다 큰 경우
		 */
		
		// 잘못된 점수를 먼저 처리하면 조건식 간결하게 가능.
		int score = 105;
		
		if(score >= 90 && score <= 100) {
			System.out.println(score + "점은 A입니다.");
		} else if(score >=80 && score < 90) {
			System.out.println(score + "점은 B입니다.");
		} else if(score >= 70 && score < 80) {
			System.out.println(score + "점은 C입니다.");
		} else if(score >= 60 && score < 70) {
			System.out.println(score + "점은 D입니다.");
		} else if(score >= 0 && score < 60) {
			System.out.println(score + "점은 F입니다.");
		} else {
			System.out.println("잘못된 점수입니다.");
		}
		
	}

}
