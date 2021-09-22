package RoadsProject;
import java.util.ArrayList;

public class Junction extends Point{
    private ArrayList<Junction> junctions = new ArrayList<RoadsProject.Junction>();
    private static int counter = 1;
    private int id;

    public TrafficLight getTl() {
        return tl;
    }

    private TrafficLight tl = null;
    private ArrayList<Road> enteringRoads = new ArrayList<Road>();
    private ArrayList<Road> exitingRoads = new ArrayList<Road>();

    public TrafficLight getTrafficLight() {
        return tl;
    }

    public void setTrafficLight(TrafficLight tl) {
        this.tl = tl;
    }

    public ArrayList<Road> getEnteringRoads() {
        return enteringRoads;
    }

    public ArrayList<Road> getExitingRoads() {
        return exitingRoads;
    }

    public void addEnteringRoads(Road enter) {
        enteringRoads.add(enter);
    }

    public void addExitingRoads(Road exit) {
        exitingRoads.add(exit);
    }

    public Junction(){
        super();
        id = counter++;
        System.out.println("Creating " + this + " at " + super.toString() );
        junctions.add(this);
    }

    public Junction(double a, double b){
        super(a, b);
        id = counter++;
        System.out.println("Creating " + this + " at " + super.toString() );
        junctions.add(this);
    }


    @Override
    public String toString() {
        return "Junction " + id;
    }

    @Override
    protected String print() {
        return "";
    }

}
