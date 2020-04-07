package com.bb.hotelroom;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface MyDao  {
        @Insert
        public void addData(MyDatalist mydatalist);

        @Query("select * from myDatalist")
        public List<MyDatalist>getMyDatalist();

        @Delete
        public void delete(MyDatalist myDatalist);

        @Update
        public void update(MyDatalist myDatalist);

    }

