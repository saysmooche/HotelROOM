package com.bb.hotelroom;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

import java.util.List;

import static androidx.room.Room.databaseBuilder;

public class MyDatabase extends RoomDatabase implements MyDao {

    private RoomDatabase roomDatabase = new RoomDatabase() {
        @NonNull
        @Override
        protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
            return null;
        }

        @NonNull
        @Override
        protected InvalidationTracker createInvalidationTracker() {
            return null;
        }

        @Override
        public void clearAllTables() {

        }
    };
    private static Dao UserDao;
    private List<MyDatalist> myDatalists;

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {
        clearAllTables();
    }

    @Override
    public void addData(MyDatalist mydatalist) {

    }

    @Override
    public List<MyDatalist> getMyDatalist() {
        return null;
    }

    @Override
    public void delete(MyDatalist myDatalist) {

    }

    @Override
    public void update(MyDatalist myDatalist) {

    }

    @Database(entities = {User.class}, version = 1, exportSchema = false)
    public abstract class AppDatabase extends RoomDatabase
    {
        public abstract MyDao userDao();

    }
    public MyDao myDao(Context context, List<MyDatalist> myDatalist) {
        RoomDatabase db;
        db = databaseBuilder(getApplicationContext(myDatalist),"MyDatabase").build();
        return myDao(context, myDatalist);
    }

    private Context getApplicationContext(Context context) {
        return context;
    }
}
