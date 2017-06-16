package com.example.dell.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.jar.Attributes;

/**
 * Created by DELL on 6/14/2017.
 */

public class DbHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="database.db";

    public static final String TABLE_NAME="Details";

    private static final int DATABASE_VERSION=1;

    public static final  String COL_1="ID";

    public static final  String COL_2="Name";

    public static final  String COL_3="Subject";

    public static final  String COL_4="Marks";

    public DbHelper(Context context)
    {
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase db) {

        String SQL_CREATE_TABLE="CREATE TABLE" + TABLE_NAME +"("+
                COL_1 + "integer primary key auto increment" +
                COL_2 + "text not null" +
                COL_3 + "text not null" +
                COL_4 + "integer not null" +
                ")";

        db.execSQL(SQL_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean insertData(String name,String subject,String marks)
    {
        SQLiteDatabase db=this.getWritableDatabase();

        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_2,name);
        contentValues.put(COL_3,subject);
        contentValues.put(COL_4,marks);

        long result=db.insert(TABLE_NAME,null,contentValues);

        if(result==-1)

            return false;

        else
            return true;
    }
}
