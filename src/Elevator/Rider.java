package Elevator;

public class Rider implements Runnable{

	protected int riderID;
	protected int startFloor;
	protected int destFloor;
	protected Building bc;
	protected Elevator elevator;
	protected boolean isRiderIn;
	protected ElevatorBarrier eb;
	
	public Rider(Building bc, int id, int start, int dest){
		this.bc = bc;
		this.riderID = id;
		this.startFloor = start;
		this.destFloor = dest;
	}
	
	@Override
	public void run() {
		boolean isGoingUp = startFloor < destFloor;

		if(isGoingUp) {
			eb = bc.ebListUP.get(startFloor);							//get event barrier on the rider's start floor
            elevator = (Elevator) bc.CallUp(startFloor, riderID, eb);	//CALLUP and return elevator from scheduling algorithm
            
            eb.arrive();												//ARRIVE and wait at barrier

            if (isRiderIn = elevator.Enter(riderID, elevator.elevatorId, startFloor)) {	//if elevator not full and possible to ENTER
            	
//            	bc.removeUpBarrier(eb);
//            	elevator.addElevatorBarrier(eb);
            	
            	eb.complete();
                elevator.RequestFloor(destFloor, riderID, isGoingUp);
                eb = bc.ebListOUT.get(destFloor);
                eb.arrive();
                elevator.Exit(riderID, elevator.elevatorId, destFloor);
                eb.complete();
            }
        } else{
//			elevator = (Elevator) bc.CallDown(startFloor, riderID, eb);
//			eb.arrive();
//			
//	        if (isRiderIn = elevator.Enter(riderID)) {
//	        	
//            	bc.removeDownBarrier(eb);
//            	
//            	elevator.addElevatorBarrier(eb);
//	            elevator.RequestFloor(destFloor, riderID, isGoingUp);
//	            elevator.Exit();
//	        }
		}

		
		
		
		
	}

}
