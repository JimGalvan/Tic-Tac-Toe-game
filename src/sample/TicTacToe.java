package sample;

public class TicTacToe {

    private String currentPlayer = "X";

    public String getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(String currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void switchPlayers(){
       if (currentPlayer == "X") this.setCurrentPlayer("O");
       else if (currentPlayer == "O") this.setCurrentPlayer("X");

    }

}
