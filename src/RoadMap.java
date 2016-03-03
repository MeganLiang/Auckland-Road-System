import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class RoadMap extends GUI{
    public Map<Integer, Node> nodes = new HashMap<>();
    public Map<Integer, Road> roads = new HashMap<>();
    public Map<Integer, Segment> segments = new HashMap< Integer, Segment>();

    public HashSet<Segment> roadSegments;
    public ArrayList<Location> coordLoc;

    protected void redraw(Graphics g) {

    }
    protected void onClick(MouseEvent e) {

    }
    protected void onSearch() {

    }

    protected void onMove(Move m) {
    }

    protected void onLoad(File nodes, File roads, File segments,
                          File polygons){

    }

    public void loadNodes (File f){
        String thisLine = null;
        try{
            BufferedReader data = new BufferedReader (new FileReader(f));
            while ((thisLine = data.readLine()) != null){
                String [] values = thisLine.split("\t");
                int ID = Integer.parseInt(values[0]);
                double lon = Double.parseDouble(values[1]);
                double lat = Double.parseDouble(values[2]);

                for (Segment s: segments.values()){
                    if (s.getNode1().equals(s) || s.getNode2().equals(s)){
                        roadSegments.add(s);
                    }
                }
                Node n = new Node(ID, lon, lat, roadSegments);
                nodes.put(n.ID, n);
            }
            data.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    public void loadRoads (File f){
        String thisLine = null;
        try {
            BufferedReader data = new BufferedReader(new FileReader(f));
            while ((thisLine = data.readLine()) != null){
                String [] values = thisLine.split("\t");
                int roadID = Integer.parseInt(values[0]);
                int roadType = Integer.parseInt(values[1]);
                String roadLabel = values[2];
                String roadCity = values[3];
                int boolOneWay = Integer.parseInt(values[4]);
                boolean roadOneWay = false;
                if (boolOneWay == 1){
                    roadOneWay = true;
                }
                int roadSpeed = Integer.parseInt(values[5]);
                int roadClass = Integer.parseInt(values[6]);
                int boolForCar= Integer.parseInt(values[7]);
                boolean roadNotForCar = true;
                if (boolForCar == 0){
                    roadNotForCar = false;
                }
                int boolForPed= Integer.parseInt(values[8]);
                boolean roadNotForPed = true;
                if (boolForPed == 0){
                    roadNotForPed = false;
                }
                int boolForBic= Integer.parseInt(values[9]);
                boolean roadNotForBic = true;
                if (boolForBic == 0){
                    roadNotForBic = false;
                }
                Road r = new Road( roadID, roadType, roadLabel, roadCity, roadOneWay, roadSpeed, roadClass, roadNotForCar, roadNotForPed, roadNotForBic);
                roads.put(roadID, r);
            }
            data.close();
        }catch (IOException e){
            e.printStackTrace();
        }


    }
    public void loadSeg (File f) {
        String thisLine = null;
        try {
            BufferedReader data = new BufferedReader(new FileReader(f));
            while ((thisLine = data.readLine()) != null) {
                String[] values = thisLine.split("\t", 3);
                int roadID = Integer.parseInt(values[0]);
                double roadLength = Double.parseDouble(values[1]);
                int roadNode1 = Integer.parseInt(values[2]);
                int roadNode2 = Integer.parseInt(values[3]);

                String[] coordValues = values[4].split("\t");
                double[] coords = new double[coordValues.length];

                for (int i = 0; i < coords.length; i++) {
                    coords[i] = Double.parseDouble(coordValues[i]);
                }
                coordLoc = new ArrayList<>();
                for (int i = 0; i < coords.length; i=i+2) {
                    Location location = Location.newFromLatLon(coords[i],coords[i+1]);
                    coordLoc.add(location);
                }
                Node n1 = nodes.get(roadNode1);
                Node n2 = nodes.get(roadNode2);
                Road road = null;

                for (Road entry : roads.values()){
                    if (entry.getID() == roadID){
                        road = entry;
                        break;
                    }
                }
                if (road !=null) {
                    Segment s = new Segment(roadID, roadLength, n1, n2, road, coordLoc);
                    segments.put(roadID, s);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

