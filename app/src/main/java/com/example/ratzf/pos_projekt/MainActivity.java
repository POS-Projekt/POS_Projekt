package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);
        Button newOption = (Button) findViewById(R.id.button_options);
        newOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Options = new Intent(MainActivity.this,Setting.class);
                startActivity(new_Options);
            }
        });
        Button highscore = (Button) findViewById(R.id.button_highscore);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Highscore = new Intent(MainActivity.this,Highscore.class);
                startActivity(new_Highscore);
            }
        });
        Button new_Game = (Button) findViewById(R.id.button_newGame);
        new_Game.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Game = new Intent(MainActivity.this, Topic_Selection.class);
                startActivity(new_Game);
            }
        });
    }



}
