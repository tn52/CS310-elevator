package Elevator;

public class Rider implements Runnable{

	protected int riderID;
	protected int startFloor;
	protected int destFloor;
	protected Building bc;
	protected Elevator elevator;
	protected boolean isRiderIn;
	protected ElevatorBarrier eb;
	
	public Rider(Building bc, ElevatorBarrier eb, int id, int start, int dest){
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
            elevator = (Elevator) bc.CallUp(startFloor, riderID, eb);
            eb.arrive();
            
            if (isRiderIn = elevator.Enter(riderID)) {
            	
            	bc.removeUpBarrier(eb);
            	
            	elevator.addElevatorBarrier(eb);
                elevator.RequestFloor(destFloor, riderID, isGoingUp);
                elevator.Exit();
            }
        } else{
			elevator = (Elevator) bc.CallDown(startFloor, riderID, eb);
			eb.arrive();
			
	        if (isRiderIn = elevator.Enter(riderID)) {
	        	
            	bc.removeDownBarrier(eb);
            	
            	elevator.addElevatorBarrier(eb);
	            elevator.RequestFloor(destFloor, riderID, isGoingUp);
	            elevator.Exit();
	        }
		}

		
		
	}

}
