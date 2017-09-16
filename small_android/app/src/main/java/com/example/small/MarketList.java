package com.example.small;

import android.content.Intent;
import android.location.Location;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import java.io.Console;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import retrofit2.Call;
import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;
import retrofit2.Callback;
import retrofit2.Response;
import android.util.Log;
import android.widget.ListAdapter;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.ListIterator;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import static android.R.id.list;

/**
 * Created by Saelyne on 2017. 9. 15..
 */

public class MarketList extends AppCompatActivity {

    private Button Btn;
    //private ListView data;
    RecyclerView storeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.market_list);

        //data = (ListView) findViewById(R.id.data);
        storeView = (RecyclerView)findViewById(R.id.store_listview);


        sendRequest();
        ActivityCompat.requestPermissions(this, new String[]{
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION}, 0);

    }


    private void sendRequest() {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Call<List<StoreData>> call = apiService.getStoreDataList();
        call.enqueue(new Callback<List<StoreData>>() {

            @Override
            public void onResponse(Call<List<StoreData>> call, Response<List<StoreData>> response) {
                Location loc1 = new Location("");
                loc1.setLatitude(getIntent().getDoubleExtra("positionX",36));
                loc1.setLongitude(getIntent().getDoubleExtra("positionY",136));
                Location loc2 =new Location("");
                if (response.isSuccessful()) {
                    List<StoreData> storeList = response.body();
                    List<StoreData> filterList = new ArrayList<>();

                    for(int i=0;i<storeList.size();i++){
                        // Location loc2 =new Location("");
                        loc2.setLatitude(storeList.get(i).getLatitude());
                        loc2.setLongitude(storeList.get(i).getLongitude());
                        if(loc1.distanceTo(loc2)<1000.0){
                            StoreData data = storeList.get(i);
                            data.setShort();
                            data.setDist(loc1.distanceTo(loc2));
                            filterList.add(data);
                        }
                    }
                    //ArrayList<String> list = (ArrayList)response.body();
                    //filterList.subList()
                    //ArrayAdapter<String> aList = new ArrayAdapter<String>(MarketList.this,android.R.layout.simple_list_item_1,list);

                    /*data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            Intent intent = new Intent(MarketList.this, ItemList.class);
                            intent.putExtra("ids",""+(id+1));
                            startActivity(intent);
                        }
                    });*/
                    storeView.setLayoutManager(new LinearLayoutManager(MarketList.this));
                    storeView.setAdapter(new StoreAdapter(MarketList.this,filterList));
                    // data.setAdapter(aList);


                } else {
                    Log.e("ERROR", "Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<StoreData>> call, Throwable t) {
                Log.e("ERROR", "onFailure", t);
            }
        });

    }
}