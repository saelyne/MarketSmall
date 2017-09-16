package com.example.small;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.text.format.DateUtils;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;

public class login extends AppCompatActivity {

    private Button customerBtn;
    private Button sellerBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        customerBtn = (Button) findViewById(R.id.Customerbutton);
        sellerBtn = (Button) findViewById(R.id.Sellerbutton);

        customerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, BuyerMain.class);
                startActivity(intent);
            }
        });

        sellerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(login.this, TypeSeller.class);
                startActivity(intent);
            }
        });

        showSplash(DateUtils.SECOND_IN_MILLIS);
    }

    protected void showSplash(long duration)  {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final View layout_splash = findViewById(R.id.layout_splash);
                Animation anim_fadeout = AnimationUtils.loadAnimation(getBaseContext(), R.anim.fade_out);
                anim_fadeout.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        layout_splash.setVisibility(View.GONE);
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }
                });
                layout_splash.startAnimation(anim_fadeout);
            }
        }, duration);
    }
}