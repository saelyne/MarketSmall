package com.example.hongyejin.serverconnection;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by HONGGIBEOM on 2017. 9. 16..
 */

public interface GitHubService {
    @GET("store/getStore")
    Call<List<StoreData>> getStoreDataList();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.16.0.59:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}