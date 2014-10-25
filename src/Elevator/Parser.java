package Elevator;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Scanner;

public class Parser {

	protected int numFloors;
	protected int numElevators;
	protected int numRiders;
	protected int maxCapacity;
    public static FloorData fd;
	
	protected Queue<ElevatorControl> ecQueue;
	protected ArrayList<Rider> riderList;
	private Scanner input;
	private Scanner lineScanner;
	
	public Parser(){
		riderList = new ArrayList<Rider>();
        fd = new FloorData();
	}
	
	public void parse(String filename) throws FileNotFoundException{

		input = new Scanner(new FileReader(filename));
		
		numFloors = input.nextInt();
		numElevators = input.nextInt();
		numRiders = input.nextInt();
		maxCapacity = input.nextInt();


		for(int i = 0; i < numElevators; i++){
			ElevatorControl ec = new ElevatorControl(numFloors, i+1, maxCapacity);
			ecQueue.add(ec);	
		}

		BuildingControl bc = new BuildingControl(numFloors, numElevators, ecQueue);
		
		/* Benson: Replaced number of riders with number of requests.
		 * There can be fewer request than the number of riders */
		for(int i = 0; i < findNumLines(filename); i++){
			Rider r = new Rider(bc, ecQueue, input.nextInt(), input.nextInt(), input.nextInt());
			riderList.add(r);
			Thread t = new Thread(r);
			t.start();
		}
		
		for(int i = 0; i < numElevators; i++){
            if (ecQueue!=null) {
                Elevator e = new Elevator(ecQueue.poll());
                Thread t = new Thread(e);
                t.start();
            }
		}

	}

	public ArrayList<Rider> getRiderList() {
		return riderList;
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
	
	private int findNumLines(String filename) throws FileNotFoundException{
		lineScanner = new Scanner(new FileReader(filename));
		/* Benson: lineCounter starts at -1 because we aren't considering first line in text file */
		int lineCounter = -1;
		while(lineScanner.hasNextLine()){
			lineCounter++;
			lineScanner.nextLine();
		}
		return lineCounter;
	}
	
	
}
