package Elevator;

import java.util.HashSet;
import java.util.Set;

public class Building extends AbstractBuilding {
	
	private int numFloors;
	private int numElevators;
	
	
	private Set<ElevatorBarrier> upBarriers = new HashSet<ElevatorBarrier>();
	private Set<ElevatorBarrier> downBarriers = new HashSet<ElevatorBarrier>();
	private Set<ElevatorBarrier> onBarriers = new HashSet<ElevatorBarrier>();

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
