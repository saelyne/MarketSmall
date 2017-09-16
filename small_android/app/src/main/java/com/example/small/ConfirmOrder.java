package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.example.small.ItemList.orders;
import static com.example.small.ItemList.positions;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class ConfirmOrder extends AppCompatActivity {

    private Button checkBtn;
    private ListView data;
    private TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.confirm_order);

        data = (ListView) findViewById(R.id.data);
        total = (TextView) findViewById(R.id.total);

        ArrayList<String> cart = new ArrayList<String>();
        int sum=0;
       for(int i=0; i<positions.size();i++){
           cart.add(orders.get(positions.get(i)).name);
           sum+=orders.get(positions.get(i)).price;
       }
       total.setText("총 금액: "+ sum+" 원 ");

        ArrayAdapter<String> aList = new ArrayAdapter<String>(ConfirmOrder.this,android.R.layout.simple_list_item_1,cart);
        data.setAdapter(aList);


        checkBtn= (Button) findViewById(R.id.orderButton1);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ConfirmOrder.this, OrderComplete.class);
                startActivity(intent);
            }
        });
    }
}
