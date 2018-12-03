package com.bw.ymy.yaomingyuan1203;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SqliteHelp extends SQLiteOpenHelper {
    public SqliteHelp(Context contextnt) {
        super(contextnt, "User.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table ss(id integer primary key autoincrement,"+"countext text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
