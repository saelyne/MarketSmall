package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.small.ItemList.orders;
import static com.example.small.ItemList.positions;
import static com.example.small.StoreAdapter.store_id;
import static com.example.small.StoreAdapter.user_id;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class OrderComplete extends AppCompatActivity {

    private Button checkBtn;
    private TextView totalValue;
    private String name, address,phone;
    private int a;
    EditText editname,editaddress,editphone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_complete);
        totalValue = (TextView) findViewById(R.id.totalPriceValue);
        Intent intent = getIntent();
        a = intent.getExtras().getInt("total");
        totalValue.setText(a+"");



       Log.e("Debug","name"+name+address+phone);

        checkBtn= (Button) findViewById(R.id.orderButton2);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                editname = (EditText) findViewById(R.id.nameText);
                editaddress = (EditText)findViewById(R.id.addressText);
                editphone =(EditText)findViewById(R.id.phoneText);

                name = editname.getText().toString();
                address= editaddress.getText().toString();
                phone = editphone.getText().toString();
                Intent intent2 = getIntent();
                ItemData itemdata= new ItemData(phone,(long)a,address,name,store_id,Long.parseLong(user_id));
                sendRequest(itemdata);
                sendReq(orders,positions);

                Intent intent = new Intent(OrderComplete.this, FinalComplete.class);
                intent.putExtra("total",a);
                startActivity(intent);
            }
        });
    }


    private void sendReq(ArrayList<Orders> order, ArrayList<Integer> pos) {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        for (int i=0; i<pos.size();i++) {
            order.get(pos.get(i)).setSales(Long.parseLong(phone));
            Call<Orders> call = apiService.addItem(order.get(pos.get(i)));
            call.enqueue(new Callback<Orders>() {
                @Override
                public void onResponse(Call<Orders> call, Response<Orders> response) {
                    if (response.isSuccessful()) {


                    } else {
                        Log.e("ERROR", "Unsuccessful");
                    }
                }

                @Override
                public void onFailure(Call<Orders> call, Throwable t) {
                    Log.e("ERROR", "onFailure", t);
                }


            });

        }
    }

    private void sendRequest(ItemData itemdata) {
        ApiService apiService = ApiService.retrofit.create(ApiService.class);
        Call<ItemData> call = apiService.updateItem(itemdata);
        call.enqueue(new Callback<ItemData>() {

            @Override
            public void onResponse(Call<ItemData> call, Response<ItemData> response) {
                if (response.isSuccessful()) {


                } else {
                    Log.e("ERROR", "Unsuccessful");
                }
            }

            @Override
            public void onFailure(Call<ItemData> call, Throwable t) {
                Log.e("ERROR", "onFailure", t);
            }
        });

    }
}