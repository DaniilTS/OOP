package Heroes;

public class Knight extends EntityCls implements Unit {

    public Knight(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    public void battleCry() {
        System.out.println("I hit twice: the first time on the head, " +
                           "the second on the lid of the coffin");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public float getPower(){ return getPOwer(); }
    public void setPower(float power){ setPOwer(power);}

    public String getName(){return getNAme();}

}
