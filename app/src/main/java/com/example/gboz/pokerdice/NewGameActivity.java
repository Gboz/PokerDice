package com.example.gboz.pokerdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class NewGameActivity extends AppCompatActivity {

    Button playButton, newPlayerButton;
    String[] names;
    DBPlayerController controller;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        //disable the screensaver
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        controller = new DBPlayerController(this, null, 1);
        names = controller.listAllPlayersToString(names);

        ListView listView = (ListView) findViewById(R.id.listView);
        PlayersAdapter playersAdapter = new PlayersAdapter(getApplicationContext(), names);
        listView.setAdapter(playersAdapter);

        playButton = (Button) findViewById(R.id.play_button);
        playButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadPlayActivity(v);
            }
        });

        newPlayerButton = (Button) findViewById(R.id.new_player_button);
        newPlayerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewPlayerActivity(v);
            }
        });

    }

    public void loadPlayActivity(View view) {
        Intent intent = new Intent(this, PlayActivity.class);
        startActivity(intent);
    }

    public void loadNewPlayerActivity(View view) {
        Intent intent = new Intent(this, NewPlayerActivity.class);
        startActivity(intent);
    }


}
