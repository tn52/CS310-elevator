package Elevator;

public class ElevatorControl extends AbstractElevator{

	protected int currentFloor;
    private int peopleInElevator;
    private int maxOccupants;
    protected boolean isTravelingUp;
    protected boolean isDoorOpen;
	
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
    isDoorOpen = true;
		
	}

	@Override
	public void ClosedDoors() {
    isDoorOpen = false;
		
	}

	@Override
	public void VisitFloor(int floor) {
        if (isTravelingUp) {
            Parser.fd.ascendingFloorList.remove(floor);
        } else {
            Parser.fd.descendingFloorList.remove(floor);
        }
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
        System.out.println("Floor " + floor + "requested by rider " + riderId + "from floor " + currentFloor);
        if (floorUp) {
            Parser.fd.ascendingFloorList.add(floor);
        } else {
            Parser.fd.descendingFloorList.add(floor);
        }
        isTravelingUp = floorUp;

    }

    /**
     * Original methods from abstract class. Signatures were changed for implementation, as seen in code above.
     * */
    @Override
    public boolean Enter() {
        return false;
    }

    @Override
    public void RequestFloor(int floor) {

    }

}
