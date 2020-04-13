import Heroes.Unit;

import java.util.ArrayList;
import java.util.List;

class Squad implements Unit {

    public Squad(String squadName){
        this.squadName = squadName;
    }

    private String names = "";
    private final List<Unit> units = new ArrayList<>();
    private final String squadName;

    public void addComponent(Unit unit){
        units.add(unit);
    }
    public void removeComponent(Unit unit){
        units.remove(unit);
    }
    public void addGroupOfUnits(Unit unit,int numOfUnits){
        for (int i = 0; i < numOfUnits;i++){
            addComponent(unit);
        }
    }
    public int getNumOfUnitsInGroup(){
        return units.size();
    }

    public void battleCry() {
        for (Unit unit: units){
            unit.battleCry();
        }
    }
    public void battleMarch(){
        double newPower = getPower()/(units.size())+getPower()/(units.size())*(double) 0.25;
        setPower(newPower);
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
                String asd = unit.getName();
                names = names.concat(unit.getName()+" ");
            }
        }
        while(names.contains("  ")){
            names = names.replaceAll("  ", " ");
        }
        return names;
    }
    public int getHp(){
        int HP = 0;
        for (Unit unit: units){
            HP += unit.getHp();
        }
        return HP;
    }
    public int getArmor(){
        int armor = 0;
        for (Unit unit: units){
            armor += unit.getArmor();
        }
        return armor;
    }
    public double getPower(){
        float power = 0;
        for (Unit unit: units){
            power += unit.getPower();
        }
    return power;
    }
    public void setPower(double power){
        for(Unit unit: units){
            unit.setPower(power);
        }
    }
}
