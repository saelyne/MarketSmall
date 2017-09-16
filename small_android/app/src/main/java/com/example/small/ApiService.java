package com.example.small;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;

/**
 * Created by EunChan Park on 2017-09-16.
 */

public interface ApiService {
    @GET("store/getStore")
    Call<List<StoreData>> getStoreDataList();


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.16.0.59:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
