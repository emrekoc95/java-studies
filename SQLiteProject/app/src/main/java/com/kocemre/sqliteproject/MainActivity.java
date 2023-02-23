package com.kocemre.sqliteproject;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            SQLiteDatabase database = openOrCreateDatabase("Musician", MODE_PRIVATE, null);
            database.execSQL("CREATE TABLE IF NOT EXISTS musicians (id INTEGER PRIMARY KEY,name VARCHAR,age INTEGER)");

            /* database.execSQL("INSERT INTO musicians (name,age) VALUES ('James',50)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('Lars',60)");
            database.execSQL("INSERT INTO musicians (name,age) VALUES ('Kirk',55)");*/

            database.execSQL("UPDATE musicians SET name = 'Kirk Hammett' WHERE name = 'Kirk'");
            database.execSQL("DELETE FROM musicians WHERE name LIKE '%es'");

            Cursor cursor = database.rawQuery("SELECT * FROM musicians WHERE id = 1", null);
            int nameIx = cursor.getColumnIndex("name");
            int ageIx = cursor.getColumnIndex("age");
            int idIx = cursor.getColumnIndex("id");

            while (cursor.moveToNext()) {
                System.out.println("Name: " + cursor.getString(nameIx));
                System.out.println("Age: " + cursor.getInt(ageIx));
                System.out.println("ID: +" + cursor.getInt(idIx));
            }


        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}