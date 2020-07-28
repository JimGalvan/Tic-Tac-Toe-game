package sample;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {

    TicTacToe game;

    @FXML
    private Button button1;

    @FXML
    private Button button2;

    @FXML
    private Button button3;

    @FXML
    private Button button5;

    @FXML
    private Button button4;

    @FXML
    private Button button7;

    @FXML
    private Button button6;

    @FXML
    private Button button8;

    @FXML
    private Button button9;

    @FXML
    private Button resetButton;

    @FXML
    private Label playerLabel;

    @FXML
    public void initialize() {
        game = new TicTacToe();
    }

    @FXML
    void setValue(ActionEvent event) {

        updatePlayerLabel();
        if (event.getSource() == resetButton) resetButtonValues();

        setBox(event, button1, 1);
        setBox(event, button2, 2);
        setBox(event, button3, 3);
        setBox(event, button4, 4);
        setBox(event, button5, 5);
        setBox(event, button6, 6);
        setBox(event, button7, 7);
        setBox(event, button8, 8);
        setBox(event, button9, 9);
    }

    // Helper method to avoid duplicated code and set values to Box
    void setBox(Event event, Button button, int buttonID) {
        if (event.getSource() == button) {

            if (game.setBoxValue(buttonID)) {
                System.out.println(game.getCurrentPlayer());
                button.setText(game.getCurrentPlayer());
                game.checkGame();
                game.switchPlayers();
            }
            // check if games is finished, if so, reset Box values,
            // and button values
            if (game.getGameState()){
                resetButtonValues();
                updatePlayerLabel();
                game.setGameFinished(false);
            }
        }
    }

    public void resetButtonValues(){
        button1.setText(null);
        button2.setText(null);
        button3.setText(null);
        button4.setText(null);
        button5.setText(null);
        button6.setText(null);
        button7.setText(null);
        button8.setText(null);
        button9.setText(null);

        game.resetBoxes();
    }

    void updatePlayerLabel(){
        playerLabel.setText(" " + game.getCurrentPlayer());
    }
}

