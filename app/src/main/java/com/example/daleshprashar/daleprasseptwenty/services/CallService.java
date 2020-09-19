package com.example.daleshprashar.daleprasseptwenty.services;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.daleshprashar.daleprasseptwenty.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class CallService extends AppCompatActivity {
    private Button startServiceButton;
    private Button stopServiceButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_service);
        Log.i("TAG","Running Thread Id For MainActivity"+Thread.currentThread().getId());
        initViews();
        initOnCLickListener();
    }

    private void initViews()
    {
startServiceButton = findViewById(R.id.startServiceButton);
        stopServiceButton = findViewById(R.id.stopServiceButton);

    }

    private void initOnCLickListener()
    {
        startServiceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent serviceCallIntent = new Intent();
                serviceCallIntent.setAction("MyService");
                startService(serviceCallIntent);

            }
        });
    }
}
