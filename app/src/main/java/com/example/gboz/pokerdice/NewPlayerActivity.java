package com.example.gboz.pokerdice;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteException;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NewPlayerActivity extends AppCompatActivity {

    EditText name;
    TextView textView;
    DBPlayerController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_player);

        //disable the screensaver
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        name = (EditText) findViewById(R.id.playerNameEditText);
        textView = (TextView) findViewById(R.id.textView);

        controller = new DBPlayerController(this, null, 1);
    }

    public void btnClick(View view) {
        switch (view.getId()) {
            case R.id.createPlayerBtn:
                try {
                    controller.createPlayer(name.getText().toString());
                } catch (SQLiteException e) {
                    Toast.makeText(NewPlayerActivity.this, "ALREADY EXISTS", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.deletePlayerBtn:
                controller.deletePlayer(name.getText().toString());
                break;

            case R.id.updatePlayerBtn:
                AlertDialog.Builder dialog = new AlertDialog.Builder(NewPlayerActivity.this);
                dialog.setTitle("ENTER NEW NAME: ");

                final EditText newName = new EditText(this);
                dialog.setView(newName);

                dialog.setPositiveButton("CHANGE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int which) {
                        controller.editPlayer(name.getText().toString(), newName.getText().toString());
                    }
                });

                dialog.show();
                break;

            case R.id.listOfPlayersBtn:
                controller.listAllPlayers(textView);
                break;
        }
    }
}
