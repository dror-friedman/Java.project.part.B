package RoadsProject;

import java.util.ArrayList;

public class DrivingGame {
    private Map map;
    private ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();
    private int vehicle_count;
    private int turns = 0;

    public DrivingGame(int juncs, int vehicle) {
        map = new Map(juncs);
        vehicle_count = vehicle;
        for (int i = 0; i < vehicle; i++) {
            vehicles.add(new Vehicle(map));
        }
    }

    public void play() {
        ArrayList<TrafficLight> trafficLights = new ArrayList<TrafficLight>();
        for (Junction junc : map.getJunctions()) {
            if (junc.getTl() != null){
                trafficLights.add(junc.getTl());
            }
        }

        while (Vehicle.getSuccess_vehicle() != vehicle_count){
            System.out.println("\nTurn " + ++turns);
            if (turns % 3 == 0){
                new Passenger(map);
            }
            for (int j = 0; j < vehicles.size(); j++){
                vehicles.get(j).move();
            }
            for (TrafficLight trafficLight: trafficLights) {
                trafficLight.check();
            }
        }
    }
}
