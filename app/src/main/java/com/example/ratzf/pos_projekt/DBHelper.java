package com.example.ratzf.pos_projekt;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by preiter on 09.06.2016.
 */
public class DBHelper extends SQLiteOpenHelper {

    Context context;

    public DBHelper(Context context) {
        super(context, Constants.DB_NAME, null, Constants.DB_Version);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Constants.SQL_CREATE);
        Log.d("Create: ", "s");
        db.execSQL(Constants.SQL_CREATE2);
        Log.d("Create2: ", "ss");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Constants.SQL_DROP);
        onCreate(db);
        db.execSQL(Constants.SQL_DROP2);
        onCreate(db);
    }
}
