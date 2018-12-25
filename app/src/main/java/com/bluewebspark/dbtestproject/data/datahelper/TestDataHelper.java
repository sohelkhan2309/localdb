package com.bluewebspark.dbtestproject.data.datahelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.bluewebspark.dbtestproject.data.DataManager;
import com.bluewebspark.dbtestproject.data.datamodel.TestDataModel;

import java.util.ArrayList;

public class TestDataHelper {
    private static TestDataHelper instance;
    private SQLiteDatabase db;
    private DataManager dm;
    Context cx;

    public TestDataHelper(Context cx) {
        instance = this;
        this.cx = cx;
        dm = new DataManager(cx, DataManager.DATABASE_NAME, null, DataManager.DATABASE_VERSION);
    }

    public static TestDataHelper getInstance() {
        return instance;
    }

    public void open() {
        db = dm.getWritableDatabase();
    }

    public void close() {
        db.close();
    }

    public void read() {
        db = dm.getReadableDatabase();
    }

    private boolean isExist(TestDataModel userDataModel) {
        read();
        Cursor cur = db.rawQuery("select * from " + TestDataModel.TABLE_NAME + " where " + TestDataModel.KEY_NAME + "='" + userDataModel.getName() + "'", null);
        if (cur.moveToFirst()) {
            return true;
        }
        return false;
    }

    public void insertUserDataModel(TestDataModel userDataModel) {
        open();
        ContentValues values = new ContentValues();

        values.put(TestDataModel.KEY_NAME, userDataModel.getName());

        if (!isExist(userDataModel)) {
            db.insert(TestDataModel.TABLE_NAME, null, values);
        } else {
            db.update(TestDataModel.TABLE_NAME, values, TestDataModel.KEY_NAME + "=" + userDataModel.getName(), null);
        }
        close();
    }

    public ArrayList<TestDataModel> getUserDataModel() {
        ArrayList<TestDataModel> userItem = new ArrayList<TestDataModel>();
        read();
        Cursor clientCur = db.rawQuery("select * from " + TestDataModel.TABLE_NAME, null);

        if (clientCur != null && clientCur.getCount() > 0) {
            clientCur.moveToFirst();
            do {
                TestDataModel userDataModel = new TestDataModel();
                userDataModel.setName(clientCur.getString(clientCur.getColumnIndex(TestDataModel.KEY_NAME)));
                userItem.add(userDataModel);
            } while ((clientCur.moveToNext()));
            clientCur.close();
        }
        close();
        return userItem;
    }

    public void delete() {
        open();
        db.delete(TestDataModel.TABLE_NAME, null, null);
        close();
    }
}