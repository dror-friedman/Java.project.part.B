package RoadsProject;


public class Road {
    private Junction start;
    private Junction end;
    private double len;


    public Junction getStart() {
        return this.start;
    }

    public Junction getEnd() {
        return this.end;
    }

    public double getLength() {
        return len;
    }

    public Road (Junction start, Junction end){
        if (start == end){
            this.start = start;
            this.end = new Junction();
            len = start.calcDistance(this.end);
            System.out.println("Road can not connect a junction to itself, " +
                    "the end of this junction has been replaced with " + this.end);
        }
        else{
            this.end = end;
            this.start = start;
            len = start.calcDistance(end);
        }
        System.out.printf("Creating Road from %s to %s, length: %.2f\n", start.toString(), this.end.toString(), len);

        this.start.addExitingRoads(this);
        this.end.addEnteringRoads(this);
    }

    @Override
    public String toString() {
        return "Road from " + this.start + " to " + this.end;
    }


}
