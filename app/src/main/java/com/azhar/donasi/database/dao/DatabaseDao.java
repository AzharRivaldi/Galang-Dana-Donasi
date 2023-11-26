package com.azhar.donasi.database.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.azhar.donasi.model.ModelDatabase;

import java.util.List;

/*
 * Created by Azhar Rivaldi on 03-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

@Dao
public interface DatabaseDao {

    @Query("SELECT * FROM tbl_donasi")
    LiveData<List<ModelDatabase>> getAllData();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertDonasi(ModelDatabase... modelDatabases);

    @Query("DELETE FROM tbl_donasi WHERE uid= :uid")
    void deleteSingleData(int uid);

    @Query("SELECT SUM(jml_uang) FROM tbl_donasi")
    LiveData<Integer> getTotalDonasi();
}
