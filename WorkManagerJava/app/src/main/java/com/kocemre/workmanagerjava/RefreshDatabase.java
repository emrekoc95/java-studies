package com.kocemre.workmanagerjava;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;
import androidx.work.Data;
import androidx.work.Worker;
import androidx.work.WorkerParameters;

public class RefreshDatabase extends Worker {

    Context myContext;

    public RefreshDatabase(@NonNull Context context, @NonNull WorkerParameters workerParams) {
        super(context, workerParams);
        this.myContext = context;
    }

    @NonNull
    @Override
    public Result doWork() {
        Data data = getInputData();
        int myNumber = data.getInt("myNumber",0);
        refreshDatabase(myNumber);
        return Result.success();
    }


    private void refreshDatabase(int myNumber){
        SharedPreferences sharedPreferences = myContext.getSharedPreferences("com.kocemre.workmanagerjava",Context.MODE_PRIVATE);
        int number = sharedPreferences.getInt("number",0);
        number += myNumber;
        System.out.println(number);
        sharedPreferences.edit().putInt("number",number).apply();
    }


}
