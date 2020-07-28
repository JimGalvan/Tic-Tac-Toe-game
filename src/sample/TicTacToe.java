package sample;

import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;

import java.util.HashMap;
import java.util.Optional;

public class TicTacToe {

    private HashMap<Integer, Box> list
            = new HashMap<>() {{
        put(1, new Box());
        put(2, new Box());
        put(3, new Box());
        put(4, new Box());
        put(4, new Box());
        put(5, new Box());
        put(6, new Box());
        put(7, new Box());
        put(8, new Box());
        put(9, new Box());
    }};

    private String currentPlayer = "X";
    private boolean gameFinished = false;
    private boolean isGridFull = false;
    private  Controller controller = new Controller();

    public boolean setBoxValue(int id) {
        // Check if current value in box is empty and set
        // a value (player) to Box
        if (list.get(id).getValue() == null) {
            list.get(id).setValue(currentPlayer);
            return true;
        }
        return false;
    }

    public void switchPlayers() {
        if (currentPlayer == "X") this.setCurrentPlayer("O");
        else if (currentPlayer == "O") this.setCurrentPlayer("X");
    }

    void checkBoxes(int first, int second, int three) {
        // Check combinations
        if (list.get(first).getValue() == currentPlayer & list.get(second).getValue() == currentPlayer &
                list.get(three).getValue() == currentPlayer) {

            setGameFinished(true);
            showOptions();
            resetBoxes();
        }
    }

    public void resetBoxes() {
        for (int i = 0; i <= list.size() ; i++) {
            if (list.get(i) != null) {
                list.get(i).setValue(null);
            }
        }
    }

    void showOptions() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText("Winner is " + currentPlayer);
        alert.setContentText("Select player to start: ");

        ButtonType buttonX = new ButtonType("X");
        ButtonType buttonO = new ButtonType("O");

        alert.getButtonTypes().setAll(buttonX, buttonO);
        Optional<ButtonType> result = alert.showAndWait();

        if (result.get() == buttonO) {
            currentPlayer = "O";
            controller.updatePlayerLabel();

        } else if (result.get() == buttonX) {
            currentPlayer = "X";
            controller.updatePlayerLabel();
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

    public void setGameFinished(boolean value) {
        this.gameFinished = value;
    }

    public boolean getGameState() {
        return gameFinished;
    }

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
