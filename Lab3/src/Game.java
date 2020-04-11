import Heroes.*;

class Game {

    public static void main(String[] args){

        Squad squad = new Squad();

        squad.addComponent(new Troll(15,15,15));
        squad.addGroupOfUnits(new Troll(50,15,20), 20);
        squad.getStatus();

    }
}
