package Heroes;

public class EntityCls {

    public String name;
    private int hp;
    private int armor;
    private int damadge;

    public EntityCls(String name, int hp, int armor, int damadge){

        this.name = name;
        this.hp = hp;
        this.armor = armor;
        this.damadge = damadge;
    }

    public EntityCls(){

    }

    public int getHP(){return this.hp;}
    public int getARmor(){return this.armor;}
    public int getDAmadge(){return this.damadge;}
    public String getNAme(){return this.name;}
}
