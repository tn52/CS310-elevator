package Elevator;

public class ElevatorControl extends AbstractElevator{

	protected int currentFloor;
	
	public ElevatorControl(int numFloors, int elevatorId,
                           int maxOccupancyThreshold) {
		super(numFloors, elevatorId, maxOccupancyThreshold);
		// TODO Auto-generated constructor stub
		currentFloor = 1;
	}

	
	//Called by Elevator.Elevator Threads
	@Override
	public void OpenDoors() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void ClosedDoors() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void VisitFloor(int floor) {
		// TODO Auto-generated method stub
		
	}

	
	//Called by Elevator.Rider Threads
	@Override
	public boolean Enter() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void Exit() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void RequestFloor(int floor) {
		// TODO Auto-generated method stub
		
	}

}
