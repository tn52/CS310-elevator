package Elevator;

public class Elevator implements Runnable{

	protected int elevatorID;
	protected ElevatorControl ec;
	
	public Elevator(ElevatorControl elevatorControl){
		elevatorID = elevatorControl.elevatorId;
		ec = elevatorControl;
	}
	
	@Override
	public void run() {

        if (ec.isTravelingUp) {
            ec.VisitFloor(Parser.fd.ascendingFloorList.first());
        } else {
            ec.VisitFloor(Parser.fd.descendingFloorList.first());
        }

        ec.OpenDoors();
        ec.ClosedDoors();
        
        // is elevator going up or down?
//        while(ec.currentFloor!=)
//		while(ec.currentFloor != ){
//		ec.VisitFloor();
//	}		
//		ec.VisitFloor(floor);
//		ec.OpenDoors();
        // rider enters, and requests a floor
//		ec.ClosedDoors();
////		while(){
////			ec.VisitFloor();
////		}
//		ec.OpenDoors();
        // rider exits, and other riders (if they exist) may enter elevator
//		ec.ClosedDoors();
    }

}
