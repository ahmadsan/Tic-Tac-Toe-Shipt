/*
File: ActivityNames.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
Des: test each method and make sure everything is working properly.
 */
package com.example.tic_tac_toe_shipt;

import org.junit.Test;

import static org.junit.Assert.*;

public class PlayerTest {

    @Test
    public void getPlayerName() {
        Player playerTest = new Player("ahmad",1);
        assertEquals(playerTest.getPlayerName(), "ahmad");
    }

    @Test
    public void setPlayerName() {
        Player playerTest = new Player("ahmad",1);
        playerTest.setPlayerName("max");
        assertEquals(playerTest.getPlayerName(), "max");

    }

    @Test
    public void getPlayericon() {
        Player playerTest = new Player("ahmad",1);
        assertEquals(playerTest.getPlayericon(), 1);

    }

    @Test
    public void setPlayericon() {
        Player playerTest = new Player("ahmad",1);
        playerTest.setPlayericon(2);
        assertEquals(playerTest.getPlayericon(), 2);
    }
}