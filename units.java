package javaOOP.units;

import java.util.ArrayList;

public abstract class units implements InGameInterface{
    protected int damage, hp, max_hp;
    protected String name, sex;
    Coordinates coordinates;
    public units(int damage, int hp, String name, String sex, int x, int y) {
        this.damage = damage;
        this.hp = hp;
        this.max_hp = hp;
        this.name = name;
        this.sex = sex;
        coordinates = new Coordinates(x, y);
    }
    @Override
    public String getInfo() {
        return String.format("name:%s hp:%d", name, hp);
    }
    public units nearest(ArrayList<units> units) {
        double nearestDistance = Double.MAX_VALUE;
        units nearestEnemy = null;
        for (int i = 0; i < units.size(); i++) {
            if(coordinates.countDistance(units.get(i).coordinates) < nearestDistance) {
                nearestEnemy = units.get(i);
                nearestDistance = coordinates.countDistance(units.get(i).coordinates);
            }
        }
        return nearestEnemy;
    }
    public void HP_damage(int damage) {
        hp -= damage;
        if (hp < 0) hp = 0;
        if (hp > max_hp) hp = max_hp;
    }
}    