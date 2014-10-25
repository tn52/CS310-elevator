package Elevator;

import java.util.Queue;

public class BuildingControl extends AbstractBuilding {
	
	protected int numFloors;
	protected int numElevators;
	
	/* contains indexes of currently available elevators */
	protected Queue<ElevatorControl> ecQueue;
	
	/*Only one instance of BuildingControl (since only 1 building) */
	public BuildingControl(int numFloors, int numElevators, Queue<ElevatorControl> ecQueue) {
		super(numFloors, numElevators);
		
		this.numFloors = numFloors;
		this.numElevators = numElevators;
		this.ecQueue = ecQueue;
	}
	

	/* Called by Rider Threads
	 * Fetches Available Elevator */
	@Override
	public synchronized AbstractElevator CallUp(int fromFloor, int riderID) {
		
		/* wait/block if no available elevators */
		while(ecQueue.isEmpty()){		
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		/* If elevators available, execute
		 * Choose an available elevator from Queue and return*/ 

		System.out.println("R"+riderID+" pushes U"+fromFloor);	
		ElevatorControl temp = ecQueue.remove();
		return temp;			
	}

	@Override
	public synchronized AbstractElevator CallDown(int fromFloor, int riderID) {
		
		while(ecQueue.isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("R"+riderID+" pushes D"+fromFloor);	
		ElevatorControl temp = ecQueue.remove();
		return temp;
		
	}
	
	
	public int getNumElevators() {
		return numElevators;
	}


	public Queue<ElevatorControl> getEcQueue() {
		return ecQueue;
	}
	
	public void addToElevatorQueue(ElevatorControl ec){
		ecQueue.add(ec);
	}


}
