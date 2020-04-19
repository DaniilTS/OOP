package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Pair;

public class Controller {

    @FXML
    private AnchorPane AnchorPane;

    @FXML
    public ImageView MyImage;

    @FXML
    private Button MyButton;

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
    int startH = 9;
    int startW = 9;
    double c = 25.0/2.0;

    ArrayList<Pair<Integer, Integer>> lst = new ArrayList<Pair<Integer, Integer>>();


    @FXML
    void initialize() {
        myInit(gameBoard.getBoardHeight(),gameBoard.getBoardWidth(),gameBoard.getNumOfMines());
    }

    private Image chekArround(int columnIndex, int rowIndex,boolean[][] grid) {

        int counter = circleRun(columnIndex,rowIndex,grid);

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

    private void placeBombs(int numOfMines, boolean[][] grid,int height,int width){

        while(numOfMines>0){
            int i = (int) (Math.random() * height);
            int j = (int) (Math.random() * width);
            Pair<Integer, Integer> pair = new Pair<Integer, Integer>(i,j);
            if(!lst.contains(pair)){
                lst.add(pair);
                grid[i][j] = true;
                numOfMines--;
            }
        }
    }

    private int circleRun(int columnIndex,int rowIndex, boolean[][] grid){
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

        MyImage.setImage(buttonReleased);
        MyGrid.setDisable(false);
        MyGrid.getChildren().clear();
        myInit(gameBoard.getBoardHeight(),gameBoard.getBoardWidth(),gameBoard.getNumOfMines());
    }

    public void mouseReleased(MouseEvent mouseEvent) {
        MyImage.setImage(new Image("sample/Images/smile.png"));
    }

    private Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
                return node;
            }
        }
        return null;
    }

    public void mousePressed(MouseEvent mouseEvent) {
        gameBoard.setBoardHeight(9);
        gameBoard.setBoardWidth(9);
        gameBoard.setNumOfMines(0);
        MyGrid.setDisable(false);
        MyGrid.getChildren().clear();
        myInit(gameBoard.getBoardHeight(),gameBoard.getBoardWidth(),gameBoard.getNumOfMines());
    }

    private void myInit(int height,int width, int numOfMines){

        AtomicInteger counter = new AtomicInteger(0);
        AtomicInteger dif = new AtomicInteger(height*width-numOfMines);
        boolean[][] grid = new boolean[height][width];
        boolean[][] flaged = new boolean[height][width];
        boolean[][] opened = new boolean[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                grid[i][j]=flaged[i][j]=opened[i][j]=false;
            }
        }

        placeBombs(numOfMines,grid,height,width);

        for (int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){

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
                            MyImage.setImage(new Image("sample/Images/deadSmile.png"));
                            Alert alert = new Alert(Alert.AlertType.INFORMATION);
                            alert.setTitle("The end");
                            alert.setHeaderText("Results:");
                            alert.setContentText("You lost!");
                            alert.showAndWait();
                        }
                        else if(!opened[columnIndex][rowIndex]){

                            if(counter.get()==dif.get()-1){

                                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                                alert.setTitle("The end");
                                alert.setHeaderText("Results:");
                                alert.setContentText("You won!");
                                alert.showAndWait();
                            }
                            counter.getAndIncrement();
                            imageView.setImage(chekArround(columnIndex,rowIndex,grid));
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
        MyGrid.setPrefSize(height*25,width*25);
    }
}