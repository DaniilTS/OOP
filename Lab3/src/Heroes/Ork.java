package Heroes;

public class Ork extends EntityCls implements Unit{
    public Ork(String name, int hp, int armor, int damadge) {
        super(name, hp, armor, damadge);
    }

    public void battleCry() {
        System.out.println("Zag-Zag!");
    }

    public int getHp(){ return getHP(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
    public String getName(){return getNAme();}
}
