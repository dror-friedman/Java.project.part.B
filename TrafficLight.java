package RoadsProject;

import java.util.Random;

abstract public class TrafficLight {
    private int delay;
    private int turns = 0;
    private Junction junc;
    private Road greenRoad;

    public TrafficLight(Junction junc) {
        this.junc = junc;
        Random rand = new Random();
        delay = rand.nextInt(3) + 2;
        this.trafficLightStatus();
        System.out.println(this);
    }
    public abstract void trafficLightStatus();

    public Junction getJunc() {
        return junc;
    }

    public void setJunc(Junction junc) {
        this.junc = junc;
    }

    public void check() {
        if (++turns % this.getDelay() == 0)
        {
            this.trafficLightStatus();
            System.out.println(this);
        }
    }

    public int getDelay() {
        return delay;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public Road getCurrentGreen() {
        return greenRoad;
    }

    public void setGreenRoad(Road greenRoad) {
        this.greenRoad = greenRoad;
    }
}
