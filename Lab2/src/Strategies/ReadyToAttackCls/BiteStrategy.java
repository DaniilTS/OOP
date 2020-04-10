package Strategies.ReadyToAttackCls;
import Strategies.ReadyToAttackStrategy;

public class BiteStrategy implements ReadyToAttackStrategy {
    @Override
    public void readyToAttack(){
        System.out.println("*sound of jaws opening*");
    }
}
