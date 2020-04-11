package Heroes;

public class Ork extends EntityCls implements Unit{
    public Ork( int hp, int armor, int damadge) {
        super(hp, armor, damadge);
    }

    public void battleCry() {
        System.out.println("Zag-Zag!");
    }

    public int getHP(){ return getHp(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
}
