package javaOOP.units;

import java.util.ArrayList;

public interface InGameInterface {

    void step(ArrayList<units> units, ArrayList<units> team);
    String getInfo();
}