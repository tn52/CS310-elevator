package Elevator;

import java.util.ArrayList;
import java.util.List;

public class ElevatorControl {

    private List<Elevator> mElevators;

    public ElevatorControl(ArrayList<Elevator> mElevatorList) {
        this.mElevators = mElevatorList;
    }

    public Elevator returnBestElevator(int fromFloor, boolean goingUp, int riderID) {

            return mElevators.get(0);
        }

    }
