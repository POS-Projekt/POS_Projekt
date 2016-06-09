package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by preiter on 09.06.2016.
 */
public class Setting extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting);

        initaleButtons();
    }

    private void initaleButtons()
    {
        Button numberQuestions = (Button) findViewById(R.id.buttonNumberOfQuestions);
        Button ownQuestion = (Button) findViewById(R.id.buttonNewQuesiton);
        final Button category = (Button) findViewById(R.id.buttonCategory);
        Button rules = (Button) findViewById(R.id.buttonRules);
        Button back = (Button) findViewById(R.id.buttonBack);

        numberQuestions.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NumberQuestion.class);
                startActivity(intent);
            }
        });

        ownQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), NewQuestion.class);
                startActivity(intent);
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Category.class);
                startActivity(intent);
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(), Rules.class);
                startActivity(intent);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
