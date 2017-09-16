package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class CheckOrder extends AppCompatActivity {

    private Button backBtn;
    private ListView data;
    private TextView totala;
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.check_order);
        Intent intent = getIntent();
        String phone=intent.getExtras().getString("phonenum");
        data = (ListView)findViewById(R.id.data);

        sendRequest(phone);




        backBtn = (Button) findViewById(R.id.back);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CheckOrder.this, login.class);
                startActivity(intent);
            }
        });
    }

    private void sendRequest(String phone) {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Call<List<Orders>> call = apiService.getOrder(phone);
        call.enqueue(new Callback<List<Orders>>() {

            @Override
            public void onResponse(Call<List<Orders>> call, Response<List<Orders>> response) {
                if (response.isSuccessful()) {
                    ArrayList<Orders> list = (ArrayList<Orders>)response.body();
                    ArrayList<String> names = new ArrayList<String>();
                    for(Orders a : list){
                        String b = a.name;
                        int p = (a.price).intValue();
                        sum+=p;
                        names.add(""+b+" ("+p+"원)");
                    }
                    totala=(TextView)findViewById(R.id.totalText);
                    totala.setText("총 금액: "+ sum+" 원 ");
                    ArrayAdapter<String> aList = new ArrayAdapter<String>(CheckOrder.this,android.R.layout.simple_list_item_1,names);
                    data.setAdapter(aList);
                    data.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                        @Override
                        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            //Toast.makeText(ItemList.this, orders.get(position).getName()+"이/가 추가되었습니다", Toast.LENGTH_SHORT).show();
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
