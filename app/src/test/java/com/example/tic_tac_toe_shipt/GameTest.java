package com.example.tic_tac_toe_shipt;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

public class GameTest {
    Player player1 = new Player("ahmad",1);
    Player player2 = new Player("max",2);
    int[] bored = {0,0,0,0,0,0,0,0,0};
    int turn = 0;
    private Player playerTurn;
    Game gameTest = new Game(bored, player1, player2);

    @Test
    public void getBored() {
        int[] actualArray = {0,0,0,0,0,0,0,0,0};
        assertArrayEquals(gameTest.getBored(),actualArray);
    }

    @Test
    public void setBored() {
        int[] actualArray = {0,1,0,0,0,0,0,0,0};
        gameTest.setBored(actualArray);
        assertArrayEquals(gameTest.getBored(),actualArray);
    }

    @Test
    public void getPlayer1() {
        //Testing objects is tricky !!
        Player playerTest = new Player("ahmad",1);
        assertEquals(gameTest.getPlayer1().getPlayerName(),playerTest.getPlayerName());
    }

    @Test
    public void setPlayer1() {
        Player playerTest = new Player("May",1);
        gameTest.setPlayer1(playerTest);
        assertEquals(gameTest.getPlayer1().getPlayerName(),playerTest.getPlayerName());
    }

    @Test
    public void getPlayer2() {
        //Testing objects is tricky !!
        Player playerTest = new Player("max",1);
        assertEquals(gameTest.getPlayer2().getPlayerName(),playerTest.getPlayerName());
    }

    @Test
    public void setPlayer2() {
        Player playerTest = new Player("May",1);
        gameTest.setPlayer2(playerTest);
        assertEquals(gameTest.getPlayer2().getPlayerName(),playerTest.getPlayerName());
    }

    @Test
    public void getTurn() {
        //by default game turn is set to 0 so we should expect a 0
        int testTurn = 0;
        assertEquals(gameTest.getTurn(), testTurn);
    }

    @Test
    public void getPlayerTurnName() {
        //by default player 1 should start every game
        //above our player1 name was ahmad
        String playerTestName = "ahmad";
        assertEquals(gameTest.getPlayerTurnName(),playerTestName);
    }

    @Test
    public void getPlayerTurn() {
        //by default player 1 should start every game
        //above our return variable should be a object player with similar name to player1
        Player playerTest = new Player("ahmad",1);
        assertEquals(gameTest.getPlayerTurn().getPlayerName(),playerTest.getPlayerName());
    }

    @Test
    public void setTurn() {
        int testTurn = 3;
        gameTest.setTurn(testTurn);
        assertEquals(gameTest.getTurn(),3);

    }

    @Test
    public void setPlayerTurn() {
        // This method is going to return object of the player with the corresponding turn
        //so if we set turn to 1 we should expect player2
        //of if we set turn to 0 we should expect player1
        gameTest.setTurn(1);
        gameTest.setPlayerTurn();
        assertEquals(gameTest.getPlayerTurn().getPlayerName(),"max");

    }


    @Test
    public void winChecker() {
        //winCheck method takes in int array aka bored
        //and player icon aka int 1 for player 1 and 2 for player 2
        int[] boredtest = {2,2,2,0,0,0,0,0,0};
        int playericon = gameTest.getPlayer2().getPlayericon();
        //the above bored should present vertical win for player 2
        boolean expected = gameTest.winChecker(boredtest,playericon);
        assertEquals(expected, true);

        //Horizontal win
        int[] boredtest2 = {1,1,1,0,0,0,0,0,0};
        int playericon2 = gameTest.getPlayer1().getPlayericon();
        //the above bored should present vertical win for player 2
        boolean expected2 = gameTest.winChecker(boredtest,playericon);
        assertEquals(expected, true);

        //Diagonal win
        int[] boredtest3 = {1,0,0,0,1,0,0,0,1};
        int playericon3 = gameTest.getPlayer1().getPlayericon();
        //the above bored should present vertical win for player 2
        boolean expected3 = gameTest.winChecker(boredtest,playericon);
        assertEquals(expected, true);
    }

    @Test
    public void checkVertical() {
        /*
          2|_|_
          2|1|_
          2|1|_
         */
        //in this case we have a vertical win but for player 2 not one this should return false
        int[] boredtest = {2,0,0,2,1,0,2,1,0};
        int playericon = gameTest.getPlayer1().getPlayericon();
        //the above bored should present vertical win for player 2
        boolean expected = gameTest.checkVertical(boredtest,playericon);
        assertEquals(expected, false);

    }

    @Test
    public void checkHorizontal() {
        /*
          1|1|1
          _|_|_
          _|_|_
         */
        //Horizontal win
        int[] boredtest = {1,1,1,0,0,0,0,0,0};
        int playericon = gameTest.getPlayer1().getPlayericon();
        //the above bored should present Horizontal win for player 2
        boolean expected = gameTest.checkHorizontal(boredtest,playericon);
        assertEquals(expected, true);
    }

    @Test
    public void checkDiagonal() {
        //Diagonal win
        /*
          _|_|1
          _|1|_
          1|_|_
         */
        int[] boredtest = {0,0,1,0,1,0,1,0,0};
        int playericon = gameTest.getPlayer1().getPlayericon();
        //the above bored should present Diagonal win for player 2
        boolean expected = gameTest.checkDiagonal(boredtest,playericon);
        assertEquals(expected, true);
    }
}