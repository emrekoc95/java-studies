package com.kocemre.retrofitjava.service;

import com.kocemre.retrofitjava.model.CryptoModel;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;

public interface CryptoAPI {

    //GET, POST, UPDATE, DELETE

    @GET("crypto.json")
    Observable<ArrayList<CryptoModel>> getData();
    //Call<ArrayList<CryptoModel>> getData();
}
