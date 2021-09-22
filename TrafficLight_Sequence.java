package RoadsProject;

public class TrafficLight_Sequence extends TrafficLight {
    private int roadID = 0;

    public TrafficLight_Sequence(Junction junc) {
        super(junc);
    }

    @Override
    public void trafficLightStatus() {
        setGreenRoad(getJunc().getEnteringRoads().get(roadID++ % this.getJunc().getEnteringRoads().size()));
    }

    @Override
    public String toString() {
        return "Sequential TrafficLights " + this.getJunc() + ", delay= " + this.getDelay() + ": green light on " + this.getCurrentGreen();
    }
}
