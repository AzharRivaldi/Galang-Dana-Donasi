package com.azhar.donasi.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.azhar.donasi.R;
import com.azhar.donasi.util.FunctionHelper;
import com.azhar.donasi.viewmodel.MainViewModel;

public class MainActivity extends AppCompatActivity {

    CardView cvDonasiOne, cvDonasiTwo, cvDonasiThree;
    TextView tvDonasi;
    ProgressBar progressCount;
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setId();
        setInitLayout();
    }

    private void setId() {
        cvDonasiOne = findViewById(R.id.cvDonasiOne);
        cvDonasiTwo = findViewById(R.id.cvDonasiTwo);
        cvDonasiThree = findViewById(R.id.cvDonasiThree);
        tvDonasi = findViewById(R.id.tvDonasi);
        progressCount = findViewById(R.id.progressCount);
    }

    private void setInitLayout() {
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getTotalDonasi().observe(this,
                new Observer<Integer>() {
                    @Override
                    public void onChanged(Integer integer) {
                        //progress count bisa diubah sesuai keinginan
                        if (integer == null) {
                            int totalDonasi = 0;
                            String strJmlDonasi = FunctionHelper.rupiahFormat(totalDonasi);
                            tvDonasi.setText(strJmlDonasi + " sudah terkumpul dari Rp10.000.000");
                            progressCount.setMax(10000000);
                            progressCount.setProgress(totalDonasi);
                        } else {
                            int totalDonasi = integer;
                            String strJmlDonasi = FunctionHelper.rupiahFormat(totalDonasi);
                            tvDonasi.setText(strJmlDonasi + " sudah terkumpul dari Rp10.000.000");
                            progressCount.setMax(10000000);
                            progressCount.setProgress(totalDonasi);
                        }
                    }
                });

        cvDonasiOne.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DonasiActivity.class);
            startActivity(intent);
        });

        cvDonasiTwo.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, DonasiActivity.class);
            startActivity(intent);
        });

        cvDonasiThree.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
            startActivity(intent);
        });
    }

}