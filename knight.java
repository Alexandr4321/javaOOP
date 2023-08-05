package units;

import java.util.ArrayList;

public class knight extends  units{
    public knight(String name, int x, int y) {
        super(30, 95, name, "male", x, y , true, 0,1);
    }


    @Override
    public void step(ArrayList<units> units, ArrayList<units> team) {
        units tmp = nearest(units);
        //System.out.println(tmp.name+" " +coordinates.countDistance(tmp.coordinates));
        move(tmp.coordinates, team);
        if(isAlive)return;
        if(coordinates.countDistance(tmp.coordinates)<=attacRange && tmp.isAlive){
            tmp.getDamage(damage);
        }else{
            move(tmp.coordinates, team);
        }
        
        // System.out.println("KNIGHT АТАКУЕТ"+ tmp);
    }
}
