package Heroes;

public class Troll extends EntityCls implements Unit{
    public Troll(int hp, int armor, int damadge) {
        super(hp, armor, damadge);
    }

    public void battleCry() {

        System.out.println("One head is good, but two is better!");
    }

    public int getHP(){ return getHp(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
}
