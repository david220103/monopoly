package com.monopoly.monopoly;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class GameBoardController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}