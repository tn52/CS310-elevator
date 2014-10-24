package Elevator;

import java.util.ArrayList;
import java.util.Scanner;

public class TestElevator {

	protected static int numFloors;
	protected static int numElevators;
	protected static int numRiders;
	protected static int maxCapacity;
	
	protected static int elevatorID = 1;
	
	protected static ArrayList<ElevatorControl> ecList;
	protected static ArrayList<Rider> riderList;
	
	
	public static void main(String[] input){
		
		Scanner in = new Scanner(System.in);
		
		numFloors = in.nextInt();				//change back to nextInt
		numElevators = in.nextInt();
		numRiders = in.nextInt();
		maxCapacity = in.nextInt();

		
		BuildingControl bc = new BuildingControl(numFloors, numElevators, ecList);
		//N elevator control instances for N elevator threads
		for(int i=0; i<numElevators; i++){
			ElevatorControl ec = new ElevatorControl(numFloors, i+1, maxCapacity);
			ecList.add(ec);	
		}
		
		for(int i=0; i<numRiders; i++){
			Rider r = new Rider(bc, ecList, in.nextInt(), in.nextInt(), in.nextInt());			//change back to nextInt
			riderList.add(r);
			Thread t = new Thread(r);
			t.start();
		}
		
		for(int i=0; i<numElevators; i++){
			Elevator e = new Elevator(ecList.get(i), i);
			Thread t = new Thread(e);
			t.start();	
		}
		
		
	}
	
	
}
