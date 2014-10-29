package Elevator;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Elevator extends AbstractElevator implements Runnable{

    protected int numFloors;
    protected int elevatorId;
    protected int currentfloor;
    protected List<ElevatorBarrier> ebList;
    private int maxOccupancy;
    protected Queue<Rider> peopleinElevator;
    boolean[] stopfloorsUP;
    boolean[] stopfloorsDOWN;
    boolean[] stopfloorsOUT; 
    protected Building bc;
    boolean directionUp;
    boolean directionDown;
    
    /**
     * Other variables/data structures as needed goes here
     *
     * @param numFloors
     * @param elevatorId
     * @param maxOccupancyThreshold
     */
    public Elevator(int numFloors, int elevatorId, int maxOccupancyThreshold, Building bc) {
        super(numFloors, elevatorId, maxOccupancyThreshold);
        this.numFloors = numFloors;
        this.elevatorId = elevatorId;
        this.maxOccupancy = maxOccupancyThreshold;
        this.peopleinElevator = new LinkedList<Rider>();
        this.currentfloor = 1;
        this.ebList = new ArrayList<ElevatorBarrier>();
        this.bc = bc;
        stopfloorsOUT = new boolean[numFloors];
        stopfloorsUP = new boolean[numFloors];
        stopfloorsDOWN = new boolean[numFloors];
        directionUp = false;
        directionDown = false;
        
        
        
    }

    public List<ElevatorBarrier> getEbList() {
        return ebList;
    }
    
    public void addElevatorBarrier(ElevatorBarrier eb){
    	ebList.add(eb);
    }


    @Override
	public void run() {
    	boolean goingUp;
    	boolean goingDown;
    	boolean idle;
    	while(true){
    		goingUp = directionUp && !directionDown;
        	goingDown = !directionUp && directionDown;
        	idle = !directionUp && !directionDown;
    		if(stopfloorsUP[currentfloor] && (goingUp || idle)) { //something is happening here
    			OpenDoors();
				ClosedDoors();
				directionUp = true;
				directionDown = false;
				stopfloorsUP[currentfloor] = false;
				stopfloorsDOWN[currentfloor] = false;
				stopfloorsOUT[currentfloor] = false;
    		}
    		else if (stopfloorsDOWN[currentfloor] && (goingDown || idle)) {
    			OpenDoors();
				ClosedDoors();
				directionDown = true;
				directionUp = false;
				stopfloorsUP[currentfloor] = false;
				stopfloorsDOWN[currentfloor] = false;
				stopfloorsOUT[currentfloor] = false;
    		}
    		else if (stopfloorsOUT[currentfloor]) {
    			OpenDoors();
				ClosedDoors();
				stopfloorsUP[currentfloor] = false;
				stopfloorsDOWN[currentfloor] = false;
				stopfloorsOUT[currentfloor] = false;
				if(!this.peopleinElevator.isEmpty()) {
    				Rider rider = this.peopleinElevator.peek();
    				if(rider.destFloor < currentfloor) {
    					directionUp = false;
    					directionDown = true;
    				}
    				else {
    					directionUp = true;
    					directionDown = false;
    				}
				}
				else {
					directionDown = false;
    				directionUp = false;
				}
    		}
    		
    		if(directionUp && !directionDown) {
    			VisitFloor(currentfloor+1);
    		}
    		else if(!directionUp && directionDown) {
    			VisitFloor(currentfloor-1);
    		}
    		else {
    		}
    	}
    }

    @Override
    public void OpenDoors() {
    	System.out.println("Elevator"+this.elevatorId+" on Floor"+currentfloor+" opens");
    	bc.ebListUP.get(currentfloor).raise();
    	bc.ebListOUT.get(currentfloor).raise();
//        bc.ebListDOWN.get(currentfloor).raise();
    	    	
    }

    @Override
    public void ClosedDoors() {
    	System.out.println("Elevator"+this.elevatorId+" on Floor"+currentfloor+" closes");

    }

    @Override
    public synchronized void VisitFloor(int floor) {
        currentfloor = floor;
        System.out.println("Elevator"+this.elevatorId+" moves up/down to Floor"+floor);
    }

    @Override
    public synchronized boolean Enter(Rider rider, int elevatorID, int floor) {
    	
        if (peopleinElevator.size() < maxOccupancy) {
            peopleinElevator.add(rider);
            System.out.println("Rider"+rider.riderID+" enters Elevator"+elevatorID+" on Floor"+floor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized void Exit(Rider rider, int elevatorID, int floor) {
        peopleinElevator.remove(rider);
        System.out.println("Rider"+rider.riderID+" exits Elevator"+elevatorID+" on Floor"+floor);
    }

    @Override
    public synchronized void RequestFloor(int floor, int riderId, boolean goUp) {
    	stopfloorsOUT[floor] = true;
    	System.out.println("Rider"+riderId+" pushes Elevator"+this.elevatorId+" Button"+floor);
    }
}
