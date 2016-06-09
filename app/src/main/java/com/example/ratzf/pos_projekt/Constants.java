package com.example.ratzf.pos_projekt;

/**
 * Created by preiter on 09.06.2016.
 */
public class Constants {

    public static final int DB_Version = 1;
    public static final String DB_NAME = "question.db";

    public static final String TABLE_NAME = "Questions";
    public static final String QUESTION_ID = "ID";
    public static final String QUESTION = "QUESTION";
    public static final String WRONGANSWER1 = "WRONGANSWER1";
    public static final String WRONGANSWER2 = "WRONGANSWER2";
    public static final String WRONGANSWER3 = "WRONGANSWER3";
    public static final String RIGHTANSWER = "WIRTEANSWER";

    public static final String[] ALL_COLUMNS = new String[] {QUESTION_ID + " AS _id", QUESTION,
            WRONGANSWER1, WRONGANSWER2, WRONGANSWER3, RIGHTANSWER};

    public static final String SQL_DROP = "DROP TABLE IF EXISTS "+ TABLE_NAME;
    public static final String SQL_CREATE = "CREATE TABLE " + TABLE_NAME+"(" + QUESTION_ID +
            " INTEGER PRIMARY KEY,"+ QUESTION+" STRING,"+ WRONGANSWER1+" STRING," + WRONGANSWER2 +
            " STRING"+ WRONGANSWER3 + " STRING" + RIGHTANSWER + " STRING" +")";

}
