package com.example.ratzf.pos_projekt;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

/**
 * Created by ratzf on 10.06.2016.
 */
public class Topic_Selection extends AppCompatActivity {

    SharedPreferences prefs;


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
        TextView points = (TextView) findViewById(R.id.textView_score);
        points.setText("Punktestand:   " + MainActivity.points);
        PreferenceManager.setDefaultValues(this, R.xml.prefs, false);
        prefs = PreferenceManager.getDefaultSharedPreferences(this);
        getQuestions();
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

        ArrayList<String> topics = new ArrayList<>();
        HashMap<String, Boolean> allowed_topics = new HashMap<>();

        Boolean chemiestry = new Boolean(prefs.getBoolean("Chemiestry", true));
        Boolean physics = new Boolean(prefs.getBoolean("Physics", true));
        Boolean history = new Boolean(prefs.getBoolean("History", true));
        Boolean sports = new Boolean(prefs.getBoolean("Sports", true));
        Boolean nature = new Boolean(prefs.getBoolean("Nature", true));
        Boolean tV = new Boolean(prefs.getBoolean("TV", true));
        Boolean any = new Boolean(prefs.getBoolean("Any", true));
        allowed_topics.put("Chemie", chemiestry);
        allowed_topics.put("Physik", physics);
        allowed_topics.put("Geschichte", history);
        allowed_topics.put("Sport", sports);
        allowed_topics.put("Natur", nature);
        allowed_topics.put("Fernsehen", tV);
        allowed_topics.put("Sonstige", any);

        for (QuestionClass question : MainActivity.questions) {
            if (!topics.contains(question.getCategory())) {
                Log.d("TEST", allowed_topics.get(question.getCategory()) + "");
                Log.d("TEST", Boolean.TRUE + "");
                try {
                    if (allowed_topics.get(question.getCategory()) == true) {
                        topics.add(question.getCategory());
                    }
                } catch (Exception e){
                    continue;
                }

            }
        }
            Random r = new Random();
            ArrayList<String> used = new ArrayList<>();

            int i = 0;
            int counter = 0;
            for (Button button : buttons) {
                do {
                    i = r.nextInt(topics.size() - 0) + 0;
                    if (!used.contains(topics.get(i))) {
                        button.setText(topics.get(i));
                    }
                    counter++;
                } while (used.contains(topics.get(i)) && counter < 5);
                used.add(topics.get(i));
            }


            for (Button button : buttons) {
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Button button = (Button) v;
                        String topic = button.getText().toString();

                        if (!topic.equals("Nicht gesetzt")){
                            ArrayList<QuestionClass> possibleQuestions = new ArrayList<QuestionClass>();
                            for (QuestionClass question : MainActivity.questions) {
                                if (question.getCategory().equals(topic)) {
                                    possibleQuestions.add(question);
                                }
                            }
                            Random r = new Random();
                            int i = r.nextInt(possibleQuestions.size() - 0) + 0;
                            QuestionClass question = possibleQuestions.get(i);
                            Intent Game_Qestion = new Intent(Topic_Selection.this, Game.class);
                            Game_Qestion.putExtra("Question", question);
                            startActivity(Game_Qestion);
                            finish();
                        }else{
                            Toast.makeText(Topic_Selection.this, "Nicht moeglich", Toast.LENGTH_SHORT).show();
                        }




                    /*Intent intent = new Intent(getBaseContext(), GameOver.class);
                    startActivity(intent);*/
                    }
                });
            }
        }

    private void getQuestions() {
        MainActivity.questions.clear();
        try {
            InputStream in = getAssets().open("Fragen.json");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String all = "";
            String line = "";
            while ((line = br.readLine()) != null) {
                all += line;
            }
            JSONArray json_questions = new JSONArray((all));

            for (int i = 0; i < json_questions.length(); i++) {
                JSONObject object = (JSONObject) json_questions.get(i);
                String category = object.getString("Kategorie");
                String question = object.getString("Frage");
                String Answer1 = object.getString("A1");
                String Answer2 = object.getString("A2");
                String Answer3 = object.getString("A3");
                String Answer4 = object.getString("A4");
                QuestionClass newQuestion = new QuestionClass(category, question, Answer1, Answer2, Answer3, Answer4);
                MainActivity.questions.add(newQuestion);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }

        DBHelper helper = new DBHelper(this);
        SQLiteDatabase db = helper.getReadableDatabase();

        Cursor cursor = db.query(Constants.TABLE_NAME,
                Constants.ALL_COLUMNS,
                null,
                null,
                null,
                null,
                null);

        while (cursor.moveToNext()) {
            String question = cursor.getString(cursor.getColumnIndex(Constants.QUESTION));
            String category = cursor.getString(cursor.getColumnIndex(Constants.CATEGORY));
            String wrongAnswer1 = cursor.getString(cursor.getColumnIndex(Constants.WRONGANSWER1));
            String wrongAnswer2 = cursor.getString(cursor.getColumnIndex(Constants.WRONGANSWER2));
            String wrongAnswer3 = cursor.getString(cursor.getColumnIndex(Constants.WRONGANSWER3));
            String rightAnswer = cursor.getString(cursor.getColumnIndex(Constants.RIGHTANSWER));

            QuestionClass questionClass = new QuestionClass(category, question, wrongAnswer1,
                    wrongAnswer2,wrongAnswer3,rightAnswer);
            Log.d("Frage", questionClass.question);
            MainActivity.questions.add(questionClass);
        }
        //Intent reload = new Intent(MainActivity.this,MainActivity.class);
        //recreate();


    }
}
