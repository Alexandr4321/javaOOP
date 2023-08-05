package units;
import units.crossbowman;
public enum Names {

    crossbowman("crossbowman"), 
    knight("knight"), 
    magician("magician"), 
    monk("monk"), 
    peasant("peasant"),
    rogue("rogue");

    private String name;

    Names(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
