package Elevator;

import java.util.TreeSet;

public class ElevatorControl extends AbstractElevator{

	protected int currentFloor;
    protected int peopleInElevator;
    protected int maxOccupants;
    protected TreeSet<Integer> ascendingFloorList;
    protected TreeSet<Integer> descendingFloorList;
	
	public ElevatorControl(int numFloors, int elevatorId,
                           int maxOccupancyThreshold) {
		super(numFloors, elevatorId, maxOccupancyThreshold);
		currentFloor = 1;
        maxOccupants = maxOccupancyThreshold;
        peopleInElevator = 0;

	}

	
	//Called by Elevator.Elevator Threads
	@Override
	public void OpenDoors() {

		
	}

	@Override
	public void ClosedDoors() {

		
	}

	@Override
	public void VisitFloor(int floor) {
		currentFloor = floor;
	}

    //Called by Elevator.Rider Threads
	public boolean Enter(int riderId) {
        if (peopleInElevator == maxOccupants) {
            System.out.println("Elevator at full capacity, rider " + riderId + "cannot enter.");
            return false;
        } else {
            peopleInElevator++;
            System.out.println("Rider " + riderId + "has entered elevator.");
            return true;
        }
    }

	@Override
	public void Exit() {
        peopleInElevator--;
		
	}

	public void RequestFloor(int floor, int riderId, boolean floorUp) {
        System.out.println("Floor "+floor+"requested by rider " + riderId);
        if (floorUp) {
            ascendingFloorList.add(floor);
        } else {
            descendingFloorList.add(floor);
        }

    }

    @Override
    public boolean Enter() {
        return false;
    }

    @Override
    public void RequestFloor(int floor) {

    }

}
