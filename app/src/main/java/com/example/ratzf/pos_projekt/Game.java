package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ratzf on 17.06.2016.
 */
public class Game extends AppCompatActivity {

    boolean joker_used = false;
    CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game);
        countDownTimer = new CountDownTimer(20000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                TextView timer = (TextView) findViewById(R.id.textView_timer);
                timer.setText("Timer: "+millisUntilFinished/1000);
            }

            @Override
            public void onFinish() {
                Intent game_over = new Intent(Game.this, GameOver.class);
                startActivity(game_over);
            }
        };
        Intent getQuestion = getIntent();
        Bundle params = getQuestion.getExtras();
        if (params != null) {
            QuestionClass question = (QuestionClass) params.get("Question");
            setQuestion(question);
        }
        Button back_to_main = (Button) findViewById(R.id.button_back_to_main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        TextView points = (TextView) findViewById(R.id.textView_score);
        points.setText("Punktestand:   " + MainActivity.points);
        TextView question_counter = (TextView) findViewById(R.id.textView_question_counter);
        question_counter.setText("Frage " + MainActivity.question_count);



    }

    public void setQuestion(final QuestionClass question) {
        TextView textView_question = (TextView) findViewById(R.id.textView_question);
        textView_question.setText(question.getQuestion());

        Button button_answer1 = (Button) findViewById(R.id.button_answer1);
        Button button_answer2 = (Button) findViewById(R.id.button_answer2);
        Button button_answer3 = (Button) findViewById(R.id.button_answer3);
        Button button_answer4 = (Button) findViewById(R.id.button_answer4);
        final ArrayList<Button> buttons_answer = new ArrayList<>();
        buttons_answer.add(button_answer1);
        buttons_answer.add(button_answer2);
        buttons_answer.add(button_answer3);
        buttons_answer.add(button_answer4);

        ArrayList<String> answers = new ArrayList<>();
        answers.add(question.getRightAnswer());
        answers.add(question.getWrongAnswer1());
        answers.add(question.getWrongAnswer2());
        answers.add(question.getWrongAnswer3());

        Random r = new Random();
        ArrayList<String> used = new ArrayList<>();

        final ArrayList<Button> jokers = new ArrayList<>();


        Button joker1 = (Button) findViewById(R.id.button_joker);
        Button joker2 = (Button) findViewById(R.id.button_joker2);
        Button joker3 = (Button) findViewById(R.id.button_joker3);
        jokers.add(joker1);
        jokers.add(joker2);
        jokers.add(joker3);
        for (final Button joker : jokers) {
            if (MainActivity.jokers[jokers.indexOf(joker)]) {
                joker.setBackgroundColor(Color.RED);
            }
            joker.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Button button = (Button) v;
                    if (MainActivity.jokers[jokers.indexOf(joker)] == false) {
                        button.setClickable(false);
                        button.setBackgroundColor(Color.RED);
                        MainActivity.jokers[jokers.indexOf(joker)] = true;
                        joker_used = true;
                        int count = 0;
                        for (Button i : buttons_answer) {
                            if (!i.getText().toString().equals(question.getRightAnswer())) {
                                i.setText("");
                                count++;
                            }
                            if (count == 2) {
                                break;
                            }
                        }
                    } else {
                        Toast.makeText(Game.this, "Joker schon ausgespielt", Toast.LENGTH_SHORT).show();
                    }

                }
            });
        }


        int i = 0;
        for (Button button : buttons_answer) {
            do {
                i = r.nextInt(answers.size() - 0) + 0;
                if (!used.contains(answers.get(i))) {
                    button.setText(answers.get(i));
                }
            } while (used.contains(answers.get(i)));
            used.add(answers.get(i));

        }

        for (Button button : buttons_answer) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    Button button = (Button) v;
                    String answer = button.getText().toString();

                    if (answer.equals(question.getRightAnswer())) {

                        Toast.makeText(Game.this, "RICHTIG", Toast.LENGTH_SHORT).show();
                        if (joker_used) {
                            MainActivity.points += 5;
                        } else {
                            MainActivity.points += 10;
                        }
                        MainActivity.question_count++;
                        countDownTimer.cancel();
                        Intent next_Topic = new Intent(Game.this, Topic_Selection.class);
                        startActivity(next_Topic);
                        finish();

                    } else {
                        Intent game_over = new Intent(Game.this, GameOver.class);
                        startActivity(game_over);
                        finish();
                    }

                }
            });
        }
        countDownTimer.start();
    }
}
