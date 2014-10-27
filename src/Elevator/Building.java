package Elevator;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Building extends AbstractBuilding {
	
	private int numFloors;
	private int numElevators;
	
	ArrayList<ElevatorBarrier> ebListOUT = new ArrayList<ElevatorBarrier>();
	ArrayList<ElevatorBarrier> ebListUP = new ArrayList<ElevatorBarrier>();
	ArrayList<ElevatorBarrier> ebListDOWN = new ArrayList<ElevatorBarrier>();
	
	private Set<ElevatorBarrier> upBarriers = new HashSet<ElevatorBarrier>();
	private Set<ElevatorBarrier> downBarriers = new HashSet<ElevatorBarrier>();

    public Building(int numFloors, int numElevators, ArrayList<ElevatorBarrier> ebListOUT , ArrayList<ElevatorBarrier> ebListUP , ArrayList<ElevatorBarrier> ebListDOWN) {
        super(numFloors, numElevators);
        this.numFloors = numFloors;
        this.numElevators = numElevators;
        this.ebListOUT = ebListOUT;
        this.ebListUP = ebListUP;
        this.ebListDOWN = ebListDOWN;
    }

	/** Called by Rider Threads, returns the elevator that can efficiently serve rider. */
	@Override
	public synchronized AbstractElevator CallUp(int fromFloor, int riderID, ElevatorBarrier eb) {
		//upBarriers.add(eb);
		System.out.println("Rider"+riderID+" pushes UP "+fromFloor);
		Elevator tempElevator = Parser.ec.returnBestElevator(fromFloor, true, riderID);
		
		//Elevator tempElevator = new Elevator(numFloors, 1, 100, this);
		tempElevator.stopfloorsUP[fromFloor] = true;
//        Thread t = new Thread(tempElevator);
//        t.start();
		
		System.out.println(fromFloor +" "+ tempElevator.stopfloorsUP[fromFloor] + " " + tempElevator.elevatorId);
		return tempElevator;
    }

	@Override
	public synchronized AbstractElevator CallDown(int fromFloor, int riderID, ElevatorBarrier eb) {
		//downBarriers.add(eb);
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
