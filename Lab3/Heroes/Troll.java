package Heroes;

public class Troll extends EntityCls{

    public Troll(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    @Override
    public void battleCry() {

        System.out.println("One head is good, but two is better!");
    }
}
