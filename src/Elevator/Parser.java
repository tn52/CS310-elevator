package Elevator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Parser {

	private int numFloors;
	private int numElevators;
	private int numRiders;
	private int maxCapacity;

    public static ElevatorControl ec;
    public static Building bc;

    protected ArrayList<Elevator> mElevatorList;
	protected ArrayList<Rider> riderList;

	
	public Parser(){
		riderList = new ArrayList<Rider>();
        mElevatorList = new ArrayList<Elevator>();
	}

    public ArrayList<Rider> getRiderList() {
        return riderList;
    }
	
	public void parse(String filename) throws FileNotFoundException{

		Scanner input = new Scanner(new FileReader(filename));
		
		numFloors = input.nextInt();
		numElevators = input.nextInt();
		numRiders = input.nextInt();
		maxCapacity = input.nextInt();

		for(int i = 0; i < numElevators; i++){
			Elevator elevator = new Elevator(numFloors, i+1, maxCapacity);
            mElevatorList.add(elevator);
		}

        ec = new ElevatorControl(mElevatorList);
        bc = new Building(numFloors, numElevators);
		
		/* Benson: Replaced number of riders with number of requests.
		 * There can be fewer request than the number of riders */
		for(int i = 0; i < findNumLines(filename); i++){
			Rider r = new Rider(bc, input.nextInt(), input.nextInt(), input.nextInt());
			riderList.add(r);
			Thread t = new Thread(r);
			t.start();
		}
//
//		for(int i = 0; i < numElevators; i++){
//            if (ecQueue!=null) {
//                Elevator e = new Elevator(ecQueue.poll());
//                Thread t = new Thread(e);
//                t.start();
//            }
//		}

	}
	
	private int findNumLines(String filename) throws FileNotFoundException{
		Scanner lineScanner = new Scanner(new FileReader(filename));
		/* Benson: lineCounter starts at -1 because we aren't considering first line in text file */
		int lineCounter = -1;
		while(lineScanner.hasNextLine()){
			lineCounter++;
			lineScanner.nextLine();
		}
		return lineCounter;
	}

    public void testParser(){
        System.out.println("Number of Elevators: " + numElevators);
        System.out.println("Max Capacity per Elevator: " + maxCapacity);
        System.out.println("Number of Floors: " + numFloors);
        System.out.println("Number of Riders: " + numRiders);
        for(Rider r : riderList){
            System.out.println("Rider " + r.riderID + ": " + "Starts from floor " + r.startFloor + " And ends at floor " + r.destFloor);
        }
    }
	
	
}
