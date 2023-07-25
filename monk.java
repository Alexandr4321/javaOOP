package javaOOP.units;

import java.util.ArrayList;

public class monk extends units {

    public monk(String name, int x, int y) {
        super(25,80, name, "male", x, y);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> team) {
        units tmp = nearest(units);
        //System.out.println(tmp.name+" " +coordinates.countDistance(tmp.coordinates));
        tmp.HP_damage(damage);
    }
}