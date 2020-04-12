package Heroes;

public class Troll extends EntityCls implements Unit{

    public Troll(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    public void battleCry() {

        System.out.println("One head is good, but two is better!");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public float getPower(){ return getPOwer(); }
    public void setPower(float power){ setPOwer(power);}

    public String getName(){ return getNAme();}
}
