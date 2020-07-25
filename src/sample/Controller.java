package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

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
    public void initialize() {

        game = new TicTacToe();
    }

    @FXML
    void setValue(ActionEvent event) {
        if (event.getSource() == button1){
                button1.setText(game.getCurrentPlayer());
                game.switchPlayers();
        } else if (event.getSource() == button2){

            button2.setText(game.getCurrentPlayer());
            game.switchPlayers();

        } else if (event.getSource() == button3){
            button3.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button4){
            button4.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button5){
            button5.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button6){
            button6.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button7){
            button7.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button8){
            button8.setText(game.getCurrentPlayer());
            game.switchPlayers();
        } else if (event.getSource() == button9){
            button9.setText(game.getCurrentPlayer());
            game.switchPlayers();
        }
    }

}
