package com.example.gboz.pokerdice;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

public class AppActivity extends AppCompatActivity {


    Button newGameButton, engineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        //disable the screensaver
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        SQLiteDatabase database = openOrCreateDatabase("dbtest.db", MODE_PRIVATE, null);
        database.execSQL("create table if not exists players(name text)");
        database.execSQL("insert into players values('Dzon')");
        Cursor cursor = database.rawQuery("select * from players", null);
        cursor.moveToFirst();
        String name = cursor.getString(0);
        System.out.println(name + " TEEEEEEEEEEEEEEEEEEEEEEEEEEST");
        database.close();

        newGameButton = (Button) findViewById(R.id.new_game_button);
        engineButton = (Button) findViewById(R.id.engine_button);

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
