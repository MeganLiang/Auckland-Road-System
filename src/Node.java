/**
 * Created by Megan on 1/03/2016.
 */
import java.util.HashSet;

public class Node {
    public int ID;
    public double lat;
    public double lon;
    private Location loc;
    public HashSet<Segment> segments;

    public Node (int id,double x, double y, HashSet <Segment> s){
        ID = id;
        lat = x;
        lon = y;
        loc = Location.newFromLatLon(x, y);
        segments = s;
    }

    public int getid(){
        return ID;
    }

    public double getLat(){
        return lat;
    }

    public double getLon(){
        return lon;
    }

    public Location getLocation(){
        return loc;
    }

    public HashSet<Segment> getRoads(){
        return segments;
    }

}