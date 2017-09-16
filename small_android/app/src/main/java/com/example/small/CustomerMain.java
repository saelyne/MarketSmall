package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Saelyne on 2017. 9. 15..
 */

public class CustomerMain extends AppCompatActivity{

    private Button setLocationBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.customer_main);

        ActivityCompat.requestPermissions(this, new String[] {
                android.Manifest.permission.ACCESS_FINE_LOCATION,
                android.Manifest.permission.ACCESS_COARSE_LOCATION }, 0);

        setLocationBtn= (Button) findViewById(R.id.Setlocationbutton);

        setLocationBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(CustomerMain.this, SetLocation.class);
                startActivity(intent);
            }
        });
    }

}
