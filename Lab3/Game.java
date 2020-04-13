import Heroes.*;

class Game {

    public static void main(String[] args){

        Squad squad = new Squad("Main");

        Squad squad1 = new Squad("Alfa");
        Squad squad2 = new Squad("Beta");

        squad1.addGroupOfUnits(new Elf("elf",5,5,5),50);
        squad1.setName("cats");

        squad1.getStatus();

        squad2.addGroupOfUnits(new Knight("knight",100,100,100),50);
        squad2.getStatus();

        squad.addUnit(squad1);
        squad.addUnit(squad2);
        squad.setArmor("cats",10);
        squad.getStatus();
    }
}
