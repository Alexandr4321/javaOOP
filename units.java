package units;

import java.lang.reflect.Array;
import java.util.ArrayList;

public abstract class units implements InGameInterface{
    protected int damage, hp, max_hp, initiative,attacRange;
    protected String name, sex;
    public boolean isAlive;
    Coordinates coordinates;
    public units(int damage, int hp, String name, String sex, int x, int y, boolean isAlive, int initiative, int attacRange) {
        this.damage = damage;
        this.hp = hp;
        this.max_hp = hp;
        this.name = name;
        this.sex = sex;
        coordinates = new Coordinates(x, y);
        this.isAlive = isAlive;
        this.initiative=initiative;
        this.attacRange=attacRange;
    }
    @Override
    public String getInfo() {
        
        return String.format("name:%s hp:%d [x:%d y:%d] ", name, hp ,coordinates.x, coordinates.y);
    }

    @Override
    public String toString(){
        return this.name;
    }
    public units nearest(ArrayList<units> units) {
        double nearestDistance = Double.MAX_VALUE;
        units nearestEnemy =units.get(attacRange);
        for (int i = 0; i < units.size(); i++) {
            if(coordinates.countDistance(units.get(i).coordinates) < nearestDistance && units.get(i).isAlive) {
                nearestEnemy = units.get(i);
                nearestDistance = coordinates.countDistance(units.get(i).coordinates);
            }
        }
        return nearestEnemy;
    }

    public String state ="Stand";

    public ArrayList<Integer> getCoords() {
        return coordinates.xy;
    }


    // public void HP_damage(int damage) {
    //     hp -= damage;
    //     if (hp < 0){
    //         hp = 0;
    //     }
    //     if (hp > max_hp) hp = max_hp;
    
    public void getDamage(int damage) {
        hp -= damage;
        if (hp <= 0) {
            hp = 0;
            isAlive = false;
            state = "Dead";
        }
        if (hp > max_hp) hp = max_hp;
    }
    public void move(Coordinates targetPosihion, ArrayList<units> team){//,ArrayList<units>team){
       if(!coordinates.containsByPos(coordinates.newPosition(targetPosihion, team),team)){
            for (int i = 0; i < attacRange; i++) {
                coordinates= coordinates.newPosition(targetPosihion,team);
            }
       }
    }

}    