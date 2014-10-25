package Elevator;

import java.util.HashSet;
import java.util.Set;

public class Building extends AbstractBuilding {
	
	private int numFloors;
	private int numElevators;
	
	
	private Set<ElevatorBarrier> upBarriers = new HashSet<ElevatorBarrier>();
	private Set<ElevatorBarrier> downBarriers = new HashSet<ElevatorBarrier>();

    public Building(int numFloors, int numElevators) {
        super(numFloors, numElevators);
        this.numFloors = numFloors;
        this.numElevators = numElevators;
    }

	/** Called by Rider Threads, returns the elevator that can efficiently serve rider. */
	@Override
	public synchronized AbstractElevator CallUp(int fromFloor, int riderID, ElevatorBarrier eb) {
		upBarriers.add(eb);
		return Parser.ec.returnBestElevator(fromFloor, true, riderID);
    }

	@Override
	public synchronized AbstractElevator CallDown(int fromFloor, int riderID, ElevatorBarrier eb) {
		downBarriers.add(eb);
        return Parser.ec.returnBestElevator(fromFloor, false, riderID);
    }

    public int getNumElevators() {
		return numElevators;
	}
    
    public void removeDownBarrier(ElevatorBarrier eb){
    	downBarriers.remove(eb);
    }
    
    public void removeUpBarrier(ElevatorBarrier eb){
    	upBarriers.remove(eb);
    }

	@Override
	public AbstractElevator CallUp(int fromFloor, int riderID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AbstractElevator CallDown(int fromFloor, int riderID) {
		// TODO Auto-generated method stub
		return null;
	}

}
