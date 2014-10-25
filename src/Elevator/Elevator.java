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

//        while(elevatorControl.currentFloor!=)
//		while(elevatorControl.currentFloor != ){
//		elevatorControl.VisitFloor();
//	}		
//		elevatorControl.VisitFloor(floor);
//		elevatorControl.OpenDoors();
        // rider enters, and requests a floor
//		elevatorControl.ClosedDoors();
////		while(){
////			elevatorControl.VisitFloor();
////		}
//		elevatorControl.OpenDoors();
        // rider exits, and other riders (if they exist) may enter elevator
//		elevatorControl.ClosedDoors();
	}

}
