
import java.io.Serializable;
import java.util.ArrayList;

public class Room implements Serializable {

    private ArrayList<Wall> wallList;
    public static int roomCount=0;
    private int roomNum;



    public Room(double length, double width, double height) throws BadWidthException, BadHeightException {
        roomCount++;
        roomNum = roomCount;
        wallList = new ArrayList<Wall>();

        Wall wallA = new Wall(length, height);
        wallList.add(wallA);
        Wall wallB = new Wall(length, height);
        wallList.add(wallB);
        Wall wallC = new Wall(width, height);
        wallList.add(wallC);
        Wall wallD = new Wall(width, height);
        wallList.add(wallD);
    }

    public double getArea() {
        double area = 0;

        for (int i = 0; i < wallList.size(); i++) {
            Wall w = wallList.get(i);
            area += w.getArea();
        }

        return area;
    }

    public int getRoomNum() {
        return roomNum;
    }

    @Override
    public String toString() {
        return "Room #" + roomNum + " of " + roomCount + " {" +
                "wallList=" + wallList +
                '}';
    }
}
