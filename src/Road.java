/**
 * Created by Megan on 1/03/2016.
 */
public class Road {
    private int ID;
    private int type;
    private String label;
    private String city;
    private boolean oneWay;
    private int speed;
    private int rClass;
    private boolean forCar;
    private boolean forPed;
    private boolean forBic;

    public Road(int ID, int type, String label, String city, boolean oneWay, int speed, int rClass, boolean forCar, boolean forPed, boolean forBic) {

        this.ID = ID;
        this.type = type;
        this.label = label;
        this.city = city;
        this.oneWay = oneWay;
        this.speed = speed;
        this.rClass = rClass;
        this.forCar = forCar;
        this.forPed = forPed;
        this.forBic = forBic;
    }

    public int getID() {
        return ID;
    }

    public int getType() {
        return type;
    }

    public String getLabel() {
        return label;
    }

    public String getCity() {
        return city;
    }

    public boolean isOneWay() {
        return oneWay;
    }

    public int getSpeed() {
        return speed;
    }

    public int getrClass() {
        return rClass;
    }

    public boolean isForCar() {
        return forCar;
    }

    public boolean isForPed() {
        return forPed;
    }

    public boolean isForBic() {
        return forBic;
    }
}
