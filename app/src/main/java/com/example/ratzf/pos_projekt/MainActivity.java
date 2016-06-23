package com.example.ratzf.pos_projekt;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import static com.example.ratzf.pos_projekt.R.layout.game;

public class MainActivity extends AppCompatActivity {

    public static ArrayList<QuestionClass> questions = new ArrayList<>();
    public static int question_count = 1;
    public static int points = 0;
    public static boolean[] jokers = new boolean[3];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150, 150).into(logo);


        Button newOption = (Button) findViewById(R.id.button_options);
        newOption.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Options = new Intent(MainActivity.this, Setting.class);
                startActivity(new_Options);
            }
        });
        Button highscore = (Button) findViewById(R.id.button_highscore);
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent new_Highscore = new Intent(MainActivity.this, Highscore.class);
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
