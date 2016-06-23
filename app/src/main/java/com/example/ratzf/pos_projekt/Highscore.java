package com.example.ratzf.pos_projekt;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by ratzf on 16.06.2016.
 */
public class Highscore extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore);
        Button back_to_main = (Button) findViewById(R.id.button_back_to_main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        listView = (ListView) findViewById(R.id.listView);

        showScores();
    }

    private void showScores() {
        ArrayList<HighscoreClass> alist = new ArrayList();
        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME2,
                Constants.ALL_COLUMNS2,
                null,
                null,
                null,
                null,
                Constants.POINTS+" DESC");

        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex(Constants.NAME));
            int points = cursor.getInt(cursor.getColumnIndex(Constants.POINTS));

            HighscoreClass highscoreClass = new HighscoreClass(name, points);
            alist.add(highscoreClass);
        }

        SimpleCursorAdapter adapter = new SimpleCursorAdapter(this, android.R.layout.simple_list_item_2,
                cursor, COLUMNS_FROM_DB, LAYOUT_ITEMS_TO_FILL,0);

        listView.setAdapter(adapter);
    }

    private static final int[] LAYOUT_ITEMS_TO_FILL = new int[]{
            android.R.id.text1,
            android.R.id.text2
    };

    private static final String[] COLUMNS_FROM_DB = new String [] {
            Constants.NAME, Constants.POINTS
    };

}
