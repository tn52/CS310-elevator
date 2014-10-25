package Elevator;

public class ElevatorControl extends AbstractElevator{

	protected int currentFloor;
	
	public ElevatorControl(int numFloors, int elevatorId,
                           int maxOccupancyThreshold) {
		super(numFloors, elevatorId, maxOccupancyThreshold);

		currentFloor = 1;
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

		
	}

	
	//Called by Elevator.Rider Threads
	@Override
	public boolean Enter() {

		return false;
	}

	@Override
	public void Exit() {

		
	}

	@Override
	public void RequestFloor(int floor) {

		
	}

}
