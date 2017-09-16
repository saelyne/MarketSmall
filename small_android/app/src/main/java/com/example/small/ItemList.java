package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class ItemList extends AppCompatActivity {

    private Button checkBtn;
    private ListView data;
    public static ArrayList<Orders> orders;
    public static ArrayList<Integer> positions;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_list);
        data = (ListView) findViewById(R.id.data);
        orders = new ArrayList<Orders>();
        positions = new ArrayList<Integer>();

        sendRequest();
        checkBtn= (Button) findViewById(R.id.Checkbutton);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemList.this, ConfirmOrder.class);

                startActivity(intent);
            }
        });
    }

    private void sendRequest() {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Intent intent = getIntent();
        Call<List<Orders>> call = apiService.getItemList(intent.getExtras().getString("ids"));
        call.enqueue(new Callback<List<Orders>>() {

            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Orders> list = (ArrayList<Orders>)response.body();
                    orders= list;
                    ArrayList<String> names = new ArrayList<String>();
                    for(Orders a : list){
                        String b = a.name;
                        names.add(b);
                    }

                    ArrayAdapter<String> aList = new ArrayAdapter<String>(ItemList.this,android.R.layout.simple_list_item_1,names);
                    data.setAdapter(aList);
                    data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            positions.add((int)id);
                        }
                    });

                } else {
                    Log.e("ERROR", "Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<Orders>> call, Throwable t) {
                Log.e("ERROR", "onFailure", t);
            }
        });

    }


}

