import Strategies.AttackCls.*;
import Strategies.GoCls.*;
import Strategies.ReadyToAttackCls.*;

class Main {

    public static void main(String[] args) {

        Entity ork = new Entity(50,50,
                     new LandGoStrategy(),
                     new SwordAttackStrategy(),
                     new SwordStrategy());

        Entity troll = new Entity(50,50,
                       new LandGoStrategy(),
                       new HandAttackStrategy(),
                       new HandStrategy());

        Entity elf = new Entity(40,15,
                     new LandGoStrategy(),
                     new BowlAttackStrategy(),
                     new BowlStrategy());

        Entity vampire = new Entity(65, 15,
                         new HybridGoStrategy(),
                         new BiteAttackStrategy(),
                         new BiteStrategy());

        Entity wizard = new Entity(30, 20,
                        new MagicGoStrategy(),
                        new MagicAttackStrategy(),
                        new MagicStrategy());



        fight(troll,ork);
    }

    public static void fight(Entity hero1, Entity hero2){
        while (hero1.getHp()>0 || hero2.getHp()>0){
            if(hero1.attack()){
                hero2.setHp(hero2.getHp()-hero1.getDamadge());
                if(hero2.getHp()<=0){break;}
            }
            if(hero2.attack()){
                hero1.setHp(hero1.getHp()-hero2.getDamadge());
                if(hero1.getHp()<=0){break;}
            }
        }
        if(hero1.getHp()<=0){System.out.println("second won");}
        else{
            System.out.println("first won");
        }
    }

}
