package com.example.hongyejin.small;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class isDeliveredActivity extends AppCompatActivity {

    private TextView name, address, number;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_is_delivered);
        name = (TextView)findViewById(R.id.deliverName);
        address =(TextView)findViewById(R.id.deliverAddress);
        number=(TextView)findViewById(R.id.deliverNumber);


    }
}
