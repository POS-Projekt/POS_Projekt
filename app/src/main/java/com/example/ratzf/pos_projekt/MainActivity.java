package com.example.ratzf.pos_projekt;

import android.annotation.TargetApi;
import android.content.Intent;
import android.content.res.AssetManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.JsonReader;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

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

public class MainActivity extends AppCompatActivity {

    public  static ArrayList<QuestionClass> questions = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);

        getQuestions();

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

    @TargetApi(Build.VERSION_CODES.KITKAT)
    private void getQuestions(){
        try {
            InputStream in = getAssets().open("Fragen.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String all = "";
            String line = "";
            while ((line=br.readLine())!=null){
                all+=line;
            }
            JSONArray json_questions = new JSONArray((all));

            for (int i = 0; i < json_questions.length(); i++){
                JSONObject object = (JSONObject) json_questions.get(i);
                String category = object.getString("Kategorie");
                String question = object.getString("Frage");
                String Answer1 = object.getString("A1");
                String Answer2 = object.getString("A2");
                String Answer3 = object.getString("A3");
                String Answer4 = object.getString("A4");
                QuestionClass newQuestion = new QuestionClass(category,question,Answer1,Answer2,Answer3,Answer4);
                questions.add(newQuestion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

    }



}
