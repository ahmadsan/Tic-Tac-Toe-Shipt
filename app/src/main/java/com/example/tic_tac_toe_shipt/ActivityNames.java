/*
File: ActivityNames.java
Copy: Copyright (c) 2019 - Ahmad Antar.
Vers: 1.0.0 03/30/2019 aa - Original coding.
 */
package com.example.tic_tac_toe_shipt;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityNames extends AppCompatActivity {


    private Button readyButton;
    private TextView player1Name;
    private TextView player2Name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_names);

        player1Name = (TextView) findViewById(R.id.player1NameEnterd);
        player2Name = (TextView) findViewById(R.id.player2NameEnterd);
        readyButton = (Button) findViewById(R.id.readyButtonID);


        readyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if((player1Name.getText().toString().equals("")) || (player2Name.getText().toString().equals("")) )
                {
                    emptyNotification();

                }
                else
                    {
                        //navigate to activity_name
                        Intent intent = new Intent(ActivityNames.this, ActionActivity.class);
                        intent.putExtra("player1",(player1Name.getText().toString()));
                        intent.putExtra("player2",(player2Name.getText().toString()));
                        startActivity(intent);
                    }
            }
        });


    }

    //Notification player name is missing
    private void emptyNotification(){
        Toast.makeText(ActivityNames.this,"Please make sure players name is not empty",Toast.LENGTH_LONG).show();
    }
}
