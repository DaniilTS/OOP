import Strategies.*;


public class Entity {

    private int hp;
    private int damadge;
    private GoStrategy goStrategy;
    private AttackStrategy attackStrategy;
    private ReadyToAttackStrategy readyToAttackStrategy;

    public Entity(int hp,int damadge,
                  GoStrategy goStrategy,
                  AttackStrategy attackStrategy,
                  ReadyToAttackStrategy readyToAttackStrategy){

        this.hp = hp;
        this.damadge = damadge;
        this.goStrategy = goStrategy;
        this.readyToAttackStrategy = readyToAttackStrategy;
        this.attackStrategy = attackStrategy;
    }

    public void go(){
        this.goStrategy.go();
    }

    public boolean attack(){
        readyToAttack();
        this.attackStrategy.attack();
        return this.attackStrategy.attack();
    }

    public void readyToAttack(){
        this.readyToAttackStrategy.readyToAttack();
    }

    public void setGoStrategy(GoStrategy goStrategy){
        this.goStrategy = goStrategy;
    }

    public void setAttackStrategy(AttackStrategy attackStrategy){
        this.attackStrategy = attackStrategy;
    }

    public void setReadyToAttackStrategy(ReadyToAttackStrategy readyToAttackStrategy){this.readyToAttackStrategy = readyToAttackStrategy;}

    public int getHp() {return this.hp;}

    public int getDamadge() {return this.damadge;}

    public void setHp(int hp) { this.hp = hp;}

    public void setDamadge(int damadge) {this.damadge = damadge;}
}

