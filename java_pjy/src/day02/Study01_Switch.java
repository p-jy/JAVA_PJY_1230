package day02;

public class Study01_Switch {

	public static void main(String[] args) {
		/* 
		 * 5층 건물이 있습니다. 1층 약국, 2층 정형외과, 3층 피부과, 4층 치과, 5층 헬스 클럽입니다.
		 * 건물의 층을 누르면 그 층이 어떤 곳인지 알려 주는 엘리베이터가 있다고 할 때 switch-case문으로 구현해보세요.
		 * (예: 5인 경우, 5층 헬스 클럽입니다.)
		 */

		int num = 2;
		
		switch(num) {
		case 1:
			System.out.println("1층 약국입니다.");
			break;
		case 2:
			System.out.println("2층 정형외과입니다.");
			break;
		case 3:
			System.out.println("3층 피부과입니다.");
			break;
		case 4:
			System.out.println("4층 치과입니다.");
			break;
		case 5:
			System.out.println("5층 헬스 클럽입니다.");
			break;
		default:
			System.out.println("잘 못 입력하셨습니다.");
		}
	}

}
