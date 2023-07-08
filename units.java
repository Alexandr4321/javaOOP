package javaOOP.units;


public class units {
    public int healts;//жизнь
    public int defence;//защита
    public int damage;//урон
    public int actionPoints;//ход
    public int mana;//мана 
    public String name;//Имя

    
    public boolean hasAP(){
        if(actionPoints>0){
            return true;
        }else return false;
    }
    public int move(){
        while(hasAP()){
        }
        return actionPoints;
    }

    public units(int healts,int defence,int damage,int actionPoints,int mana,String name) {
        this.healts = healts;
        this.defence = defence;
        this.damage = damage;
        this.actionPoints = actionPoints;
        this.mana = mana;
        this.name = name;

    }
}    