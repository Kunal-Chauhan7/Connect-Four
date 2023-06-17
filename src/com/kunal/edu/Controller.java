package com.kunal.edu;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class Controller implements Initializable{

    private static final int ROWS = 6;
    private static final int COLUMS = 7;
    private static final int DISCRADIUS = 80;
    private static final String PlayerOneDiscColour = "#FF0800";
    private static final String PlayerTwoDiscColour = "#FFFFC2";

    private boolean isPlayerOneTurn = true;

    private static String PlayerOneName = "Player One";
    private static String PlayerTwoName = "Player Two";


    @FXML
    public GridPane rootGridPane;

    @FXML
    public Pane InsertedDiscPane;

    @FXML
    public Label PlayerNameLabel;

    public void createplayground(){
        Shape rectangle_with_holes = CreateGridStruct();
        List<Rectangle> rectangle_click_list = create_clickable_rectangle();
        rootGridPane.add(rectangle_with_holes,0,1);
        for (Rectangle rec:rectangle_click_list) {
            rootGridPane.add(rec,0,1);
        }
    }

    private Shape CreateGridStruct(){
        Shape rectangle_with_holes = new Rectangle((COLUMS+1) * DISCRADIUS,(ROWS+1)*DISCRADIUS);

        for (int row = 0; row < ROWS; row++) {
            for (int col = 0; col < COLUMS; col++) {
                Circle circle = new Circle();
                circle.setRadius(DISCRADIUS/2);
                circle.setCenterX(DISCRADIUS/2);
                circle.setCenterY(DISCRADIUS/2);

                circle.setTranslateX(col * (DISCRADIUS+5) + DISCRADIUS/4);
                circle.setTranslateY(row * (DISCRADIUS+5) + DISCRADIUS/4);

                rectangle_with_holes = Shape.subtract(rectangle_with_holes,circle);
            }
        }

        rectangle_with_holes.setFill(Color.WHITE);

        return rectangle_with_holes;
    }

    private List<Rectangle> create_clickable_rectangle(){
        List<Rectangle> rectangleArrayList = new ArrayList<>();
        for (int col = 0; col < COLUMS; col++) {
            Rectangle rectangle = new Rectangle(DISCRADIUS,(ROWS + 1) * DISCRADIUS);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setTranslateX(col * (DISCRADIUS+5) + DISCRADIUS/4);

            rectangle.setOnMouseEntered(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    rectangle.setFill(Color.valueOf("#eeeeee26"));
                }
            });

            rectangle.setOnMouseExited(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    rectangle.setFill(Color.TRANSPARENT);
                }
            });

            final int column = col;

            rectangle.setOnMouseClicked(event -> {
                insertdisc(new Disc(isPlayerOneTurn),column);
            });

            rectangleArrayList.add(rectangle);
        }
        return rectangleArrayList;
    }

    private static void insertdisc(Disc disc , int colum){

    }

    private static class Disc extends Circle{

        private final boolean IsPlayerOneMove;

        public Disc(boolean IsPlayerOneMove){
            this.IsPlayerOneMove = IsPlayerOneMove;

            setRadius(DISCRADIUS/2);
            setFill(IsPlayerOneMove?Color.valueOf(PlayerOneDiscColour):Color.valueOf(PlayerTwoDiscColour));
            setCenterX(DISCRADIUS/2);
            setCenterY(DISCRADIUS/2);
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
