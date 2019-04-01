/*
File: ActivityNames.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
 */
package com.example.tic_tac_toe_shipt;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.tic_tac_toe_shipt.R.drawable;


public class ActionActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView playerturntextID;
    private Button startNewGame;

    private Button b00;
    private Button b01;
    private Button b02;

    private Button b10;
    private Button b11;
    private Button b12;

    private Button b20;
    private Button b21;
    private Button b22;

    private String player1Name;
    private String player2Name;

    private Player player1;
    private Player player2;

    private Bored bored;
    private int[] defBored = {0,0,0,0,0,0,0,0,0};
    private Game game;

    private int turn_counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_action);

        //handle data from activity before.
        Bundle extraData = getIntent().getExtras();

        playerturntextID = (TextView) findViewById(R.id.playerturntextID);

        b00 = (Button) findViewById(R.id.b00);
        b01 = (Button) findViewById(R.id.b01);
        b02 = (Button) findViewById(R.id.b02);

        b10 = (Button) findViewById(R.id.b10);
        b11 = (Button) findViewById(R.id.b11);
        b12 = (Button) findViewById(R.id.b12);

        b20 = (Button) findViewById(R.id.b20);
        b21 = (Button) findViewById(R.id.b21);
        b22 = (Button) findViewById(R.id.b22);

        startNewGame = (Button) findViewById(R.id.startNewGamebuttonID);

        if(extraData != null){
            player1Name = extraData.getString("player1");
            player2Name = extraData.getString("player2");
            Log.d("players name is in ", "player 1 and 2 names is in");
        }


        b00.setOnClickListener(this);
        b01.setOnClickListener(this);
        b02.setOnClickListener(this);

        b10.setOnClickListener(this);
        b11.setOnClickListener(this);
        b12.setOnClickListener(this);

        b20.setOnClickListener(this);
        b21.setOnClickListener(this);
        b22.setOnClickListener(this);

        startNewGame.setOnClickListener(this);

        // Create player 1 and player 2
        player1 = new Player(player1Name, 1);
        player2 = new Player(player2Name, 2);

        // Create New Game with bored and player 1 and player 2
        bored = new Bored(defBored);
        game = new Game(bored, player1,player2);
        turn_counter = game.getTurn();
        playerturntextID.setText(game.getPlayerTurnName() + " : Turn !!");

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.b00:
                //set the background to x or o depending on player turn and name
                setIcon(b00);
                //add position to bored
                addClickToBored(0);
                //check for winner
                checkWin();
                //increment player turn
                game.setTurn((game.getTurn() + 1));
                //change textview of player name turn to the next player
                setPlayerTurnName();
                //break out of the switch statement
                break;
            case R.id.b01:
                setIcon(b01);
                addClickToBored(1);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b02:
                setIcon(b02);
                addClickToBored(2);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b10:
                setIcon(b10);
                addClickToBored(3);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b11:
                setIcon(b11);
                addClickToBored(4);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b12:
                setIcon(b12);
                addClickToBored(5);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b20:
                setIcon(b20);
                addClickToBored(6);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b21:
                setIcon(b21);
                addClickToBored(7);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            case R.id.b22:
                setIcon(b22);
                addClickToBored(8);
                checkWin();
                game.setTurn((game.getTurn() + 1));
                setPlayerTurnName();
                break;
            //if Start new game clicked restart this activate
            case R.id.startNewGamebuttonID:
                if(game.getTurn() <= 0){
                    Toast.makeText(this,"This is a Brand new game",Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(ActionActivity.this, ActionActivity.class);
                    intent.putExtra("player1",(player1.getPlayerName()));
                    intent.putExtra("player2",(player2.getPlayerName()));
                    startActivity(intent);
                    finish();
                }
        }
    }
    //set up player name and change textview to the next player name
    public void setPlayerTurnName(){
        game.setPlayerTurn();
        String playerTurnName = game.getPlayerTurnName();
        playerturntextID.setText(playerTurnName + " : Turn !!");
    }

    //set the image on the position the player clicked on depending on which player clicked
    public void setIcon(Button buttonPlayed){
        if(game.getPlayerTurn() == player1){
            buttonPlayed.setBackgroundResource(drawable.o);
            buttonPlayed.setEnabled(false);
        }
        else{
            buttonPlayed.setBackgroundResource(drawable.cross);
            buttonPlayed.setEnabled(false);
        }
    }

    public void addClickToBored(int buttonnumber){
      int[] currentbored = game.getBored();

      /*
       1. check if button was played before
       2. if button was not played change the
             index of bored that match the button to player icon number
      */
      if(currentbored[buttonnumber] == 0) {
          Player currentPlayer = game.getPlayerTurn();
          currentbored[buttonnumber] = currentPlayer.getPlayericon();
          game.setBored(currentbored);
      }
    }
    //check if player win the game
    public void checkWin(){
        boolean result = false;
        if(game.getTurn() > 3){
            Player currentPlayer = game.getPlayerTurn();
            int playernumber = currentPlayer.getPlayericon();
            result = game.winChecker(game.getBored(),playernumber);
            if(result == true) {
                setWinMsgBox(currentPlayer.getPlayerName() + " Is victorious :)","WIN");
            }else if(game.getTurn() == 8 && result == false){
                setWinMsgBox("Too bad it is a draw, No one out smarted the other -_-","DRAW");
            }else{}
        }else{
            result =  false;
        }
    }

    public void setWinMsgBox(String message,String title){

        AlertDialog.Builder winMsgBox = new AlertDialog.Builder(ActionActivity.this);
        View mView = getLayoutInflater().inflate(R.layout.match_result_layout,null);
        TextView msgText1 = (TextView) mView.findViewById(R.id.alertMsgTextV1ID);
        TextView msgText2 = (TextView) mView.findViewById(R.id.alertMsgTextV2ID);
        winMsgBox.setCancelable(false);
        msgText1.setText(title);
        msgText2.setText(message);
        Button msgPlayAgainBtn = (Button) mView.findViewById(R.id.alertMsgBtnP);
        Button msgQuitBtn = (Button) mView.findViewById(R.id.alertMsgBtnQ);
        msgPlayAgainBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActionActivity.this, ActionActivity.class);
                intent.putExtra("player1",(player1.getPlayerName()));
                intent.putExtra("player2",(player2.getPlayerName()));
                startActivity(intent);
                finish();
            }
        });
        msgQuitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        winMsgBox.setView(mView);
        winMsgBox.create().show();
    }
}
