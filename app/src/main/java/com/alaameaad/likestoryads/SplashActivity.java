package com.alaameaad.likestoryads;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import static com.alaameaad.likestoryads.HelperMethod.ReplaceFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {


                    Intent intent = new Intent(SplashActivity.this , HomeActivity.class);

                    startActivity(intent);



            }

        }, 2700);

    }
}
