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
    boolean[][] flags = new boolean[n][m];
    ArrayList<Pair<Integer, Integer>> lst = new ArrayList<Pair<Integer, Integer>>();

    @FXML
    void initialize() {

        placeBombs();

        for (int i = 0;i<MyGrid.getRowCount();i++){
            for(int j = 0;j<MyGrid.getColumnCount();j++){

                ImageView imageView = new ImageView();
                imageView.setFitHeight(sizeOfImage);
                imageView.setFitWidth(sizeOfImage);
                Image image = new Image("/sample/Images/closed.png");

                imageView.setOnMousePressed(mouseEvent -> {

                    if(mouseEvent.getButton() == MouseButton.PRIMARY){
                        Image newImage = new Image("/sample/Images/opened.png");
                        imageView.setImage(newImage);

                    }
                    else if(mouseEvent.getButton() == MouseButton.SECONDARY){
                        
                        Image newImage = new Image("/sample/Images/flaged.png");
                        if(flags[GridPane.getColumnIndex(imageView)][GridPane.getRowIndex(imageView)]){
                            imageView.setImage(new Image("/sample/Images/closed.png"));
                            flags[GridPane.getColumnIndex(imageView)][GridPane.getRowIndex(imageView)] = false;
                        }
                        else{
                            imageView.setImage(newImage);
                            flags[GridPane.getColumnIndex(imageView)][GridPane.getRowIndex(imageView)] = true;
                        }

                    }
                    imageView.setFitWidth(sizeOfImage);
                    imageView.setFitHeight(sizeOfImage);
                });

                imageView.setOnMouseReleased(mouseEvent -> {

                    if(mouseEvent.getButton()== MouseButton.PRIMARY){

                        if(grid[GridPane.getColumnIndex(imageView)][GridPane.getRowIndex(imageView)]){
                            openBombs();
                        }
                        else{
                            Image newImage = new Image("/sample/Images/opened.png");
                            imageView.setImage(newImage);
                        }
                        imageView.setFitWidth(sizeOfImage);
                        imageView.setFitHeight(sizeOfImage);
                    }
                });

                imageView.setImage(image);
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
            imageView.setImage(new Image("/sample/Images/bombed.png"));
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
