package javaOOP.units;

import java.util.ArrayList;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new magician(Names.magician.getName(),0,1));
        units.add(new monk(Names.monk.getName(),0,2));
        units.add(new knight(Names.knight.getName(),0,3));
        units.add(new rogue(Names.rogue.getName(),0,4));
        units.add(new crossbowman(Names.crossbowman.getName(),0,5));
        units.add(new peasant(Names.peasant.getName(),0,6));
        

        //units.forEach(n-> System.out.println(n.name));

        System.out.println();
        System.out.println("Your Team1:");
        int teamCount = 3;
        //Random rand = new Random();
        ArrayList<units> team1 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = i; //rand.nextInt(teamCount);
            switch (val) {
                case 0:
                    team1.add(new magician(Names.magician.getName(), 0, val + 1));
                    break;
                case 1:
                    team1.add(new monk(Names.monk.getName(), 0, val + 1));
                    break;
                case 2:
                    team1.add(new knight(Names.knight.getName(), 0, val + 1));
                    break;
               
            }
        }
        ArrayList<units> team2 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val =i; //rand.nextInt(teamCount);
            switch (val) {
                case 0:
                    team2.add(new crossbowman(Names.crossbowman.getName(), 5, val+1));
                    break;
                case 1:
                    team2.add(new rogue(Names.rogue.getName(), 5, val+1));
                    break;
                case 2:
                    team2.add(new peasant(Names.peasant.getName(), 5, val+1));
                    break;
                
            }
            // System.out.println(team2.get(i).getInfo());
        }
        // System.out.println("The nearest: ");

        System.out.println("Team1-------------: ");
        team1.forEach(n-> System.out.println(n.getInfo()));

        System.out.println("Team2-------------: ");
        team2.forEach(n-> System.out.println(n.getInfo()));

        team1.forEach(n-> n.step(team2, team1));
        team2.forEach(n-> n.step(team1, team2));

        System.out.println("Team1 урон-------------: ");
        team1.forEach(n-> System.out.println(n.getInfo()));

        System.out.println("Team2 урон-------------: ");
        team2.forEach(n-> System.out.println(n.getInfo()));
    }
    
}


