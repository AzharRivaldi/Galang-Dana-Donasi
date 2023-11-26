package com.azhar.donasi.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.azhar.donasi.database.DatabaseClient;
import com.azhar.donasi.database.dao.DatabaseDao;
import com.azhar.donasi.model.ModelDatabase;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;

/*
 * Created by Azhar Rivaldi on 03-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class DonasiViewModel extends AndroidViewModel {

    DatabaseDao databaseDao;

    public DonasiViewModel(@NonNull Application application) {
        super(application);

        databaseDao = DatabaseClient.getInstance(application).getAppDatabase().databaseDao();
    }

    public void addDonasi(final String note, final int price) {
        Completable.fromAction(() -> {
            ModelDatabase modelDatabase = new ModelDatabase();
            modelDatabase.keterangan = note;
            modelDatabase.jmlUang = price;
            databaseDao.insertDonasi(modelDatabase);
        })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}
