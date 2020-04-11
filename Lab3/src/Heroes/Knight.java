package Heroes;

public class Knight extends EntityCls implements Unit {

    public Knight(int hp, int armor, int damadge) {
        super(hp, armor, damadge);
    }

    public void battleCry() {
        System.out.println("I hit twice: the first time on the head, " +
                           "the second on the lid of the coffin");
    }

    public int getHP(){ return getHp(); }
    public int getArmor(){ return getARmor(); }
    public int getPower(){ return getDAmadge(); }
}
