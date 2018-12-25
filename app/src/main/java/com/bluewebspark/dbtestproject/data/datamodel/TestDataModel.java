package com.bluewebspark.dbtestproject.data.datamodel;

import android.database.sqlite.SQLiteDatabase;

public class TestDataModel {
    public static final String TABLE_NAME = "testtable";
    public static final String KEY_ID = "_id";
    public static final String KEY_NAME = "name";

    public static void createTable(SQLiteDatabase db) {
        String CREATE_TABLE = "create table " + TABLE_NAME + " ("
                + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_NAME + " text" +
                ")";
        db.execSQL(CREATE_TABLE);
    }

    public static void dropTable(SQLiteDatabase db) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
