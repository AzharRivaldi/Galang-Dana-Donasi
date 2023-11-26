package com.azhar.donasi.view;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import com.azhar.donasi.R;
import com.azhar.donasi.util.FunctionHelper;
import com.azhar.donasi.viewmodel.DonasiViewModel;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.chip.Chip;
import com.google.android.material.textfield.TextInputEditText;

public class DonasiActivity extends AppCompatActivity {

    Chip chipOne, chipTwo, chipThree;
    TextInputEditText etJmlUang, etKeterangan;
    BottomSheetDialog bottomSheetDialog;
    AppCompatButton btnDonasi;
    LinearLayout linearVA;
    int strNominal = "";
    String strKeterangan = "";
    DonasiViewModel donasiViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donasi);

        setId();
        setInitLayout();
    }

    private void setId() {
        chipOne = findViewById(R.id.chipOne);
        chipTwo = findViewById(R.id.chipTwo);
        chipThree = findViewById(R.id.chipThree);
        etJmlUang = findViewById(R.id.etJmlUang);
        etKeterangan = findViewById(R.id.etKeterangan);
        linearVA = findViewById(R.id.linearVA);
        btnDonasi = findViewById(R.id.btnDonasi);
    }

    private void setInitLayout() {
        donasiViewModel = new ViewModelProvider(this).get(DonasiViewModel.class);

        chipOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chipOne.isChecked()) {
                    strNominal = 10000;
                    setNominal(strNominal);
                } else {
                    strNominal = 0;
                    setNominal(strNominal);
                }
            }
        });

        chipTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chipTwo.isChecked()) {
                    strNominal = 20000;
                    setNominal(strNominal);
                } else {
                    strNominal = 0;
                    setNominal(strNominal);
                }
            }
        });

        chipThree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (chipThree.isChecked()) {
                    strNominal = 50000;
                    setNominal(strNominal);
                } else {
                    strNominal = 0;
                    setNominal(strNominal);
                }
            }
        });

        linearVA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View dialogView = getLayoutInflater().inflate(R.layout.bottom_sheet, null);

                bottomSheetDialog = new BottomSheetDialog(DonasiActivity.this);
                bottomSheetDialog.setContentView(dialogView);
                bottomSheetDialog.show();
            }
        });

        btnDonasi.setOnClickListener(v -> {
            strKeterangan = etKeterangan.getText().toString();
            if (strKeterangan.equals("0") || strKeterangan.isEmpty()) {
                Toast.makeText(DonasiActivity.this, "Data tidak boleh ada yang kosong!",
                        Toast.LENGTH_SHORT).show();
            } else {
                donasiViewModel.addDonasi(strKeterangan, strNominal);
                Toast.makeText(DonasiActivity.this,
                        "Terima kasih donasinya, cek di menu riwayat ya!", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }

    private void setNominal(String nominal) {
        etJmlUang.setText(nominal);
    }

}