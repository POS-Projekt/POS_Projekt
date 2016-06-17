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
        Button ownQuestion = (Button) findViewById(R.id.buttonNewQuesiton);
        final Button category = (Button) findViewById(R.id.buttonCategory);
        Button rules = (Button) findViewById(R.id.buttonRules);
        Button back = (Button) findViewById(R.id.buttonBack);

        ownQuestion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(getBaseContext(), NewQuestion.class);
                startActivity(intent1);
            }
        });

        category.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2 = new Intent(getBaseContext(), Category.class);
                startActivity(intent2);
            }
        });

        rules.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent3 = new Intent(getBaseContext(), Rules.class);
                startActivity(intent3);
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
