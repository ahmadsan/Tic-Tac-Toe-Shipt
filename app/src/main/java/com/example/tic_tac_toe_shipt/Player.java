/*
File: player.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
Desc: create a object player
 */

package com.example.tic_tac_toe_shipt;

public class Player {

    private String playerName;
    private int playericon;



    public Player(){
        //empty constructor
    }

    public Player(String playerName, int playericon){
        this.playerName = playerName;
        this.playericon = playericon;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayericon() {
        return playericon;
    }

    public void setPlayericon(int playericon) {
        this.playericon = playericon;
    }

}
