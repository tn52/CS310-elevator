package Elevator;

import java.util.ArrayList;
import java.util.List;

public class Elevator extends AbstractElevator implements Runnable{

    protected int numFloors;
    protected int elevatorId;
    protected int currentfloor;
    protected List<ElevatorBarrier> ebList;
    private int maxOccupancy;
    protected int peopleinElevator;
    boolean[] stopfloorsUP;
    boolean[] stopfloorsDOWN;
    boolean[] stopfloorsOUT; 
    protected Building bc;
    boolean hasFinished = false;
    
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
        this.peopleinElevator = 0;
        this.currentfloor = 0;
        this.ebList = new ArrayList<ElevatorBarrier>();
        this.bc = bc;
        stopfloorsOUT = new boolean[numFloors];
        stopfloorsUP = new boolean[numFloors];
        stopfloorsDOWN = new boolean[numFloors];
        
    }

    public List<ElevatorBarrier> getEbList() {
        return ebList;
    }
    
    public void addElevatorBarrier(ElevatorBarrier eb){
    	ebList.add(eb);
    }


    @Override
	public void run() {

    	while(true){
    		

//	    	 if(bc.ebListUP.get(currentfloor).numWaiters>0 || bc.ebListOUT.get(currentfloor).numWaiters>0){
    		if(stopfloorsUP[currentfloor] || stopfloorsOUT[currentfloor]){
	    		if(!hasFinished){
	    		OpenDoors();
	    		ClosedDoors();
	    		VisitFloor(currentfloor+1);
	    		}
	    	}else{
	    		if(!hasFinished) VisitFloor(currentfloor+1);
	    	}
    	}
    	
    	
    	
    }

    @Override
    public void OpenDoors() {
    	System.out.println("Elevator"+this.elevatorId+" on Floor"+currentfloor+" opens");
    	bc.ebListUP.get(currentfloor).raise();
    	bc.ebListOUT.get(currentfloor).raise();
    	    	
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
    public synchronized boolean Enter(int riderId, int elevatorID, int floor) {
    	
        if (peopleinElevator < maxOccupancy) {
            peopleinElevator++;
            System.out.println("Rider"+riderId+" enters Elevator"+elevatorID+" on Floor"+floor);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public synchronized void Exit(int riderId, int elevatorID, int floor) {
        peopleinElevator--;
        if(peopleinElevator == 0) hasFinished = true;
        System.out.println("Rider"+riderId+" exits Elevator"+elevatorID+" on Floor"+floor);
    }

    @Override
    public synchronized void RequestFloor(int floor, int riderId, boolean goUp) {
    	stopfloorsOUT[floor] = true;
    	System.out.println("Rider"+riderId+" pushes Elevator"+this.elevatorId+" Button"+floor);
    }
}
