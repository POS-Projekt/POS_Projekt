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

        setContentView(R.layout.main);


        openDialog();
    }

    private void openDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.new_question, null);
        builder.setView(layout);

        EditText question = (EditText) layout.findViewById(R.id.editTextQuestion);
        EditText wrongAnswer1 = (EditText) layout.findViewById(R.id.editTextWrongAnswer1);
        EditText wrongAnswer2 = (EditText) layout.findViewById(R.id.editTextWrongAnswer2);
        EditText wrongAnswer3 = (EditText) layout.findViewById(R.id.editTextWrongAnswer3);
        EditText rightAnswer = (EditText) layout.findViewById(R.id.editTextRightAnswer);

        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                //QuestionClass questionClass = new QuestionClass()
                saveQuestion();
            }
        });

        builder.setNegativeButton("Zurück", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
                finish();
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();
    }

    private void saveQuestion()
    {
        DBHelper helper = new DBHelper(getBaseContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        ContentValues values = new ContentValues();
        //values.put(Constants.QUESTION, );

    }
}
