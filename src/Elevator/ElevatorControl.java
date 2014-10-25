package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorControl {

    private List<Elevator> mElevators;

    public ElevatorControl(ArrayList<Elevator> mElevatorList) {
        this.mElevators = mElevatorList;
    }

    public Elevator returnBestElevator(int fromFloor, boolean goingUp, int riderID) {
        for (Elevator elevator : mElevators) {
            if (goingUp) {
                if (elevator.currentfloor <= fromFloor) {
                    if (elevator.getEbList() == null) {
                        return elevator;
                    } else {
                        for (ElevatorBarrier eb : elevator.getEbList()) {
                            if (eb.getDestFloor() >= fromFloor) {
                                return elevator;
                            }
                        }
                    }
                }
            }

        }
            return null;
        }

    }
