package Elevator;

import java.util.Queue;

public class Rider implements Runnable{

	protected int riderID;
	protected int startFloor;
	protected int destFloor;
	protected int currentFloor;
	protected BuildingControl bc;
	protected Queue<ElevatorControl> ecQueue;
	protected ElevatorControl assignedElevator;
	protected boolean isRiderIn;
	
	public Rider(BuildingControl bc, Queue<ElevatorControl> ec, int id, int source, int dest){
		this.bc = bc;
		ecQueue = ec;
		riderID = id;
		startFloor = source;
		destFloor = dest;		
		currentFloor = startFloor;
	}
	
	@Override
	public void run() {
		boolean isGoingUp = startFloor < destFloor;
		//Rider starts by EITHER calling up or down 
		if(isGoingUp) {
            assignedElevator = (ElevatorControl) bc.CallUp(startFloor, riderID);
        } else{
			assignedElevator = (ElevatorControl) bc.CallDown(startFloor, riderID);
		}

        assignedElevator.currentFloor = startFloor;
        if (isRiderIn = assignedElevator.Enter(riderID)) {
            assignedElevator.RequestFloor(destFloor, riderID, isGoingUp);
            assignedElevator.Exit();
        }
		
		
	}

}
