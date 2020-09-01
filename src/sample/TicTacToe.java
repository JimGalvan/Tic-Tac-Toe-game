package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.Optional;

public class TicTacToe {

    private final HashMap<Integer, Box> list
            = new HashMap<>();

    TicTacToe(){
        list.put(1, new Box());
        list.put(2, new Box());
        list.put(3, new Box());
        list.put(4, new Box());
        list.put(4, new Box());
        list.put(5, new Box());
        list.put(6, new Box());
        list.put(7, new Box());
        list.put(8, new Box());
        list.put(9, new Box());
    }

    private String currentPlayer = "X";
    private boolean gameFinished = false;

    public boolean checkIfBoxHasValue(int id) {
        // Check if current value in box is empty and set
        // a value (player) to Box
        if (list.get(id).getValue() == null) {
            return true;
        }
        return false;
    }

    public void setBoxValue(int id) {
        list.get(id).setValue(getCurrentPlayer());
    }

    public void switchPlayers() {
        if (!gameFinished) {
            if (currentPlayer == "X") this.setCurrentPlayer("O");
            else if (currentPlayer == "O") this.setCurrentPlayer("X");
        }
    }

    // check game combinations
     public void checkGame() {
        // flow check
        checkBoxes(1, 2, 3);
        checkBoxes(4, 5, 6);
        checkBoxes(7, 8, 9);

        // check columns
        checkBoxes(1, 4, 7);
        checkBoxes(2, 5, 8);
        checkBoxes(3, 6, 9);

        // diagonal rows
        checkBoxes(1, 5, 9);
        checkBoxes(7, 5, 3);
    }

    private void checkBoxes(int first, int second, int three) {
        // Check combinations
        if (list.get(first).getValue() == currentPlayer & list.get(second).getValue() == currentPlayer &
                list.get(three).getValue() == currentPlayer) {
            setGameFinished(true);
            showOptions();
            resetBoxes();
        }
    }

    private void showOptions() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Winner is player: " + currentPlayer);
        alert.setContentText("Select player to start: ");

        ButtonType buttonX = new ButtonType("X");
        ButtonType buttonO = new ButtonType("O");

        alert.getButtonTypes().setAll(buttonX, buttonO);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonO) {
            setCurrentPlayer("O");
        } else if (result.get() == buttonX) {
            setCurrentPlayer("X");
        }
    }

    public void resetBoxes() {
        for (int i = 0; i <= list.size() ; i++) {
            if (list.get(i) != null) {
                list.get(i).setValue(null);
            }
        }
    }

    public void setGameFinished(boolean value) {
        this.gameFinished = value;
    }

    public boolean isGameFinished() {
        return gameFinished;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
