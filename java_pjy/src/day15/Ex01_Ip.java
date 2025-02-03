package day15;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class Ex01_Ip {

	public static void main(String[] args) {
		//InetAddress 클래스 예제
		
		/* localhost : 내부 아이피 주소에 지정된 이름
		 * 
		 */
		try {
			InetAddress address = InetAddress.getByName("localhost");
			System.out.println(address);
			
			address = InetAddress.getByName("www.naver.com");
			System.out.println(address);
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
