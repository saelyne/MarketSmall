package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Saelyne on 2017. 9. 17..
 */

public class ItemAdd extends AppCompatActivity {
    private Button addBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_add);

        addBtn= (Button) findViewById(R.id.addBtn);
        addBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(ItemAdd.this, "추가되었습니다", Toast.LENGTH_SHORT).show();

            }
        });

    }

}
