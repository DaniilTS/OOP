package Heroes;

public class Knight extends EntityCls implements Unit {

    public Knight(String name, int hp, int armor, int damadge) {
        super(name, hp, armor, damadge);
    }

    public void battleCry() {
        System.out.println("I hit twice: the first time on the head, " +
                           "the second on the lid of the coffin");
    }


    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
    public String getName(){return getNAme();}

}
