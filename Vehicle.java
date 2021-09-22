package RoadsProject;

import RoadsProject.*;
import java.util.ArrayList;
import java.util.Random;

public class Vehicle {
    private int speed;
    private double distance;
    private static int count = 1;
    private int id;
    private int road = 0;
    private ArrayList<Road> driveRoute = new ArrayList<Road>();
    private Road test;
    private static int success_vehicle = 0;
    private boolean finish = false;

    public static int getSuccess_vehicle() {
        return success_vehicle;
    }

    public static void setSuccess_vehicle(int success_vehicle) {
        Vehicle.success_vehicle = success_vehicle;
    }

    public Vehicle(Map map) {
        id = count++;
        Random rand = new Random();
        speed = rand.nextInt(91) + 30;
        driveRoute = map.randomRoute();
        distance = driveRoute.get(road).getLength();
        System.out.println("Creating Vehicle " + this);
    }

    public void move() {
            if (distance == 0 && road == driveRoute.size() - 1) {
                System.out.println("Vehicle " + id + " arrived to it's destination: " + driveRoute.get(road).getEnd());
                if (!finish){
                    success_vehicle++;
                    finish = true;
                }
                return;
            }
            if (distance == 0 && road < driveRoute.size() - 1) {
                if (driveRoute.get(road).getEnd().getTrafficLight() != null) {
                    if (driveRoute.get(road).getEnd().getTrafficLight().getCurrentGreen() == driveRoute.get(road)) {
                        road++;
                        this.distance = driveRoute.get(road).getLength();
                    }
                    else {
                        System.out.println("The Light is red"); // add correct print
                        return;
                    }
                }
            }
            if (distance > 0) {
                distance -= speed;
                if (distance < 0) {
                    distance = 0;
                }
                System.out.println("Vehicle " + id + " is moving on the " + driveRoute.get(road));
            }
        }
//    }

    public int getSpeed(){
        return speed;
    }

    public ArrayList<Road> getDriveRoute(){
        return driveRoute;
    }

    public String toString() {
        return id+ " , speed: " + this.getSpeed()+ " path: "+ this.getDriveRoute() ;
    }
}
