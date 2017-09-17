package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import static com.example.small.TypeSeller.uid;
/**
 * Created by Saelyne on 2017. 9. 17..
 */


public class ItemDelete extends AppCompatActivity {
    private Button deleteBtn;
    private ListView data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_delete);
        data = (ListView) findViewById(R.id.data);
        sendRequest();

        deleteBtn= (Button) findViewById(R.id.deleteBtn);
        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ItemDelete.this, SellerMain.class);
                startActivity(intent);
            }
        });

    }
    private void sendRequest() {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Call<List<Orders>> call = apiService.getMyStore(uid);
        call.enqueue(new Callback<List<Orders>>() {

            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Orders> list = (ArrayList<Orders>)response.body();
                    ArrayList<String> names = new ArrayList<String>();
                    for(Orders a : list){
                        String b = a.name;
                        int p = (a.price).intValue();
                        names.add(""+b+" ("+p+"원)");
                    }

                    ArrayAdapter<String> aList = new ArrayAdapter<String>(ItemDelete.this,android.R.layout.simple_list_item_1,names);
                    data.setAdapter(aList);
                    data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                            //delete();
                         // Toast.makeText(ItemDelete.this, list.get(position).getName()+"이/가 추가되었습니다", Toast.LENGTH_SHORT).show();
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
