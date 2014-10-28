package Elevator;

import java.util.*;

public class ElevatorControl {

    private Queue<Elevator> mElevatorQueue;
    private Building bc;
    
    public ElevatorControl(Queue<Elevator> mElevatorQueue, Building bc) {
        this.mElevatorQueue = mElevatorQueue;
        this.bc = bc;
    }


    public Elevator returnBestElevator(int fromFloor, boolean goUp, int riderID) {

        Elevator elevator = mElevatorQueue.poll();
        if (elevator.peopleinElevator.size() == 0) {
            mElevatorQueue.add(elevator);
            return elevator;
        } else if (elevator.peopleinElevator.size() == elevator.maxOccupancyThreshold) {
            mElevatorQueue.add(elevator);
            returnBestElevator(fromFloor, goUp, riderID);
        } else {
            if (goUp) {
                spaceAvailableElevatorsUp(elevator, mElevatorQueue, fromFloor);
            } else {
                spaceAvailableElevatorsDown(elevator, mElevatorQueue, fromFloor);
            }
        }

        return null;
    }

    private Elevator spaceAvailableElevatorsUp(Elevator elevator, Queue<Elevator> elevatorQueue, int fromFloor) {
        boolean elevatorExists = false;

        for (int j = fromFloor+1; j < bc.ebListOUT.size(); j++) {
            if (elevator.stopfloorsOUT[j]) {
                elevatorExists = true;
                break;
            }
        }
        if (elevatorExists) {
            return elevator;
        } else {
            elevatorQueue.add(elevator);
            spaceAvailableElevatorsUp(elevatorQueue.poll(), elevatorQueue, fromFloor);
        }
       return null;
    }

    private Elevator spaceAvailableElevatorsDown(Elevator elevator, Queue<Elevator> elevatorQueue, int fromFloor) {
        boolean elevatorExists = false;

        for (int j = 0; j < fromFloor; j++) {
            if (elevator.stopfloorsOUT[j]) {
                elevatorExists = true;
                break;
            }
        }
        if (elevatorExists) {
            return elevator;
        } else {
            elevatorQueue.add(elevator);
            spaceAvailableElevatorsDown(elevatorQueue.poll(), elevatorQueue, fromFloor);
        }
        return null;

    }
}


