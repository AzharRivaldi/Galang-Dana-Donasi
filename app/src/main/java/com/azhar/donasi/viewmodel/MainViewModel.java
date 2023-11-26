package com.azhar.donasi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.azhar.donasi.database.DatabaseClient;
import com.azhar.donasi.database.dao.DatabaseDao;

/*
 * Created by Azhar Rivaldi on 03-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class MainViewModel extends AndroidViewModel {

    DatabaseDao databaseDao;
    LiveData<Integer> integerLiveData;

    public MainViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
        integerLiveData = databaseDao.getTotalDonasi();
    }

    public LiveData<Integer> getTotalDonasi() {
        return integerLiveData;
    }

}
