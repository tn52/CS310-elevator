package Elevator;

public class Rider implements Runnable{

	protected int riderID;
	protected int startFloor;
	protected int destFloor;
	protected Building bc;
	protected Elevator elevator;
	protected boolean isRiderIn;
	protected EventBarrier eb;
	
	public Rider(Building bc, EventBarrier eb, int id, int start, int dest){
		this.bc = bc;
		this.eb = eb;
		this.riderID = id;
		this.startFloor = start;
		this.destFloor = dest;
	}
	
	@Override
	public void run() {
		boolean isGoingUp = startFloor < destFloor;

		if(isGoingUp) {
            elevator = (Elevator) bc.CallUp(startFloor, riderID);
        } else{
			elevator = (Elevator) bc.CallDown(startFloor, riderID);
		}

        if (isRiderIn = elevator.Enter(riderID)) {
            elevator.RequestFloor(destFloor, riderID, isGoingUp);
            elevator.Exit();
        }
		
		
	}

}
