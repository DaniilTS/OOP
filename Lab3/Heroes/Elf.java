package Heroes;

public class Elf extends EntityCls{

    public Elf(String unitName, int hp, int armor, float power) {
        super(unitName, hp, armor, power);
    }

    @Override
    public void battleCry() {

        System.out.println("For the queen!");
    }

}
