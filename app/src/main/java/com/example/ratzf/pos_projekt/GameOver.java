package com.example.ratzf.pos_projekt;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.support.v7.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by ratzf on 10.06.2016.
 */
public class GameOver extends AppCompatActivity {

    LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = (LinearLayout) getLayoutInflater().inflate(R.layout.gameover,null);
        setContentView(layout);
        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);

        Button newGame = (Button) findViewById(R.id.button_newGame);
        newGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(getBaseContext(), Topic_Selection.class);
                startActivity(intent);
            }
        });
        Button backToStartIntent = (Button) findViewById(R.id.buttonStartFirstIntent);
        backToStartIntent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        openDialog();
    }

    private void openDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        final LinearLayout layout2 = (LinearLayout) getLayoutInflater().inflate(R.layout.enter_name, null);
        builder.setView(layout2);


        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EditText name = (EditText) layout2.findViewById(R.id.editTextEnterName);
                TextView point = (TextView) layout.findViewById(R.id.textView_score);
                HighscoreClass hclass = new HighscoreClass(name.getText().toString(),
                        Integer.parseInt(point.getText().toString()));
                finish();
                saveHighScoreInDB(hclass);
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveHighScoreInDB(HighscoreClass highscoreClass)
    {

        DBHelper helper = new DBHelper(getBaseContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.STMT_INSERT2);

        stmt.bindString(1, highscoreClass.getName());
        stmt.bindString(2, String.valueOf(highscoreClass.getPoints()));
        finish();
    }
}
