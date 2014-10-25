package Elevator;

import java.util.Queue;

public class Rider implements Runnable{

	protected int riderID;
	protected int sourceFloor;
	protected int destFloor;
	protected int currentFloor;
	protected BuildingControl buildingControl;
	protected Queue<ElevatorControl> elevatorControlQueue;
	protected ElevatorControl assignedElevator;
	protected boolean riderInElevator;
	
	public Rider(BuildingControl bc, Queue<ElevatorControl> ec, int id, int source, int dest){
		buildingControl = bc;
		elevatorControlQueue = ec;
		riderID = id;
		sourceFloor = source;
		destFloor = dest;		
		currentFloor = sourceFloor;
	}
	
	@Override
	public void run() {
		boolean isGoingUp = sourceFloor < destFloor;
		//Rider starts by EITHER calling up or down 
		if(isGoingUp) {
            assignedElevator = (ElevatorControl) buildingControl.CallUp(sourceFloor, riderID);
        } else{
			assignedElevator = (ElevatorControl) buildingControl.CallDown(sourceFloor, riderID);
		}

		riderInElevator = assignedElevator.Enter(riderID);
		assignedElevator.RequestFloor(destFloor, riderID, isGoingUp);
		assignedElevator.Exit();
		
		
		
	}

}
