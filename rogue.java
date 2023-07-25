package javaOOP.units;

import java.util.ArrayList;

public class rogue extends units {

    public rogue(String name, int x, int y) {
        super(20,90, name, "male", x, y);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> team) {
        units tmp = nearest(units);
        //System.out.println(tmp.name+" " +coordinates.countDistance(tmp.coordinates));
        tmp.HP_damage(damage);
    }
}

