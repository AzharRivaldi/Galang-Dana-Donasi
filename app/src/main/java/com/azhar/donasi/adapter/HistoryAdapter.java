package com.azhar.donasi.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.azhar.donasi.R;
import com.azhar.donasi.model.ModelDatabase;
import com.azhar.donasi.util.FunctionHelper;

import java.util.List;

/*
 * Created by Azhar Rivaldi on 03-11-2023
 * Youtube Channel : https://bit.ly/2PJMowZ
 * Github : https://github.com/AzharRivaldi
 * Twitter : https://twitter.com/azharrvldi_
 * Instagram : https://www.instagram.com/azhardvls_
 * LinkedIn : https://www.linkedin.com/in/azhar-rivaldi
 */

public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    List<ModelDatabase> modelDatabase;
    Context mContext;
    RiwayatAdapterCallback mAdapterCallback;

    public HistoryAdapter(Context context, List<ModelDatabase> modelInputList,
                          RiwayatAdapterCallback adapterCallback) {
        this.mContext = context;
        this.modelDatabase = modelInputList;
        this.mAdapterCallback = adapterCallback;
    }

    public void setDataAdapter(List<ModelDatabase> items) {
        modelDatabase.clear();
        modelDatabase.addAll(items);
        notifyDataSetChanged();
    }

    @Override
    public HistoryAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_riwayat,
                parent, false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(HistoryAdapter.ViewHolder holder, int position) {
        final ModelDatabase data = modelDatabase.get(position);

        holder.tvJumlahDonasi.setText(FunctionHelper.rupiahFormat(data.jmlUang));
        holder.tvTanggal.setText(FunctionHelper.setDataTime());
    }

    @Override
    public int getItemCount() {
        return modelDatabase.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvJumlahDonasi, tvTanggal;
        public ImageView imageDelete;

        public ViewHolder(View itemView) {
            super(itemView);
            tvJumlahDonasi = itemView.findViewById(R.id.tvJumlahDonasi);
            tvTanggal = itemView.findViewById(R.id.tvTanggal);
            imageDelete = itemView.findViewById(R.id.imageDelete);

            imageDelete.setOnClickListener(view -> {
                ModelDatabase modelLaundry = modelDatabase.get(getAdapterPosition());
                mAdapterCallback.onDelete(modelLaundry);
            });
        }
    }

    public interface RiwayatAdapterCallback {
        void onDelete(ModelDatabase modelDatabase);
    }

}
