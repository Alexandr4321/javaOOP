package units;

import java.util.ArrayList;

public interface InGameInterface {

    void step(ArrayList<units> units, ArrayList<units> team);
    //void step(ArrayList<units> team1, ArrayList<units> team2);
    String getInfo();
}