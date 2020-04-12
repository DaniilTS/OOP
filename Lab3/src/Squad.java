import Heroes.Unit;

import java.util.ArrayList;
import java.util.List;

class Squad implements Unit {

    public Squad(String squadName){
        this.squadName = squadName;
    }

    private List<Unit> units = new ArrayList<>();

    private String names = "";
    private String squadName;
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
        System.out.println("Capacity of the " + this.squadName + " squad:");
        System.out.println("Units's types: "+getName());
        System.out.println("Total hp: "+getHp());
        System.out.println("Total armor: "+getArmor());
        System.out.println("Total power: "+getPower());
        System.out.println("||||||||||||||||||||||\n");
    }

    public String getName(){
        for (Unit unit: units){
            if(!names.contains(unit.getName())){
                names += unit.getName()+"|";
            }
        }
        return names;
    }
    public int getHp(){
        for (Unit unit: units){
            HP += unit.getHp();
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
