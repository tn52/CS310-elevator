package Elevator;

import java.util.TreeSet;

/**
 * Created by Prit on 10/25/14.
 */
public class FloorData {

    protected TreeSet<Integer> ascendingFloorList;
    protected TreeSet<Integer> descendingFloorList;

    public FloorData() {
        ascendingFloorList = new TreeSet<Integer>();
        descendingFloorList = new TreeSet<Integer>();
    }
}
