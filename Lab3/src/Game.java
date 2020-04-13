import Heroes.*;

class Game {

    public static void main(String[] args){

        Squad squad = new Squad("Main");

        Squad squad1 = new Squad("Alfa");
        Squad squad2 = new Squad("Beta");

        squad1.addGroupOfUnits(new Elf("elf",5,5,5),50);
        //squad1.battleMarch();
        squad1.getStatus();
        squad1.battleCry();
        squad2.addGroupOfUnits(new Knight("knight",100,100,100),50);

        squad.addComponent(squad1);
        squad.addComponent(squad2);
        squad.getStatus();
       // squad.battleCry();
    }
}
