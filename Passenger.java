package RoadsProject;

import java.util.ArrayList;

public class Passenger {
    private ArrayList<Road> route;
    private ArrayList<Passenger> passengers = new ArrayList<Passenger>();
    private boolean

    public Passenger(Map map) {
        route = map.randomRoute();
        passengers.add(this);
    }
}
