package com.idreamo.rrtoyewx.smipledemo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;

/**
 * Created by rrtoyewx on 15/9/7.
 */
public class LocalDataHelper extends OrmLiteSqliteOpenHelper {
    public static final String DB_NAME = "simple_demo";
    public static final int DB_VERSION = 1;
    public static LocalDataHelper localDataHelper_instance = null;


    public LocalDataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }
    public  void init(Context context) {
        if (localDataHelper_instance==null) {
            synchronized (LocalDataHelper.class){
                if(localDataHelper_instance==null){
                    localDataHelper_instance = new LocalDataHelper(context);
                }
            }
        }
    }

    public synchronized LocalDataHelper getLocalDataHelper(){
        return localDataHelper_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }
}
