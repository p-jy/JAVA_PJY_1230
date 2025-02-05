package day23;

public class Ex17_Thread {

	public static void main(String[] args) {
		
		/* 스레드를 이용하여 +를 100번 출력하는 스레드를 생성해서 실행하고,
		 * -를 100번 출력하는 스레드를 생성해서 실행하는 코드를 작성하세요. */
		
		Thread t1 = new Thread1();
		t1.start();
		Thread t2 = new Thread(new Thread2());
		t2.start();
		
		Thread t3 = new Thread(()-> {
			for(int i = 0; i < 100; i++) {
				System.out.print("=");
			}
		});
		t3.start();
	}

}

class Thread1 extends Thread {
	
	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.print("+");
		}
	}
}

class Thread2 implements Runnable {

	@Override
	public void run() {
		for(int i = 0; i < 100; i++) {
			System.out.print("-");
		}
	}
	
}
