package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Saelyne on 2017. 9. 16..
 */

public class TypeSeller extends AppCompatActivity {

    private Button checkBtn;
    private String phone;
    private EditText editphone;
    public static String uid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.type_seller);

        checkBtn = (Button) findViewById(R.id.button2);
        checkBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editphone = (EditText)findViewById(R.id.phoneText1);
                phone = editphone.getText().toString();
                uid = phone;

                Intent intent = new Intent(TypeSeller.this, SellerMain.class);
                intent.putExtra("phonenum",phone);
                startActivity(intent);
            }
        });
    }
}
