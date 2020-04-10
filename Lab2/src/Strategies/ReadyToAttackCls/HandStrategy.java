package Strategies.ReadyToAttackCls;
import Strategies.ReadyToAttackStrategy;

public class HandStrategy implements ReadyToAttackStrategy {
    @Override
    public void readyToAttack(){
        System.out.println("*hand swing sound*");
    }
}
