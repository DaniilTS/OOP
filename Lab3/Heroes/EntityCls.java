package Heroes;

public class EntityCls implements Unit{

    public String name;
    private final int hp;
    private final int armor;
    private double power;

    public EntityCls(String unitName, int hp, int armor, double power){

        this.name = unitName;
        this.hp = hp;
        this.armor = armor;
        this.power = power;
    }

    public void battleCry() { }

    public int getHp(){return this.hp;}
    public int getArmor(){return this.armor;}
    public double getPower(){return this.power;}
    public void setPower(double power){this.power = power;}
    public String getName(){return this.name;}
}
