package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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
    }

    public void new_Game(View view){

        Intent new_Game = new Intent(this,Topic_Selection.class);
        startActivity(new_Game);

    }

    public void new_Options(View view){

        Intent new_Options = new Intent(this,Setting.class);
        startActivity(new_Options);
    }
}
