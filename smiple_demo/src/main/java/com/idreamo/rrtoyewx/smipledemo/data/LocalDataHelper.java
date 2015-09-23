package com.idreamo.rrtoyewx.smipledemo.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.idreamo.rrtoyewx.smipledemo.entity.NewsTopModel;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.dao.RuntimeExceptionDao;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;

import java.sql.SQLException;

/**
 * Created by rrtoyewx on 15/9/7.
 */
public class LocalDataHelper extends OrmLiteSqliteOpenHelper {
    public static final String DB_NAME = "simple_demo";
    public static final int DB_VERSION = 1;
    public static LocalDataHelper mLocalDataHelper_instance = null;

    //###################DAO###############################
    private RuntimeExceptionDao<TotalNewsInfo, Integer> mTotalNewsInfoDAO = null;
    private RuntimeExceptionDao<NewsTopInfo,Integer>mNewsTopInfoDAO = null;
    private RuntimeExceptionDao<NewsContentInfo,Integer>mNewsContentInfoDAO = null;


    public LocalDataHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static void init(Context context) {
        if (mLocalDataHelper_instance==null) {
            synchronized (LocalDataHelper.class){
                if(mLocalDataHelper_instance==null){
                    mLocalDataHelper_instance = new LocalDataHelper(context);
                }
            }
        }
    }

    public static synchronized LocalDataHelper getLocalDataHelper(){
        return mLocalDataHelper_instance;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource) {
        try {
            TableUtils.createTableIfNotExists(connectionSource, TotalNewsInfo.class);
            TableUtils.createTableIfNotExists(connectionSource,NewsTopInfo.class);
            TableUtils.createTableIfNotExists(connectionSource, NewsContentInfo.class);

            mTotalNewsInfoDAO = getTotalNewsInfoDAO();
            mNewsTopInfoDAO = getNewsTopInfoDAO();
            mNewsContentInfoDAO = getNewsContentInfoDAO();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, ConnectionSource connectionSource, int i, int i1) {

    }

    public RuntimeExceptionDao<TotalNewsInfo, Integer> getTotalNewsInfoDAO(){
        if(mTotalNewsInfoDAO==null){
            mTotalNewsInfoDAO = getRuntimeExceptionDao(TotalNewsInfo.class);
        }
        return mTotalNewsInfoDAO;
    }
    public RuntimeExceptionDao<NewsTopInfo, Integer> getNewsTopInfoDAO(){
        if(mNewsTopInfoDAO==null){
            mNewsTopInfoDAO = getRuntimeExceptionDao(NewsTopInfo.class);
        }
        return mNewsTopInfoDAO;
    }
    public RuntimeExceptionDao<NewsContentInfo, Integer> getNewsContentInfoDAO(){
        if(mNewsContentInfoDAO==null){
            mNewsContentInfoDAO = getRuntimeExceptionDao(NewsContentInfo.class);
        }
        return mNewsContentInfoDAO;
    }
}
