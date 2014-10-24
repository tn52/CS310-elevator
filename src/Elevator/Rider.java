package Elevator;

import java.util.ArrayList;

public class Rider implements Runnable{

	protected int riderID;
	protected int sourceFloor;
	protected int destFloor;
	protected int currentFloor;
	protected BuildingControl buildingControl;
	protected ArrayList<ElevatorControl> elevatorControlList;
	protected ElevatorControl assignedElevatorControl;
	protected boolean riderInElevator;
	
	public Rider(BuildingControl bc, ArrayList<ElevatorControl> ec, int id, int source, int dest){
		buildingControl = bc;
		elevatorControlList = ec;
		riderID = id;
		sourceFloor = source;
		destFloor = dest;		
		currentFloor = sourceFloor;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
		//Rider starts by EITHER calling up or down 
		if(sourceFloor<destFloor){
			assignedElevatorControl = (ElevatorControl) buildingControl.CallUp(sourceFloor, riderID);
		}else{
			assignedElevatorControl = (ElevatorControl) buildingControl.CallDown(sourceFloor, riderID);
		}
		
		riderInElevator = assignedElevatorControl.Enter();
		assignedElevatorControl.RequestFloor(destFloor);
		assignedElevatorControl.Exit();
		
		
		
	}

}
