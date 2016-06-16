package com.example.ratzf.pos_projekt;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

/**
 * Created by ratzf on 10.06.2016.
 */
public class Topic_Selection extends AppCompatActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.topic_selection);
        Button back_to_main = (Button) findViewById(R.id.button_back_to_Main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        chooseTopic();

    }

    private void chooseTopic() {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button_topic1 = (Button) findViewById(R.id.button_topic1);
        Button button_topic2 = (Button) findViewById(R.id.button_topic2);
        Button button_topic3 = (Button) findViewById(R.id.button_topic3);
        Button button_topic4 = (Button) findViewById(R.id.button_topic4);
        buttons.add(button_topic1);
        buttons.add(button_topic2);
        buttons.add(button_topic3);
        buttons.add(button_topic4);





        for (Button button : buttons){
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                }
            });
        }


    }
}
