
public class ElevatorController extends AbstractElevator{

	public ElevatorController(int numFloors, int elevatorId,
			int maxOccupancyThreshold) {
		super(numFloors, elevatorId, maxOccupancyThreshold);
		// TODO Auto-generated constructor stub
	}

	
	//Called by Elevator Threads
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

	
	//Called by Rider Threads
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
