package com.example.ratzf.pos_projekt;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by ratzf on 10.06.2016.
 */
public class GameOver extends AppCompatActivity{

    LinearLayout counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = (LinearLayout) getLayoutInflater().inflate(R.layout.gameover,null);
        setContentView(counter);
        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);

        openDialog();
    }

    private void openDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.enter_name, null);
        builder.setView(layout);


        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveHighScoreInDB();
                finish();
            }
        });


        builder.show();
    }

    private void saveHighScoreInDB()
    {

    }
}
