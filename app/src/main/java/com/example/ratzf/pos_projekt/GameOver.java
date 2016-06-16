package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
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
        Button back_to_main = (Button) findViewById(R.id.button_back_to_main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_to_main = new Intent(GameOver.this,MainActivity.class);
                startActivity(back_to_main);

            }
        });
    }
}