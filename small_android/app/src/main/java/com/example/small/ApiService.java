package com.example.small;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Body;
import retrofit2.http.Path;
import retrofit2.http.DELETE;

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

    @GET("order/getOrder/{id}")
    Call<List<Orders>> getOrder(@Path("id") String id);

    @GET("store/getOrder/{id}")
    Call<List<ItemData>> getDeliveries(@Path("id") String id);

    @GET("store/getMyStore/{id}")
    Call<List<Orders>> getMyStore(@Path("id") String id);


    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("http://172.16.0.59:3000/")
            .addConverterFactory(GsonConverterFactory.create())
            .build();

}
