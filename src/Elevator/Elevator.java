package Elevator;

public class Elevator implements Runnable{

	protected int elevatorID;
	protected ElevatorControl elevatorControl;
	
	public Elevator(ElevatorControl ec, int id){
		elevatorID = id;
		elevatorControl = ec;
	}
	
	@Override
	public void run() {

//		while(elevatorControl.currentFloor != ){
//		elevatorControl.VisitFloor();
//	}		
//		elevatorControl.VisitFloor(floor);
//		elevatorControl.OpenDoors();
//		elevatorControl.ClosedDoors();
////		while(){
////			elevatorControl.VisitFloor();
////		}
//		elevatorControl.OpenDoors();
//		elevatorControl.ClosedDoors();
	}

}
