package Elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator extends AbstractElevator implements Runnable{

    protected int numFloors;
    protected int elevatorId;
    protected int currentfloor;
    protected List<ElevatorBarrier> ebList;
    private int maxOccupancy;
    private int peopleinElevator;


    /**
     * Other variables/data structures as needed goes here
     *
     * @param numFloors
     * @param elevatorId
     * @param maxOccupancyThreshold
     */
    public Elevator(int numFloors, int elevatorId, int maxOccupancyThreshold) {
        super(numFloors, elevatorId, maxOccupancyThreshold);
        this.numFloors = numFloors;
        this.elevatorId = elevatorId;
        this.maxOccupancy = maxOccupancyThreshold;
        this.peopleinElevator = 0;
        this.currentfloor = -1;
        this.ebList = new ArrayList<ElevatorBarrier>();
    }

    public List<ElevatorBarrier> getEbList() {
        return ebList;
    }
    
    public void addElevatorBarrier(ElevatorBarrier eb){
    	ebList.add(eb);
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
        currentfloor = floor;
    }

    @Override
    public boolean Enter(int riderId) {
        if (peopleinElevator < maxOccupancy) {
            peopleinElevator++;
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void Exit() {
        peopleinElevator--;
    }

    @Override
    public void RequestFloor(int floor, int riderId, boolean goUp) {

    }
}
