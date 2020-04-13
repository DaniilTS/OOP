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

    public void addUnit(Unit unit){
        units.add(unit);
    }
    public void removeUnit(Unit unit){
        units.remove(unit);
    }
    public void addGroupOfUnits(Unit unit,int numOfUnits){
        for (int i = 0; i < numOfUnits;i++){
            addUnit(unit);
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
                names = names.concat(unit.getName()+" ");
            }
        }
        while(names.contains("  ")){
            names = names.replaceAll(" {2}", " ");
        }
        return names;
    }
    public void setName(String name){
        for (Unit unit: units){
            unit.setName(name);
        }
    }

    public double getHp(){
        int HP = 0;
        for (Unit unit: units){
            HP += unit.getHp();
        }
        return HP;
    }
    public void setHp(double hp){
        for(Unit unit: units){
            unit.setHp(hp);
        }
    }

    public double getArmor(){
        int armor = 0;
        for (Unit unit: units){
            armor += unit.getArmor();
        }
        return armor;
    }
    public void setArmor(double armor){
        for(Unit unit: units){
            unit.setArmor(armor);
        }
    }
    public void setArmor(String name, double armor){
        for (Unit unit: units){
            unit.setArmor(name,armor);
        }
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
