package RoadsProject;

import java.util.ArrayList;

public class Point {
    private final double MAX_X = 800;
    private final double MAX_Y = 600;
    private final double MIN = 0;
    private String name;
    private double x;
    private double y;
    private ArrayList<Point> points = new ArrayList<RoadsProject.Point>();
    private static int counter = 0;

    public Point(double X, double Y){
        this.x = checkNum(X , MIN, MAX_X);
        this.y = checkNum(Y , MIN, MAX_Y);
        if (this.x != X) {
            System.out.printf("%.2f is illegal value for x and has been replaced with %.2f \n", X ,this.x);
        }

        if (this.y != Y) {
            System.out.printf("%.2f is illegal value for y and has been replaced with %.2f \n", Y ,this.y);
        }
        System.out.print(print());
        name = "Point " + ++counter;
        points.add(this);
    }

    private double checkNum(double num, double min, double max){
        if ((num < min) || (num > max)){
            num = (double) (Math.random() * (max - min + 1) + min);
            return num;
        }
        else return num;
    }

    public Point(){
        this.x = (double)(Math.random() * MAX_X) + 0;
        this.y = (double)(Math.random() * MAX_Y) + 0;
        System.out.print(print());
    }


    public double calcDistance(Point other){
        double distance = Math.sqrt(Math.pow((this.x - other.x),2) + Math.pow((this.y - other.y),2));
        return distance;
    }

    @Override
    public String toString() {
        return String.format("Point (%.2f, %.2f)", x, y);
    }

    protected String print() {
        return ("Creating " + this + "\n");
    }
}
