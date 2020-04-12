package Heroes;

public class Troll extends EntityCls implements Unit{
    public Troll(String name, int hp, int armor, int damadge) {
        super(name, hp, armor, damadge);
    }

    public void battleCry() {

        System.out.println("One head is good, but two is better!");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
    public String getName(){ return getNAme();}
}
