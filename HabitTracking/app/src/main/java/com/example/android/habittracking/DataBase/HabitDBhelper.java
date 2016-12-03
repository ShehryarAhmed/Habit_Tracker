package com.example.android.habittracking.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.net.HttpURLConnection;

/**
 * Created by android on 12/3/2016.
 */
public class HabitDBhelper extends SQLiteOpenHelper {


    private static final String DATA_BASE = "Habit.dp";

    private static final int DATABASE_VERSION = 1;

    public HabitDBhelper(Context context){
        super(context,DATA_BASE,null,DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String  CREATE_PRODUCT_TABLE = "CREATE TABLE IF NOT EXISTS "+HabitContract.TABLE_NAME + " ("
                + HabitContract.mID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + HabitContract.HABIT_TITLE + " TEXT NOT NULL); ";

        // Execute the SQL statement

        sqLiteDatabase.execSQL(CREATE_PRODUCT_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public void deleteALLHabits(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DELETE FROM "+HabitContract.TABLE_NAME);
    }
}


