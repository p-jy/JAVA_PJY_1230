package day08;

import day08.ex02.BenzCar;
import day08.ex02.Car;
import day08.ex02.KiaCar;

public class Ex03_ClassCasting {

	public static void main(String[] args) {
		
		/*
		 * 다양한 자동차를 관리하는 프로그램을 만드는 상황.
		 */
		
		Car [] list = new Car[10];
		
		list[0] = new BenzCar();
		list[1] = new KiaCar();
		
		int count = 2;
		for(int i = 0; i < count; i++) {
			Car tmp = list[i];
			if(tmp instanceof KiaCar) {
				//다운 캐스팅. 강제 클래스 변환
				KiaCar kiatmp = (KiaCar)tmp;
				System.out.println(kiatmp.logo);	
			} else if(tmp instanceof KiaCar) {
				System.out.println(((BenzCar)tmp).logo); //tmp 형변환 > 형변환한 tmp에서 logo
			}
		}
	}

}
