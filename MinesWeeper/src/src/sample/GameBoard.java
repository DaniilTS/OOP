package sample;

public class GameBoard {

    private int boardHeight;
    private int boardWidth;
    private int numOfMines;

    GameBoard(int boardHeight,int boardWidth,int numOfMines) {
        this.boardHeight = boardHeight;
        this.boardWidth = boardWidth;
        this.numOfMines = numOfMines;
    }

    public int getBoardHeight(){
        return this.boardHeight;
    }

    public void setBoardHeight(int boardHeight){
        this.boardHeight = boardHeight;
    }

    public int getBoardWidth(){
        return this.boardWidth;
    }

    public void setBoardWidth(int boardWidth){
        this.boardWidth = boardWidth;
    }

    public int getNumOfMines(){
        return this.numOfMines;
    }

    public void setNumOfMines(int numOfMines) {
        this.numOfMines = numOfMines;
    }

}
