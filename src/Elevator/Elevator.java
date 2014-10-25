package Elevator;

public class Elevator implements Runnable{

	protected int elevatorID;
	protected ElevatorControl elevatorControl;
	
	public Elevator(ElevatorControl ec){
		elevatorID = ec.elevatorId;
		elevatorControl = ec;
	}
	
	@Override
	public void run() {

        // is elevator going up or down?
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
