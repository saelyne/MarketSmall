package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class SellerMain extends AppCompatActivity {

    private Button deliverBtn;
    private Button addBtn;
    private Button deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.seller_main);

        deliverBtn = (Button) findViewById(R.id.deliver);
        addBtn = (Button) findViewById(R.id.add);
        deleteBtn = (Button) findViewById(R.id.delete);

        deliverBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerMain.this, DeliverList.class);
                startActivity(intent);
            }
        });

        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerMain.this, ItemAdd.class);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SellerMain.this, ItemDelete.class);
                startActivity(intent);
            }
        });
    }
}
