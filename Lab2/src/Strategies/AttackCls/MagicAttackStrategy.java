package Strategies.AttackCls;
import Strategies.AttackStrategy;

public class MagicAttackStrategy implements AttackStrategy {
    @Override
    public boolean attack(){
        int tryAttack = (int)(Math.random()*2);
        if(tryAttack==1){
            System.out.println("Fireball launching");
            return true;
        }
        else {
            System.out.println("*Missed*");
            return false;
        }
    }
}
