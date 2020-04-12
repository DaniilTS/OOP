import Strategies.AttackCls.*;
import Strategies.GoCls.*;
import Strategies.ReadyToAttackCls.*;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class Game {

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

        Entity knight = new Entity("knight",70,20,
                        new LandGoStrategy(),new SwordAttackStrategy(),new SwordStrategy());


        ArrayList<Entity> heroesList = new ArrayList<Entity>();
        heroesList.add(ork);
        heroesList.add(troll);
        heroesList.add(elf);
        heroesList.add(vampire);
        heroesList.add(wizard);
        heroesList.add(knight);

        ArrayList<Pair<Entity,Entity>> lst = new ArrayList<Pair<Entity,Entity>>();
        while(!heroesList.isEmpty()){

            int rand1 = (int)(Math.random()*(heroesList.size()-1));
            Entity hero1 = heroesList.get(rand1);
            heroesList.remove(rand1);

            int rand2 = (int)(Math.random()*(heroesList.size()-1));
            Entity hero2 = heroesList.get(rand2);
            heroesList.remove(rand2);

            lst.add(new Pair<>(hero1,hero2));
        }

        fight(lst);
    }

    public static void fight(ArrayList<Pair<Entity,Entity>> lst) throws InterruptedException {

        while(!lst.isEmpty()){

            Entity hero1 = lst.get(0).getKey();
            Entity hero2 = lst.get(0).getValue();

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
                System.out.println(hero2.getName()+" won!!!!!!!!!!!");
                Thread.sleep(2000);
            }
            else{
                System.out.println(hero1.getName()+" won!!!!!!!!!!!!");
                Thread.sleep(2000);
            }

            lst.remove(0);
            System.out.println("///////////////////////////\n" +
                               "///////////////////////////");
        }

    }

}
