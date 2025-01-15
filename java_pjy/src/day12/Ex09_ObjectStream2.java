package day12;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

import lombok.AllArgsConstructor;
import lombok.Data;

public class Ex09_ObjectStream2 {
	static Scanner sc = new Scanner(System.in);
	static ArrayList<Car> car = new ArrayList<Car>();
	static String fileName = "src/day12/car_stream.txt";
	
	public static void main(String[] args) {
		/* 다음 기능을 갖는 프로그램을 작성하세요.
		 * 단, 저장기능과 불러오기 기능을 추가
		 * - 저장은 프로그램 종료하기 전
		 * - 불러오기는 프로그램 시작 전
		 * 
		 * 1. 자동차 추가
		 * 2. 자동차 조회(전체)
		 * 3. 종료
		 * 
		 * 힌트: ArrayList 클래스도 Serializable 인터페이스를 구현한 구현 클래스이다.
		 */
		
		
		int menu;
		
		do {
			printMenu();
			menu = sc.nextInt();
			sc.nextLine();
			
			runMenu(menu);
			
			
		}while (menu != 3);
		
	}


	private static void printMenu() {
		System.out.print("1. 자동차 추가\n"
						+ "2. 자동차 조회(전체)\n"
						+ "3. 종료\n"
						+ "메뉴 선택: ");
		
	}
	
	private static void runMenu(int menu) {
		switch(menu) {
		case 1: //자동차 추가
			insertCar();
			
			break;
		case 2: //자동차 조회
			searchCar();
			break;
		case 3:
			System.out.println("프로그램을 종료합니다.");
			break;
		default:
			System.out.println("올바른 메뉴가 아닙니다.");
		}
		
	}


	private static void insertCar() {
		System.out.print("이름 : ");
		String name = sc.nextLine();
		System.out.print("브랜드 : ");
		String brand = sc.nextLine();
		
		try(FileOutputStream fos = new FileOutputStream(fileName);
			ObjectOutputStream oos = new ObjectOutputStream(fos)) {
					
			Car c = new Car(name, brand);
			oos.writeObject(c);
			car.add(c);
			System.out.println("자동차를 등록했습니다.");
					
		} catch (FileNotFoundException e) {
			System.out.println("파일을 열 수 없습니다.");
		} catch (IOException e) {
			System.out.println("IO 예외 발생");
			e.getStackTrace();
		}
		
		
	}
	
	private static void searchCar() {
		
		
		
		try(FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois = new ObjectInputStream(fis)) {
				
			Stream<Car> stream = car.stream();
			AtomicInteger index = new AtomicInteger(1);
			
			Car car = (Car)ois.readObject();
			stream
				.forEach(c -> {
					int num = index.getAndIncrement();
					System.out.println(num + ". " + c);
				});
				
			} catch (IOException e) {
				System.out.println("IO 예외 발생");
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				System.out.println("클래스를 찾을 수 없습니다.");
				e.printStackTrace();
			}
			
	}

}

@Data
@AllArgsConstructor
class Car implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1455289863100321662L;
	
	private String name;
	private String brand;
	@Override
	public String toString() {
		return name + " : " + brand;
	}
	
	
	
}