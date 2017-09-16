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

public class DeliverList extends AppCompatActivity {

    private Button tempBtn;
    private ListView data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliver_list);

        data=(ListView)findViewById(R.id.data);
        tempBtn = (Button) findViewById(R.id.Checkbutton01);

        sendRequest();

        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliverList.this, SellerMain.class);
                startActivity(intent);
            }
        });


    }
    private void sendRequest() {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Call<List<ItemData>> call = apiService.getDeliveries(uid);
        call.enqueue(new Callback<List<ItemData>>() {

            @Override
            public void onResponse(Call<List<ItemData>> call, Response<List<ItemData>> response) {
                if (response.isSuccessful()) {
                    ArrayList<ItemData> list = (ArrayList<ItemData>)response.body();

                    ArrayList<String> names = new ArrayList<String>();
                    for(ItemData a : list){
                        names.add("이름: "+a.name+"\n주소: "+a.address+"\n전화번호: "+a.phone_number);
                    }

                    ArrayAdapter<String> aList = new ArrayAdapter<String>(DeliverList.this,android.R.layout.simple_list_item_1,names);
                    data.setAdapter(aList);
                    data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        }
                    });

                } else {
                    Log.e("ERROR", "Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<List<ItemData>> call, Throwable t) {
                Log.e("ERROR", "onFailure", t);
            }
        });

    }

}
