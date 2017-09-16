package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saelyne on 2017. 9. 17..
 */


public class FinalComplete extends AppCompatActivity {

    private Button tempBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.final_complete);

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
