package Heroes;

public class Ork extends EntityCls implements Unit{

    public Ork(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    public void battleCry() {
        System.out.println("Zag-Zag!");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public float getPower(){ return getPOwer(); }
    public void setPower(float power){ setPOwer(power);}

    public String getName(){return getNAme();}
}
