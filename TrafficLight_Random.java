package RoadsProject;

import java.util.Random;

public class TrafficLight_Random extends TrafficLight {
    public TrafficLight_Random(Junction junc) {
        super(junc);
    }

    public void trafficLightStatus() {
        Random rand = new Random();
        int sum = rand.nextInt(getJunc().getEnteringRoads().size());
        setGreenRoad(getJunc().getEnteringRoads().get(sum));
    }

    public String toString() {
        return "Random TrafficLights " + this.getJunc() + ", delay= " + this.getDelay() + ": green light on " + this.getCurrentGreen() ;
    }
}

