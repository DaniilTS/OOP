package Heroes;

public class EntityCls {

    private int hp;
    private int armor;
    private int damadge;

    public EntityCls(int hp, int armor, int damadge){

        this.hp = hp;
        this.armor = armor;
        this.damadge = damadge;
    }

    public EntityCls(){

    }

    public int getHp(){return this.hp;}
    public int getARmor(){return this.armor;}
    public int getDAmadge(){return this.damadge;}
}
