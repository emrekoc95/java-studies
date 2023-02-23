package com.kocemre.retrofitjava.adapter;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kocemre.retrofitjava.databinding.ActivityMainBinding;
import com.kocemre.retrofitjava.databinding.RowLayoutBinding;
import com.kocemre.retrofitjava.model.CryptoModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RowHolder> {

    private ArrayList<CryptoModel> cryptoModels;
    String[] colorString = {"#0a638e","#dd00bb","#b00b1e","#aa9d8b","#5d23d4","#ff3384"};

    public RecyclerViewAdapter(ArrayList<CryptoModel> cryptoModels) {
        this.cryptoModels = cryptoModels;
    }

    @NonNull
    @Override
    public RowHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowLayoutBinding rowLayoutBinding = RowLayoutBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new RowHolder(rowLayoutBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull RowHolder holder, int position) {
        holder.itemView.setBackgroundColor(Color.parseColor(colorString[position%6]));
        holder.rowLayoutBinding.textName.setText(cryptoModels.get(position).getCurrency());
        holder.rowLayoutBinding.textPrice.setText(cryptoModels.get(position).getPrice());


    }

    @Override
    public int getItemCount() {
        return cryptoModels.size();
    }

    public class RowHolder extends RecyclerView.ViewHolder {
        RowLayoutBinding rowLayoutBinding;
        public RowHolder(RowLayoutBinding rowLayoutBinding) {
            super(rowLayoutBinding.getRoot());
            this.rowLayoutBinding = rowLayoutBinding;
        }
    }
}
