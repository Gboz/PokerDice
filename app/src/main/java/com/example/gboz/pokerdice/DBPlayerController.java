package com.example.gboz.pokerdice;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.TextView;

/**
 * Created by gbole on 09.02.2017.
 */

public class DBPlayerController extends SQLiteOpenHelper {

    public DBPlayerController(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, "TEST.db", factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE PLAYERS(ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT UNIQUE);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS PLAYERS;");
        onCreate(db);
    }

    public void createPlayer(String name) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("NAME", name);
        this.getWritableDatabase().insertOrThrow("PLAYERS", "", contentValues);
    }

    public void deletePlayer(String name) {
        this.getWritableDatabase().delete("PLAYERS", "NAME='" + name + "'", null);
    }

    public void editPlayer(String oldName, String newName) {
        this.getWritableDatabase().execSQL("UPDATE PLAYERS SET NAME = '" + newName + "' WHERE NAME = '" + oldName + "'");
    }

    public void listAllPlayers(TextView textView) {
        Cursor cursor = this.getReadableDatabase().rawQuery("SELECT * FROM PLAYERS", null);
        textView.setText("");
        while (cursor.moveToNext()) {
            textView.append(cursor.getString(1) + "\n");
        }
    }
}
