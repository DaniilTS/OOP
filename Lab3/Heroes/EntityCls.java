package Heroes;

public class EntityCls implements Unit{

    public String name;
    private double hp;
    private double armor;
    private double power;

    public EntityCls(String unitName, int hp, double armor, double power){

        this.name = unitName;
        this.hp = hp;
        this.armor = armor;
        this.power = power;
    }

    public void battleCry(){}

    public double getHp(){return this.hp;}
    public void setHp(double hp){this.hp = hp;}

    public double getArmor(){return this.armor;}
    public void setArmor(double armor){this.armor = armor;}
    public void setArmor(String name,double armor){
        if(this.name.equals(name)){
            this.armor = armor;
        }
    }

    public double getPower(){return this.power;}
    public void setPower(double power){this.power = power;}

    public String getName(){return this.name;}
    public void setName(String unitName){this.name = unitName;}
}
