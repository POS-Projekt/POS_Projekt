package com.example.ratzf.pos_projekt;

<<<<<<< HEAD
import android.content.DialogInterface;
=======
import android.content.Intent;
>>>>>>> e53b5943026fa120a5ace069ea6684ab2e95eb4a
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.squareup.picasso.Picasso;

/**
 * Created by ratzf on 10.06.2016.
 */
public class GameOver extends AppCompatActivity{

    LinearLayout counter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        counter = (LinearLayout) getLayoutInflater().inflate(R.layout.gameover,null);
        setContentView(counter);
        ImageView logo = (ImageView) findViewById(R.id.imageView_logo);
        Picasso.with(this).load("file:///android_asset/Logo.PNG").resize(150,150).into(logo);
<<<<<<< HEAD

        openDialog();
    }

    private void openDialog()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(getBaseContext());
        LinearLayout layout = (LinearLayout) getLayoutInflater().inflate(R.layout.enter_name, null);
        builder.setView(layout);


        builder.setPositiveButton("Speichern", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                saveHighScoreInDB();
                finish();
            }
        });


        builder.show();
    }

    private void saveHighScoreInDB()
    {

=======
        Button back_to_main = (Button) findViewById(R.id.button_back_to_main);
        back_to_main.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent back_to_main = new Intent(GameOver.this,MainActivity.class);
                startActivity(back_to_main);

            }
        });
>>>>>>> e53b5943026fa120a5ace069ea6684ab2e95eb4a
    }
}
