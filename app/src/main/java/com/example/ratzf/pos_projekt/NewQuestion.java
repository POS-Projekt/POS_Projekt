package com.example.ratzf.pos_projekt;

import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

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

    private void openDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.new_question, null);
        builder.setView(layout);

        ArrayAdapter arrayAdapter = ArrayAdapter.createFromResource(this, R.array.categories,
                android.R.layout.simple_expandable_list_item_1);

        final Spinner categorySpinner = (Spinner) layout.findViewById(R.id.spinnerCategory);
        categorySpinner.setAdapter(arrayAdapter);
        final EditText question = (EditText) layout.findViewById(R.id.editTextQuestion);
        final EditText wrongAnswer1 = (EditText) layout.findViewById(R.id.editTextWrongAnswer1);
        final EditText wrongAnswer2 = (EditText) layout.findViewById(R.id.editTextWrongAnswer2);
        final EditText wrongAnswer3 = (EditText) layout.findViewById(R.id.editTextWrongAnswer3);
        final EditText rightAnswer = (EditText) layout.findViewById(R.id.editTextRightAnswer);

        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                QuestionClass questionClass = new QuestionClass(Integer.toString((int) categorySpinner.getSelectedItemId())
                        , question.getText().toString(), wrongAnswer1.getText().toString(),
                        wrongAnswer2.getText().toString(), wrongAnswer3.getText().toString(),
                        rightAnswer.getText().toString());
                saveQuestion(questionClass);
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

    private void saveQuestion(QuestionClass questionClass) {
        DBHelper helper = new DBHelper(getBaseContext());
        SQLiteDatabase db = helper.getWritableDatabase();
        SQLiteStatement stmt = db.compileStatement(Constants.STMT_INSERT);

        stmt.bindString(1, questionClass.getCategory());
        stmt.bindString(2, questionClass.getQuestion());
        stmt.bindString(3, questionClass.getWrongAnswer1());
        stmt.bindString(4, questionClass.getWrongAnswer2());
        stmt.bindString(5, questionClass.getWrongAnswer3());
        stmt.bindString(6, questionClass.getRightAnswer());

        finish();
    }
}
