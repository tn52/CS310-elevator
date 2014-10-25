package Elevator;

public class ElevatorControl extends AbstractElevator{

	protected int currentFloor;
    protected int peopleInElevator;
    protected int maxOccupants;
	
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
	@Override
	public boolean Enter() {
        if (peopleInElevator == maxOccupants) {
            return false;
        } else {
            peopleInElevator++;
            return true;
        }
    }

	@Override
	public void Exit() {
        peopleInElevator--;
		
	}

	@Override
	public void RequestFloor(int floor) {

		
	}

}
