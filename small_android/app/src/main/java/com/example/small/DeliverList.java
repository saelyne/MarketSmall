package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saelyne on 2017. 9. 17..
 */

public class DeliverList extends AppCompatActivity {

    private Button tempBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.deliver_list);

        tempBtn = (Button) findViewById(R.id.Checkbutton01);


        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DeliverList.this, SellerMain.class);
                startActivity(intent);
            }
        });


    }
}
