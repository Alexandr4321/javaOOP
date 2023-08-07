package units;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Program {
    public static ArrayList<units> allTeam = new ArrayList<>();
    public static ArrayList<units> team1 = new ArrayList<>();
    public static ArrayList<units> team2 = new ArrayList<>();
    public static void main(String[] args) {
        ArrayList<units> units = new ArrayList<>();

        units.add(new magician(Names.magician.getName(),0,0));
        units.add(new monk(Names.monk.getName(),0,0));
        units.add(new knight(Names.knight.getName(),0,0));
        units.add(new rogue(Names.rogue.getName(),0,0));
        units.add(new crossbowman(Names.crossbowman.getName(),0,0));
        units.add(new peasant(Names.peasant.getName(),0,0));
        

        //units.forEach(n-> System.out.println(n.name));

        System.out.println();
        System.out.println("Your Team1:");
        int teamCount = 10;
        Random rand = new Random();
        //ArrayList<units> team1 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val = i; 
            switch (rand.nextInt(6)) {
                case 0:
                    team1.add(new crossbowman(Names.crossbowman.getName(), 1, val+1));
                    
                    break;
                case 1:
                    team1.add(new rogue(Names.rogue.getName(), 1, val+1));
                    
                    break;
                case 2:
                    team1.add(new peasant(Names.peasant.getName(), 1, val+1));
                    
                    break;
                case 3:
                    team1.add(new magician(Names.magician.getName(), 1, val+1));
                    
                    break;
                case 4:
                    team1.add(new monk(Names.monk.getName(), 1, val+1));
                    
                    break;
                case 5:
                    team1.add(new knight(Names.knight.getName(), 1, val+1));
                    
                    break;
               
            }
        }
        //ArrayList<units> team2 = new ArrayList<>();
        for (int i = 0; i < teamCount; i++) {
            int val =i; 
            switch (rand.nextInt(6)) {
                case 0:
                    team2.add(new crossbowman(Names.crossbowman.getName(), 10, val+1));
                    break;
                case 1:
                    team2.add(new rogue(Names.rogue.getName(), 10, val+1));
                    break;
                case 2:
                    team2.add(new peasant(Names.peasant.getName(), 10, val+1));
                    break;
                case 3:
                    team2.add(new magician(Names.magician.getName(), 10, val + 1));
                    break;
                case 4:
                    team2.add(new monk(Names.monk.getName(), 10, val + 1));
                    break;
                case 5:
                    team2.add(new knight(Names.knight.getName(), 10, val + 1));
                    break;
            }
            // System.out.println(team2.get(i).getInfo());
        }
        allTeam.addAll(team1);
        allTeam.addAll(team2);

    

        View.view();
        // System.out.println("The nearest: ");


        Scanner in = new Scanner(System.in);
        while (true) {
            in.nextLine();
            String message = " ";

            int init1 = 0, init2 = 0;
            units tmpTeam1 = team1.get(init1);
            units tmpTeam2 = team2.get(init2);

            
                
            for (int i = 0; i < teamCount * 2; i++) {
            //     if (isTeamDie(team1)) {
            //         message = "Team 2 win!";
            //         break;
            //     }
            //     if (isTeamDie(team2)) {
            //         message = "Team 1 win!";
            //         break;
            //     }


            // if ( message.equals("Team 1 win")||message.equals("Team 2 win!") ) {
            //     System.out.println(message);
            //     break;
            // }
                if (isTeamDie(team2)) {
                    message = "Team 1 win!";
                    break;
                    }  if (isTeamDie(team1)) {
                            message = "Team 2 win!";
                            break;
                            }
                            if (message.equals("Team 2 win!")|| message.equals("Team 1 win")) {
                                System.out.println(message);
                                break;
                } 
                
                if ((tmpTeam1.initiative >= tmpTeam2.initiative && init1 < 10) || (tmpTeam1.initiative < tmpTeam2.initiative && init2 == 10)) {
                    tmpTeam1.step(team2, team1);
                    init1++;
                    if (init1 < 10) tmpTeam1 = team1.get(init1);
                } else {
                    tmpTeam2.step(team1, team2);
                    init2++;
                    if (init2 < 10) tmpTeam2 = team2.get(init2);
                }
                
            }

            View.view();

            // if ( message.equals("Team 1 win")||message.equals("Team 2 win!") ) {
            //     System.out.println(message);
            //     break;
            // }
            
        }
    }

    public static boolean isTeamDie(ArrayList<units> team) {
        for (units unit : team) {
            if (unit.isAlive) return false;
        }
        return true;
        }



        
        
        // System.out.println("Team1-------------: ");
        // team1.forEach(n-> System.out.println(n.getInfo()));

        // System.out.println("Team2-------------: ");
        // team2.forEach(n-> System.out.println(n.getInfo()));

        // team1.forEach(n-> n.step(team2, team1));
        // team2.forEach(n-> n.step(team1, team2));

        // System.out.println("Team1 урон-------------: ");
        // team1.forEach(n-> System.out.println(n.getInfo()));

        // System.out.println("Team2 урон-------------: ");
        // team2.forEach(n-> System.out.println(n.getInfo()));
        // System.out.println();
        
    
}