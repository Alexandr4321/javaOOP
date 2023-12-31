package units;

import java.util.ArrayList;

public abstract class Shooter extends units {
    protected int arrows = 20;

    public Shooter(int damage, int hp, String name, String sex, int x, int y, boolean isAlive, int initiative, int attacRange) {
        super(damage, hp, name, sex, x, y, isAlive, initiative, attacRange);
    }

    @Override
    public void step(ArrayList<units> units, ArrayList<units> team) {
        // Если жизни 0 вернуть управление
        if (this.hp == 0 || this.arrows == 0) return;
        // Если стрел 0 вернуть управление
        // Найти ближайшего противника
        units tmp = nearest(units);
        // Нанести ему среднее повреждение
        //System.out.println(tmp.name+" " +coordinates.countDistance(tmp.coordinates));

        for (units unit:team) {
            if (unit.name.equals("crossbowman")) {
                arrows++;
                break;
            }
        }
        if(!isAlive)return;
        if(coordinates.countDistance(tmp.coordinates)<=attacRange){
            tmp.getDamage(damage);
        }else{
            move(tmp.coordinates, team);
        }
        // уменьшить кол-во стрел на одну и вернуть управление
        arrows -= 1;
        for(units unit : team){
            if(unit instanceof peasant&& unit.state=="Stand")
                unit.state="Busy";
                arrows+=1;
        }
        return;
    }

    @Override
    public String getInfo() {
        return String.format("name:%s hp:%d arrows:%d", name, hp, arrows);
    }
}
