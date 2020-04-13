package Heroes;

public class Ork extends EntityCls{

    public Ork(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    @Override
    public void battleCry() {
        System.out.println("Zag-Zag!");
    }

}
