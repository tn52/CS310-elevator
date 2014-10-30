package Elevator;

import java.util.logging.FileHandler;
import java.util.logging.Logger;

public class TestElevator {

    public static Logger logger;

	public static void main(String[] args) throws Exception {

        boolean append = true;
        FileHandler handler = new FileHandler("Elevator.log", append);
        logger = Logger.getLogger("cs310.fall14.elevator");
        logger.addHandler(handler);
		/* Run elevator */
		Parser parser = new Parser();
		parser.parse("ElevatorInputFile.txt");


    }

}
