package Elevator;

import java.util.ArrayList;
import java.util.Queue;

public class BuildingControl extends AbstractBuilding {
	
	protected int numFloors;
	protected int numElevators;
	protected Queue<Integer> availableElevators;			//contains indexes of currently available elevators
	protected ArrayList<ElevatorControl> ecList;
	
	//Only one instance of BuildingControl (since only 1 building)
	public BuildingControl(int numFloors, int numElevators, ArrayList<ElevatorControl> ecList) {
		super(numFloors, numElevators);
		// TODO Auto-generated constructor stub
		this.numFloors = numFloors;
		this.numElevators = numElevators;
		this.ecList = ecList;
		
		//Add to arraylist the (integer) indexes of all elevators, since at the beginning all elevators are available
//		for(int i=0; i<numElevators; i++){
//			availableElevators.add(i+1);	
//		}
	}


	//Called by Elevator.Rider Threads
	@Override
	public synchronized AbstractElevator CallUp(int fromFloor, int riderID) {
		// TODO Auto-generated method stub

		while(ecList.isEmpty()){		//wait/block if no available elevators
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//elevators available, execute
		System.out.println("R"+riderID+" pushes U"+fromFloor);	
		ElevatorControl temp = ecList.remove(0);
		return temp;			//choose an available elevator from list and return

	}

	@Override
	public synchronized AbstractElevator CallDown(int fromFloor, int riderID) {
		// TODO Auto-generated method stub
		
		while(ecList.isEmpty()){		//wait/block if no available elevators
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		//elevators available, execute
		System.out.println("R"+riderID+" pushes D"+fromFloor);	
		ElevatorControl temp = ecList.remove(0);
		return temp;			//choose an available elevator from list and return
		
	}
	
	
	public int getNumElevators() {
		return numElevators;
	}


	public ArrayList<ElevatorControl> getEcList() {
		return ecList;
	}


}
