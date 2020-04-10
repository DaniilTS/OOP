package Strategies.ReadyToAttackCls;
import Strategies.ReadyToAttackStrategy;

public class MagicStrategy implements ReadyToAttackStrategy {
    @Override
    public void readyToAttack(){
        System.out.println("*sound of making a fireball*");
    }
}
