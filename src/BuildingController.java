
public class BuildingController extends AbstractBuilding {

	public BuildingController(int numFloors, int numElevators) {
		super(numFloors, numElevators);
		// TODO Auto-generated constructor stub
	}

	
	//Called by Rider Threads
	@Override
	public AbstractElevator CallUp(int fromFloor) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractElevator CallDown(int fromFloor) {
		// TODO Auto-generated method stub
		return null;
	}

}
