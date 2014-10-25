package Elevator;

public class Building extends AbstractBuilding {
	
	private int numFloors;
	private int numElevators;

    public Building(int numFloors, int numElevators) {
        super(numFloors, numElevators);
        this.numFloors = numFloors;
        this.numElevators = numElevators;
    }

	/** Called by Rider Threads, returns the elevator that can efficiently serve rider. */
	@Override
	public synchronized AbstractElevator CallUp(int fromFloor, int riderID) {
		return Parser.ec.returnBestElevator(fromFloor, true, riderID);
    }

	@Override
	public synchronized AbstractElevator CallDown(int fromFloor, int riderID) {
        return Parser.ec.returnBestElevator(fromFloor, false, riderID);
    }

    public int getNumElevators() {
		return numElevators;
	}

}
