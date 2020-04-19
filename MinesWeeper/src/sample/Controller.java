package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class Controller {

    @FXML
    public ImageView MyImage;

    @FXML
    public GridPane MyGrid;

    Image buttonPressed = new Image("sample/Images/closed.png");
    Image buttonReleased = new Image("sample/Images/opened.png");
    Image closedCell = new Image("sample/Images/base.png");
    Image openedCell = new Image("sample/Images/opened.png");
    Image flagedCell = new Image("sample/Images/flag.png");
    Image bombedCell = new Image("sample/Images/bombed.png");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartButton;

    @FXML
    private Button SettingsButton;

    @FXML
    private TextField TextFieldForHeight;

    @FXML
    private TextField TextFieldForWidth;

    @FXML
    private TextField TextFieldForNumOfMines;

    public int sizeOfImage = 25;
    GameBoard gameBoard = new GameBoard(9,9,10);
    int n = gameBoard.getBoardHeight();
    int m =gameBoard.getBoardWidth();
    boolean[][] grid = new boolean[n][m];
    boolean[][] flaged = new boolean[n][m];
    boolean[][] opened = new boolean[n][m];
    ArrayList<Pair<Integer, Integer>> lst = new ArrayList<Pair<Integer, Integer>>();


    @FXML
    void initialize() {

        placeBombs(gameBoard.getNumOfMines());

        for (int i = 0;i<MyGrid.getRowCount();i++){
            for(int j = 0;j<MyGrid.getColumnCount();j++){

                ImageView imageView = new ImageView();
                imageView.setFitHeight(sizeOfImage);
                imageView.setFitWidth(sizeOfImage);

                imageView.setOnMousePressed(mouseEvent -> {

                    int columnIndex = GridPane.getColumnIndex(imageView);
                    int rowIndex = GridPane.getRowIndex(imageView);

                    if(mouseEvent.getButton() == MouseButton.PRIMARY){

                        if(!opened[columnIndex][rowIndex]) {
                            imageView.setImage(openedCell);
                        }
                    }
                    else if(mouseEvent.getButton() == MouseButton.SECONDARY){

                        if(!opened[columnIndex][rowIndex]&&flaged[columnIndex][rowIndex]){

                            imageView.setImage(closedCell);
                            flaged[columnIndex][rowIndex]=false;
                        }
                        else if(!opened[columnIndex][rowIndex]){

                            imageView.setImage(flagedCell);
                            flaged[columnIndex][rowIndex]=true;
                        }

                    }
                    imageView.setFitWidth(sizeOfImage);
                    imageView.setFitHeight(sizeOfImage);
                });

                imageView.setOnMouseReleased(mouseEvent -> {

                    int columnIndex = GridPane.getColumnIndex(imageView);
                    int rowIndex = GridPane.getRowIndex(imageView);

                    if(mouseEvent.getButton() == MouseButton.PRIMARY){

                        if(grid[columnIndex][rowIndex]){
                            openBombs();
                        }
                        else if(!opened[columnIndex][rowIndex]){
                            imageView.setImage(chekArround(columnIndex,rowIndex));
                            opened[columnIndex][rowIndex] = true;
                        }

                        imageView.setFitWidth(sizeOfImage);
                        imageView.setFitHeight(sizeOfImage);
                    }
                });

                imageView.setImage(closedCell);
                MyGrid.add(imageView,i,j);
            }
        }
    }

    private Image chekArround(int columnIndex, int rowIndex) {

        int counter = circleRun(columnIndex,rowIndex);

        String url;
        switch (counter){
            case 1: url = "sample/Images/1.png";break;
            case 2: url = "sample/Images/2.png";break;
            case 3: url = "sample/Images/3.png";break;
            case 4: url = "sample/Images/4.png";break;
            case 5: url = "sample/Images/5.png";break;
            case 6: url = "sample/Images/6.png";break;
            case 7: url = "sample/Images/7.png";break;
            case 8: url = "sample/Images/8.png";break;
            default:{

                url="sample/Images/opened.png";
                
                break;
            }
        }
        return new Image(url);
    }

    private void openBombs() {

        while(!lst.isEmpty()){

            int i = lst.get(0).getKey();
            int j = lst.get(0).getValue();
            ImageView imageView = (ImageView) getNodeFromGridPane(MyGrid,i,j);
            assert imageView != null;
            imageView.setImage(bombedCell);
            lst.remove(0);
        }
        MyGrid.setDisable(true);
    }

    private void placeBombs(int numOfMines){

        while(numOfMines>0){
            int i = (int) (Math.random() * n);
            int j = (int) (Math.random() * m);
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i,j);
            if(!lst.contains(pair)){
                lst.add(pair);
                grid[i][j] = true;
                numOfMines--;
            }
        }
    }

    private int circleRun(int columnIndex,int rowIndex){
        int counter=0;
        for(int i =-1;i<2;i++){
            for(int j = -1;j<2;j++){
                if((columnIndex-i>=gameBoard.getBoardWidth())||(columnIndex-i<0)
                        || (rowIndex-j>=gameBoard.getBoardHeight())||(rowIndex-j<0)){

                    continue;
                }
                if(grid[columnIndex-i][rowIndex-j]){
                    counter++;
                }
            }
        }
        return counter;
    }

    public void gameRestart(MouseEvent mouseEvent) {

        //MyGrid.setPrefHeight(275);
        MyImage.setImage(buttonReleased);
        MyGrid.setDisable(false);
        for (int i = 0;i<MyGrid.getRowCount();i++){
            for(int j = 0;j<MyGrid.getColumnCount();j++){

                grid[i][j] = opened[i][j] = flaged[i][j] = false;
                ImageView imageView = (ImageView) getNodeFromGridPane(MyGrid,i,j);
                assert imageView != null;
                imageView.setImage(closedCell);
            }
        }
        gameBoard.setNumOfMines(Integer.parseInt(TextFieldForNumOfMines.getText()));
        lst.clear();
        placeBombs(gameBoard.getNumOfMines());

    }

    public void mouseReleased(MouseEvent mouseEvent) {
        MyImage.setImage(buttonPressed);
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }
}
