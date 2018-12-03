package com.bw.ymy.yaomingyuan1203;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

public class Dao {
    private SQLiteDatabase database;

    public Dao(Context context) {
       database=new SqliteHelp(context).getWritableDatabase();
    }

    //添加到数据库
    public  void  add(String string)
    {
        ContentValues values=new ContentValues();
        values.put("countext",string);
        database.insert("ss",null,values);
    }

    //删除
    public  void dell()
    {
        database.delete("ss",null,null);
    }

    public  boolean sel(String string)
    {
        Cursor query = database.query("ss", null, "countext=?", new String[]{string}, null, null, null);
        return query.getCount()==0?true:false;
    }
    //查询
    public List<String> select()
    {
        List<String> list=new ArrayList<>();
        Cursor query = database.query("ss", null, null, null, null, null, null);

        while (query.moveToNext())
        {
            list.add(query.getString(query.getColumnIndex("countext")));
        }
        return  list;
    }
}
