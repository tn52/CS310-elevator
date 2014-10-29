package Elevator;

import java.io.FileNotFoundException;

public class TestElevator {

	public static void main(String[] args) throws FileNotFoundException {
		
		/* Run elevator */
		Parser parser = new Parser();
		parser.parse("InputTest1.txt");
		
	}

}
