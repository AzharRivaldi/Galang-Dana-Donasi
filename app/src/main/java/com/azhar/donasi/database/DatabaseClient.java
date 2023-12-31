package com.azhar.donasi.database;

import android.content.Context;

import androidx.room.Room;

/*
 * Created by Azhar Rivaldi on 03-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class DatabaseClient {

    private static DatabaseClient mInstance;
    private AppDatabase mAppDatabase;

    private DatabaseClient(Context context){
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, "donasi_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context){
        if (mInstance == null){
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public AppDatabase getAppDatabase(){
        return mAppDatabase;
    }
}
