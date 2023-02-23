package com.kocemre.retrofitjava.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kocemre.retrofitjava.R;
import com.kocemre.retrofitjava.adapter.RecyclerViewAdapter;
import com.kocemre.retrofitjava.databinding.ActivityMainBinding;
import com.kocemre.retrofitjava.model.CryptoModel;
import com.kocemre.retrofitjava.service.CryptoAPI;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/crypto.json


    private String BASE_URL = "https://raw.githubusercontent.com/atilsamancioglu/K21-JSONDataSet/master/";
    Retrofit retrofit;
    RecyclerView recyclerView;
    ArrayList<CryptoModel> cryptoModels;
    RecyclerViewAdapter adapter;
    CompositeDisposable compositeDisposable;
    //ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        // = new ArrayList<>();
       /* binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);*/

        Gson gson = new GsonBuilder().setLenient().create();

        retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addCallAdapterFactory(RxJava2CallAdapterFactory.create()).addConverterFactory(GsonConverterFactory.create(gson)).build();

        loadData();


    }

    private void loadData(){

        final CryptoAPI cryptoAPI = retrofit.create(CryptoAPI.class);

        compositeDisposable = new CompositeDisposable();

        compositeDisposable.add(cryptoAPI.getData()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(this::handleResponse));



        /*
        Call<ArrayList<CryptoModel>> call = cryptoAPI.getData();
        call.enqueue(new Callback<ArrayList<CryptoModel>>() {
            @Override
            public void onResponse(Call<ArrayList<CryptoModel>> call, Response<ArrayList<CryptoModel>> response) {
                if(response.isSuccessful()){
                    ArrayList<CryptoModel> responseList = response.body();
                    cryptoModels = (ArrayList<CryptoModel>) responseList.clone();
                    recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    adapter = new RecyclerViewAdapter(cryptoModels);
                    recyclerView.setAdapter(adapter);

                }
            }

            @Override
            public void onFailure(Call<ArrayList<CryptoModel>> call, Throwable t) {
                t.printStackTrace();
            }
        });*/


    }

    private void handleResponse(ArrayList<CryptoModel> cryptoModelArrayList){
        cryptoModels = new ArrayList<>(cryptoModelArrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        adapter = new RecyclerViewAdapter(cryptoModels);
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        compositeDisposable.clear();
    }
}