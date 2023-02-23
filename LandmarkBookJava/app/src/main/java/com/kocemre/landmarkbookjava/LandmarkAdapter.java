package com.kocemre.landmarkbookjava;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kocemre.landmarkbookjava.databinding.RecyclerviewRowBinding;

import java.util.ArrayList;

public class LandmarkAdapter extends RecyclerView.Adapter<LandmarkAdapter.LandmarkHolder>{

    ArrayList<Landmark> landmarkArrayList;

    public LandmarkAdapter(ArrayList<Landmark> landmarkArrayList){
        this.landmarkArrayList = landmarkArrayList;
    }

    public class LandmarkHolder extends RecyclerView.ViewHolder{

        private RecyclerviewRowBinding binding;

        public LandmarkHolder(@NonNull RecyclerviewRowBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public LandmarkHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RecyclerviewRowBinding recyclerviewRowBinding;
        recyclerviewRowBinding = RecyclerviewRowBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new LandmarkHolder(recyclerviewRowBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull LandmarkHolder holder, int position) {
        holder.binding.recyclerViewTextView.setText(landmarkArrayList.get(position).name);

        holder.itemView.setOnClickListener(view -> {
            Intent intent = new Intent(holder.binding.getRoot().getContext(),DetailActivity.class);
            Singleton singleton = Singleton.getInstance();
            singleton.setSentLandmark(landmarkArrayList.get(position));
            holder.binding.getRoot().getContext().startActivity(intent);
        });




    }

    @Override
    public int getItemCount() {
        return landmarkArrayList.size();
    }


}
