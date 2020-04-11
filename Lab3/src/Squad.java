import Heroes.Unit;

import java.util.ArrayList;
import java.util.List;

class Squad implements Unit {

    private final List<Unit> units = new ArrayList<>();
    private int HP;
    private int armor;
    private int power;

    public void addComponent(Unit unit){
        units.add(unit);
    }

    public void removeComponent(Unit unit){
        units.remove(unit);
    }

    public void addGroupOfUnits(Unit unit,int numOfUnits){
        for (int i = 0; i < numOfUnits;i++){
            units.add(unit);
        }
    }

    public void battleCry() {
        for (Unit unit: units){
            unit.battleCry();
        }
    }

    public void battleMarch(){
        System.out.println("Loud footsteps");
    }

    public void getStatus(){
        System.out.println("||||||||||||||||||||||");
        System.out.println("Capacity of the squad:");
        System.out.println("Total hp: "+getHP());
        System.out.println("Total armor: "+getArmor());
        System.out.println("Total power: "+getPower());
        System.out.println("||||||||||||||||||||||");
    }
        public int getHP(){
        for (Unit unit: units){
            HP += unit.getHP();
        }
        return HP;
    }
        public int getArmor(){
        for (Unit unit: units){
            armor += unit.getArmor();
        }
        return armor;
    }
        public int getPower(){
        for (Unit unit: units){
            power += unit.getPower();
        }
        return power;
    }
}
