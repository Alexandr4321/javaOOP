package javaOOP.units;

import java.util.ArrayList;

public class Program {
    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new magician("Mage"));
        units.add(new monk("Monk"));
        units.add(new knight("Knight"));
        units.add(new rogue("Rogue"));
        units.add(new crossbowman("Crossbowman"));
        units.add(new peasant("Peasant"));

        units.forEach(n-> System.out.println(n.name));
    }
}

