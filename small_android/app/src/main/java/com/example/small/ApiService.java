package com.example.small;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;

/**
 * Created by EunChan Park on 2017-09-16.
 */

public interface ApiService {
    @GET("store/getStore")
    Call<List<StoreData>> getStoreDataList();

    @GET("store/getStoreItem/{id}")
    Call<List<Orders>> getItemList(@Path("id") String id);

    @POST("order/addOrder")
    Call<ItemData> updateItem(@Body ItemData itemData);

    @POST("order/addItem")
    Call<Orders> addItem(@Body Orders order);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.16.0.59:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
