package com.example.ratzf.pos_projekt;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by preiter on 09.06.2016.
 */
<<<<<<< HEAD
public class Category extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        initalizeLayout();
=======
public class Category extends PreferenceActivity {
    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.prefs);
>>>>>>> 5038a0469cf5f82818e642f4f5612f629a0b3e30
    }

}
