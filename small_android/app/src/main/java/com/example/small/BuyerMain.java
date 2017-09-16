package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class BuyerMain extends AppCompatActivity {

    private Button orderBtn;
    private Button checkBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.buyer_main);

        orderBtn= (Button) findViewById(R.id.order1);
        orderBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyerMain.this, SetLocation.class);
                startActivity(intent);
            }
        });

        checkBtn= (Button) findViewById(R.id.check1);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(BuyerMain.this, CheckOrder.class);
                startActivity(intent);
            }
        });

    }

}