package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Saelyne on 2017. 9. 17..
 */


public class FinalComplete extends AppCompatActivity {

    private Button tempBtn;
    private TextView totalSum;
    private TextView time;
    private int a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_complete);

        totalSum = (TextView) findViewById(R.id.totalSum);
        Intent intent = getIntent();
        a = intent.getExtras().getInt("total");
        totalSum.setText("총 주문 금액 : "+a+"원");

        tempBtn = (Button) findViewById(R.id.btn);


        tempBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FinalComplete.this, login.class);
                startActivity(intent);
            }
        });


    }
}
