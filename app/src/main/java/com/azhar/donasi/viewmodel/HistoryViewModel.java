package com.azhar.donasi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.azhar.donasi.database.DatabaseClient;
import com.azhar.donasi.database.dao.DatabaseDao;
import com.azhar.donasi.model.ModelDatabase;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/*
 * Created by Azhar Rivaldi on 05-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class HistoryViewModel extends AndroidViewModel {

    LiveData<List<ModelDatabase>> modelDatabase;
    DatabaseDao databaseDao;

    public HistoryViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
        modelDatabase = databaseDao.getAllData();
    }

    public LiveData<List<ModelDatabase>> getDataList() {
        return modelDatabase;
    }

    public void deleteDataById(final int uid) {
        Completable.fromAction(() -> databaseDao.deleteSingleData(uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}