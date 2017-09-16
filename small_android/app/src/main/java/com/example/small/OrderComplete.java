package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class OrderComplete extends AppCompatActivity {

    private Button checkBtn;
    private TextView totalValue;
    private String name, address, phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_complete);
        totalValue = (TextView) findViewById(R.id.totalPriceValue);
        Intent intent = getIntent();
        int a = intent.getExtras().getInt("total");
        totalValue.setText(a+"");

        name = findViewById(R.id.nameText).toString();
        address = findViewById(R.id.addressText).toString();
        phone = findViewById(R.id.phoneText).toString();


        checkBtn= (Button) findViewById(R.id.orderButton2);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderComplete.this, login.class);
                startActivity(intent);
            }
        });
    }
}