/**
 * Created by Megan on 1/03/2016.
 */
import java.util.List;

public class Segment {
    public int id;
    public double length;
    public Node node1;
    public Node node2;
    public Road road;
    public List<Location> coords;

    public Segment(int ID,double l, Node n1, Node n2, Road r, List<Location> co){
        this.id = ID;
        this.length = l;
        this.node1 = n1;
        this.node2 = n2;
        this.road = r;
        this.coords = co;
    }

    public int getID(){
        return id;
    }

    public double getLength(){
        return length;
    }

    public Node getNode1(){
        return node1;
    }

    public Node getNode2(){
        return node2;
    }

    public Road getRoad(){
        return road;
    }

    public List<Location> getCoordLoc(){
        return coords;
    }


}