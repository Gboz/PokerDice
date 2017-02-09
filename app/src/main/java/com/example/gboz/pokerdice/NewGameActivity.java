package com.example.gboz.pokerdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.view.Menu;
import android.view.MenuItem;

public class NewGameActivity extends AppCompatActivity {

    Button playButton, newPlayerButton;
    String value;
    String[] superStarNames = {"Mietek", "Agaciuga", "Pepi B", "Roman Boskyyy"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_game);

        // initiate a ListView
        ListView listView = (ListView) findViewById(R.id.listView);
        // set the adapter to fill the data in ListView
        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), superStarNames);
        listView.setAdapter(customAdapter);

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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
