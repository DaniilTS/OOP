package Strategies.ReadyToAttackCls;
import Strategies.ReadyToAttackStrategy;

public class SwordStrategy implements ReadyToAttackStrategy {
    @Override
    public void readyToAttack(){
        System.out.println("*scabbard sound*");
    }
}
