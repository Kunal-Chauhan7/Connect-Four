package com.kunal.edu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

import java.net.URL;
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
        rootGridPane.add(rectangle_with_holes,0,1);
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
