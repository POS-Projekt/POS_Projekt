package com.example.ratzf.pos_projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

/**
 * Created by ratzf on 10.06.2016.
 */
public class GameOver extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gameover);
        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);
    }
}
