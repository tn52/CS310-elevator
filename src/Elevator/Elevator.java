package Elevator;

import java.util.ArrayList;

public class Elevator implements Runnable{

	protected int elevatorID;
	//protected ArrayList<ElevatorControl> elevatorControlList;
	protected ElevatorControl elevatorControl;
	
	public Elevator(ElevatorControl ec, int id){
		elevatorID = id;
		elevatorControl = ec;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub

//		while(elevatorControl.currentFloor != ){
//		elevatorControl.VisitFloor();
//	}		
		elevatorControl.VisitFloor(floor);
		elevatorControl.OpenDoors();
		elevatorControl.ClosedDoors();
//		while(){
//			elevatorControl.VisitFloor();
//		}
		elevatorControl.OpenDoors();
		elevatorControl.ClosedDoors();
	}

}
