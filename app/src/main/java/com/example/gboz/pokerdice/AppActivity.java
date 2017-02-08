package com.example.gboz.pokerdice;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AppActivity extends AppCompatActivity {

    Button newGameButton, engineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        newGameButton = (Button) findViewById(R.id.newGameButton);
        engineButton = (Button) findViewById(R.id.engineButton);

        newGameButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadNewGameActivity(v);
            }
        });

        engineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loadEngineActivity(v);
            }
        });
    }

    public void loadNewGameActivity(View view) {
        Intent intent = new Intent(this, NewGameActivity.class);
        startActivity(intent);
    }

    public void loadEngineActivity(View view) {
        Intent intent = new Intent(this, EngineActivity.class);
        startActivity(intent);
    }

}
