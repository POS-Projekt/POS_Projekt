package com.example.ratzf.pos_projekt;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.LinearLayout;

/**
 * Created by preiter on 09.06.2016.
 */
public class NewQuestion extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.background);

        openDialog();
    }

    private void openDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.new_question, null);
        builder.setView(layout);

        final EditText question = (EditText) layout.findViewById(R.id.editTextQuestion);
        final EditText wrongAnswer1 = (EditText) layout.findViewById(R.id.editTextWrongAnswer1);
        final EditText wrongAnswer2 = (EditText) layout.findViewById(R.id.editTextWrongAnswer2);
        final EditText wrongAnswer3 = (EditText) layout.findViewById(R.id.editTextWrongAnswer3);
        final EditText rightAnswer = (EditText) layout.findViewById(R.id.editTextRightAnswer);

        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                QuestionClass questionClass = new QuestionClass(question.getText().toString(),
                        wrongAnswer1.getText().toString(), wrongAnswer2.getText().toString(),
                        wrongAnswer3.getText().toString(), rightAnswer.getText().toString());
                saveQuestion(questionClass);
            }
        });

        builder.setNegativeButton("Zurück", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                onDestroy();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveQuestion(QuestionClass questionClass)
    {
        DBHelper helper = new DBHelper(getBaseContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Constants.QUESTION, questionClass.getQuestion());
        values.put(Constants.WRONGANSWER1, questionClass.getWrongAnswer1());
        values.put(Constants.WRONGANSWER2, questionClass.getWrongAnswer2());
        values.put(Constants.WRONGANSWER3, questionClass.getWrongAnswer3());
        values.put(Constants.RIGHTANSWER, questionClass.getRightAnswer());
        db.insert(Constants.TABLE_NAME, null, values);
    }
}
