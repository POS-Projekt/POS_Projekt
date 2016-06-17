package com.example.ratzf.pos_projekt;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by preiter on 09.06.2016.
 */


public class Category extends PreferenceActivity {

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        addPreferencesFromResource(R.xml.prefs);
    }
}
