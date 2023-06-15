package com.kunal.edu;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable{


    @FXML
    public GridPane rootGridPane;

    @FXML
    public Pane InsertedDiscPane;

    @FXML
    public Label PlayerNameLabel;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
