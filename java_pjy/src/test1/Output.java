package test1;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Output {

	public static void main(String[] args) {
		
		Output op = new Output();
		
		op.output();
	}
	
	public void output() {
		
		FileWriter fw = null;
		
		try {
			
			fw = new FileWriter("src/test1/test.txt", true);
			fw.write(97);
			fw.write(65);
			fw.flush();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
