/*
File: Bored.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
Desc: create a object Bored
 */

package com.example.tic_tac_toe_shipt;

public class Bored {

    private int[] bored;

    public Bored(){
        //empty constructor
    }

    public Bored(int[] bored){
        this.bored = bored;
    }

    public int[] getBored() {
        return bored;
    }

    public void setBored(int[] bored) {
        this.bored = bored;
    }

}
