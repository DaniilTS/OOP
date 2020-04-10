import Strategies.AttackCls.*;
import Strategies.GoCls.*;
import Strategies.ReadyToAttackCls.*;

class Main {

    public static void main(String[] args) throws InterruptedException {

        Entity ork = new Entity("ork", 200,50,
                     new LandGoStrategy(), new SwordAttackStrategy(), new SwordStrategy());

        Entity troll = new Entity("troll", 200,50,
                       new LandGoStrategy(), new HandAttackStrategy(), new HandStrategy());

        Entity elf = new Entity("elf",40,15,
                     new LandGoStrategy(), new BowlAttackStrategy(), new BowlStrategy());

        Entity vampire = new Entity("vampire",60, 15,
                         new HybridGoStrategy(), new BiteAttackStrategy(), new BiteStrategy());

        Entity wizard = new Entity("wizard",40, 30,
                        new MagicGoStrategy(), new MagicAttackStrategy(), new MagicStrategy());


        fight(troll,ork);
        fight(wizard,vampire);
    }

    public static void fight(Entity hero1, Entity hero2) throws InterruptedException {
        while (hero1.getHp()>0 && hero2.getHp()>0){
            System.out.println("//"+hero1.getName()+" HP = "+ hero1.getHp()+"//");
            System.out.println("//"+hero2.getName()+" HP = "+ hero2.getHp()+"//");
            if(hero1.attack()){
                hero2.setHp(hero2.getHp()-hero1.getDamadge());
            }
            Thread.sleep(2000);
            if(hero2.attack()){
                hero1.setHp(hero1.getHp()-hero2.getDamadge());
            }
            Thread.sleep(2000);
        }
        System.out.println("//"+hero1.getName()+" HP = "+ hero1.getHp()+"//");
        System.out.println("//"+hero2.getName()+" HP = "+ hero2.getHp()+"//");

        if(hero1.getHp()==hero2.getHp()){
            System.out.println("Dead heat!!!!!!!");
            Thread.sleep(2000);
        }
        else if(hero1.getHp()<=0){
            System.out.println(hero1.getName()+" won!!!!!!!!!!!");
            Thread.sleep(2000);
        }
        else{
            System.out.println(hero2.getName()+" won!!!!!!!!!!!!");
            Thread.sleep(2000);
        }
    }

}
