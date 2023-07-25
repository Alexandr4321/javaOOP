package javaOOP.units;

import java.util.ArrayList;

public class crossbowman extends units {

    public crossbowman(String name, int x, int y) {
        super(30,70, name, "male", x, y);
    }
    @Override
    public void step(ArrayList<units> units, ArrayList<units> team) {
        units tmp = nearest(units);
        System.out.println(tmp.name+" " +coordinates.countDistance(tmp.coordinates));
    }
}