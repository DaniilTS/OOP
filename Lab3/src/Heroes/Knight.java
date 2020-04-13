package Heroes;

public class Knight extends EntityCls{

    public Knight(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    @Override
    public void battleCry() {
        System.out.println("I hit twice: the first time on the head, " +
                           "the second on the lid of the coffin");
    }
}
