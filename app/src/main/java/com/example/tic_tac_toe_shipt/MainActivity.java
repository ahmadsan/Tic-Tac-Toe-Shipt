/*
File: MainActivity.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
 */
package com.example.tic_tac_toe_shipt;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {

    private Button startGameButton;
    private Button helpBtn;
    private Button quitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startGameButton = (Button) findViewById(R.id.startGameID);
        helpBtn = (Button) findViewById(R.id.helpBtnID);
        quitButton = (Button) findViewById(R.id.quitButtonID);

        startGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityNames.class);
                startActivity(intent);
            }
        });

        //friend feedback Thanks Sam!
        helpBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent browserIntent = new Intent(
                        Intent.ACTION_VIEW,
                        Uri.parse("https://en.wikipedia.org/wiki/Tic-tac-toe"));
                startActivity(browserIntent);
            }
        });
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callMsgBox();
            }
        });
    }

    public void callMsgBox(){

            final AlertDialog.Builder winMsgBox = new AlertDialog.Builder(MainActivity.this);
            View mView = getLayoutInflater().inflate(R.layout.match_result_layout,null);
            TextView msgText1 = (TextView) mView.findViewById(R.id.alertMsgTextV1ID);
            TextView msgText2 = (TextView) mView.findViewById(R.id.alertMsgTextV2ID);
            winMsgBox.setCancelable(true);
            msgText1.setText("Message ");
            msgText2.setText("Are you sure you want to quit ?");
            Button msgYesBtn = (Button) mView.findViewById(R.id.alertMsgBtnP);
            Button msgNoBtn = (Button) mView.findViewById(R.id.alertMsgBtnQ);
            msgYesBtn.setText("Yes -_-");
            msgNoBtn.setText("No :)");
            msgYesBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    finish();
                }
            });
            msgNoBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, MainActivity.class);
                    startActivity(intent);
                }
            });
            winMsgBox.setView(mView);
            winMsgBox.create().show();
        }
    }


