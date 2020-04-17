package sample;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
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
    Image closedCell = new Image("sample/Images/closed.png");
    Image openedCell = new Image("sample/Images/opened.png");
    Image flaggedCell = new Image("sample/Images/flaged.png");
    Image bombedCell = new Image("sample/Images/bombed.png");

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button StartButton;

    @FXML
    private Button SettingsButton;

    public int n = 9;
    public int m = 9;
    public int numOfMines = 10;
    public int sizeOfImage = 25;
    boolean[][] grid = new boolean[n][m];
    boolean[][] flaged = new boolean[n][m];
    boolean[][] opened = new boolean[n][m];
    ArrayList<Pair<Integer, Integer>> lst = new ArrayList<Pair<Integer, Integer>>();



    @FXML
    void initialize() {

        placeBombs();

        for (int i = 0;i<MyGrid.getRowCount();i++){
            for(int j = 0;j<MyGrid.getColumnCount();j++){

                ImageView imageView = new ImageView();
                imageView.setFitHeight(sizeOfImage);
                imageView.setFitWidth(sizeOfImage);

                imageView.setOnMousePressed(mouseEvent -> {

                    int columnIndex = GridPane.getColumnIndex(imageView);
                    int rowIndex = GridPane.getRowIndex(imageView);

                    if(mouseEvent.getButton() == MouseButton.PRIMARY){

                        imageView.setImage(openedCell);
                        opened[columnIndex][rowIndex]=true;
                    }
                    else if(mouseEvent.getButton() == MouseButton.SECONDARY){

                        if(flaged[columnIndex][rowIndex]&&(!opened[columnIndex][rowIndex])){

                            imageView.setImage(closedCell);
                            flaged[columnIndex][rowIndex] = false;
                        }
                        else{

                            imageView.setImage(flaggedCell);
                            flaged[columnIndex][rowIndex] = true;
                        }

                    }
                    imageView.setFitWidth(sizeOfImage);
                    imageView.setFitHeight(sizeOfImage);
                });

                imageView.setOnMouseReleased(mouseEvent -> {

                    int columnIndex = GridPane.getColumnIndex(imageView);
                    int rowIndex = GridPane.getRowIndex(imageView);

                    if(mouseEvent.getButton()== MouseButton.PRIMARY){

                        if(grid[columnIndex][rowIndex]){
                            openBombs();
                        }
                        else{

                            imageView.setImage(openedCell);
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

    private void placeBombs(){
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

    public void mousePressed(MouseEvent mouseEvent) {

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
        numOfMines = 10;
        lst.clear();
        placeBombs();
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
