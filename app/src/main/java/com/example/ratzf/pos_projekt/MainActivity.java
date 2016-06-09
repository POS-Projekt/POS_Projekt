package com.example.ratzf.pos_projekt;

import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        try {
            InputStream inputStream = getAssets().open("logo.jpg");

        } catch (IOException e) {
            e.printStackTrace();
        }
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);
    }
}
