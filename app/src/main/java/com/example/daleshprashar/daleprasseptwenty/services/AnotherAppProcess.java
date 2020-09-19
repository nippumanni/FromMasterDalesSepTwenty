package com.example.daleshprashar.daleprasseptwenty.services;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;

import com.example.daleshprashar.daleprasseptwenty.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class AnotherAppProcess extends AppCompatActivity {
    Button getRandomNumberOrWhateverFromAnotherProcess;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.another_app);
        getRandomNumberOrWhateverFromAnotherProcess = findViewById(R.id.getFromAnotherApp);
        getRandomNumberOrWhateverFromAnotherProcess.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }

   void callAnotherApp()
    {
        Intent intent= new Intent();
        intent.setComponent(new ComponentName("package.service","package.clientService"));

    }
}
/*
ServiceConnection   Ibinder  onStartComm
   Start     stop     bind
Message   messsenger
Do we have two apps running in same device? and they catch their packages....  by component name and message and messenger

 */