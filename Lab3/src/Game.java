import Heroes.*;

class Game {

    public static void main(String[] args){

        Squad squad = new Squad("Main");
        Squad squad1 = new Squad("Alfa");
        Squad squad2 = new Squad("Beta");

        squad1.addComponent(new Knight("knight",100,20,15));
        squad2.addGroupOfUnits(new Ork("ork",55,10,10),15);

        squad1.getStatus();

        squad2.getStatus();

        squad1.addComponent(squad2);

        squad.addComponent(squad1);
        squad.addGroupOfUnits(new Troll("troll",50,15,20), 10);

        squad.getStatus();

    }
}
