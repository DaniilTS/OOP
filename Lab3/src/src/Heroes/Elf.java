package Heroes;

public class Elf extends EntityCls implements Unit{

    public Elf(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    public void battleCry() {

        System.out.println("For the elf's queen!");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public float getPower(){ return getPOwer(); }
    public void setPower(float power){ setPOwer(power);}

    public String getName(){ return getNAme();}
}
