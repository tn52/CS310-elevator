package Elevator;

public class Elevator extends AbstractElevator implements Runnable{

	protected int elevatorID;
	protected ElevatorControl ec;
	
//	public Elevator(ElevatorControl elevatorControl){
//		elevatorID = elevatorControl.elevatorId;
//		ec = elevatorControl;
//	}

    /**
     * Other variables/data structures as needed goes here
     *
     * @param numFloors
     * @param elevatorId
     * @param maxOccupancyThreshold
     */
    public Elevator(int numFloors, int elevatorId, int maxOccupancyThreshold) {
        super(numFloors, elevatorId, maxOccupancyThreshold);
    }

    @Override
	public void run() {

//        if (ec.isTravelingUp) {
//            ec.VisitFloor(Parser.fd.ascendingFloorList.first());
//        } else {
//            ec.VisitFloor(Parser.fd.descendingFloorList.first());
//        }
//
//        ec.OpenDoors();
//        ec.ClosedDoors();

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

    @Override
    public void OpenDoors() {

    }

    @Override
    public void ClosedDoors() {

    }

    @Override
    public void VisitFloor(int floor) {

    }

    @Override
    public boolean Enter(int riderId) {
        return false;
    }

    @Override
    public void Exit() {

    }

    @Override
    public void RequestFloor(int floor, int riderId, boolean goUp) {

    }
}
