/*
File: Game.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
Desc: game file is the file responsible of dealing with the game in action
anything from current game stats to who won the game is inside the file game.
 */


package com.example.tic_tac_toe_shipt;

public class Game {

    private Player player1;
    private Player player2;
    private int turn;
    private Player playerTurn;
    private Bored bored;

    public Game() {
        //empty constructor
    }

    //default settings for starting the game
    public Game(Bored bored, Player player1, Player player2) {
        this.bored = bored;
        this.player1 = player1;
        this.player2 = player2;
        this.turn = 0;
        this.playerTurn = player1;
    }

    /*
     game object setter and getters
    */

    public int[] getBored() {
        return bored.getBored();
    }

    public void setBored(int[] bored) {
        this.bored.setBored(bored);
    }

    public Player getPlayer1() {
        return player1;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public int getTurn() {
        return turn;
    }
    public String getPlayerTurnName() {
        return playerTurn.getPlayerName();
    }
    public Player getPlayerTurn() {
        return playerTurn;
    }

    public void setTurn(int turn) {
        this.turn = turn;
    }

    //what player is playing right now
    public void setPlayerTurn() {
        if(turn == 1 || turn ==3 || turn == 5 || turn == 7){
            this.playerTurn = player2;
        }else{
            this.playerTurn = player1;
        }
    }

    // check if player won
    public boolean winChecker(int[] bored,int playericon){
        boolean result = false;
        result = checkVertical(bored,playericon);
        if(checkVertical(bored,playericon) == true){
            result = true;
        }else if (checkHorizontal(bored,playericon) == true){
            result = true;
        }else if (checkDiagonal(bored,playericon) == true) {
            result = true;
        }else{
            result = false;
        }return result;
    }

    //check vertical win
    // checks the column for a winning combination.
    public boolean checkVertical(int[] bored,int playericon) {
        boolean result = false;
        if ((bored[0] == playericon && bored[3] == playericon && bored[6] == playericon)
                || (bored[1] == playericon && bored[4] == playericon && bored[7] == playericon)
                || (bored[2] == playericon && bored[5] == playericon && bored[8] == playericon))
        {
            result = true;
        }else{
            result = false;
        }return result;
    }

    //check Horizontal win
    // checks the row for a winning combination.
    public boolean checkHorizontal(int[] bored,int playericon) {
        boolean result = false;
        if ((bored[0] == playericon && bored[1] == playericon && bored[2] == playericon)
                || (bored[3] == playericon && bored[4] == playericon && bored[5] == playericon)
                || (bored[6] == playericon && bored[7] == playericon && bored[8] == playericon))
        {
            result = true;
        }else{
            result = false;
        }return result;
    }

    //check diagonal  win
    //checks the diagonal combinations for a winning combination.
    public boolean checkDiagonal (int[] bored,int playericon) {
        boolean result = false;
        if ((bored[2] == playericon && bored[4] == playericon && bored[6] == playericon)
                || (bored[0] == playericon && bored[4] == playericon && bored[8] == playericon))
        {
            result = true;
        }else{
            result = false;
        }return result;
    }
}
