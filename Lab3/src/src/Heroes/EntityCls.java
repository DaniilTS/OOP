package Heroes;

public class EntityCls {

    public String name;
    private int hp;
    private int armor;
    private float power;

    public EntityCls(String unitName, int hp, int armor, float power){

        this.name = unitName;
        this.hp = hp;
        this.armor = armor;
        this.power = power;
    }

    public int getHP(){return this.hp;}
    public int getARmor(){return this.armor;}
    public float getPOwer(){return this.power;}
    public void setPOwer(float power){this.power = power;}
    public String getNAme(){return this.name;}
}
