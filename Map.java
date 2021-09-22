package RoadsProject;

import java.util.ArrayList;
import java.util.Random;

public class Map {

    private ArrayList<Junction> junctions = new ArrayList<Junction>();
    private ArrayList<Road> roads = new ArrayList<Road>();

    public Map(int junctionAmount){
        for (int i = 0; i < junctionAmount; i++){
            junctions.add(new Junction());
        }
        createRoads();
        createTrafficLight();
    }

    public Map(ArrayList<Junction> junc, ArrayList<Road> roads){
        junctions = junc;
        this.roads = roads;
        createTrafficLight();
    }

    public void createTrafficLight(){
        Random r = new Random();
        for (Junction junc : junctions) {
            if(junc.getEnteringRoads().size()>0 && r.nextBoolean()&&r.nextBoolean()){
                if (r.nextBoolean()){
                    junc.setTrafficLight(new TrafficLight_Random(junc));
                }
                else {
                    junc.setTrafficLight(new TrafficLight_Sequence(junc));
                }
            }
        }
    }


    public void createRoads() {
        Random r = new Random();
        for (Junction start : junctions){
            for (Junction end : junctions){
                if (start != end && r.nextBoolean()){
                    Road tempRoad = new Road(start, end);
                    roads.add(tempRoad);
                    start.addExitingRoads(tempRoad);
                    end.addEnteringRoads(tempRoad);

                }
            }
        }
    }

    public ArrayList<Junction> getJunctions() {
        return junctions;
    }

    public ArrayList<Road> randomRoute()
    {
        Random rand = new Random();
        ArrayList<Road> driveRoute = new ArrayList<Road>();
        Junction randJunc;
        do
        {
            int road = rand.nextInt(junctions.size());
            randJunc = junctions.get(road);

        }
        while(randJunc.getExitingRoads().size()==0);

        do
        {
            Road road =randJunc.getExitingRoads().get(rand.nextInt(randJunc.getExitingRoads().size()));
            driveRoute.add(road);
            randJunc=road.getEnd();
        }
        while(randJunc.getExitingRoads().size()>0 && driveRoute.size()<4 );

        return driveRoute ;
    }
}
