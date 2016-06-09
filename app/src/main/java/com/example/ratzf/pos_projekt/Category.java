package com.example.ratzf.pos_projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by preiter on 09.06.2016.
 */
public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initalizeLayout();
    }

    private void initalizeLayout() {
        Button saveEnd = (Button) findViewById(R.id.buttonSaveAndBack);

        saveEnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
