package com.example.daleshprashar.daleprasseptwenty.services;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

class MyService  extends Service {

   // only necessity method to override
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        // comes in Picture when talked about Bound service
        return null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        // not gonna  stop itself
        Log.i("TAG","Service Stopped");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.i("TAG","start service");
        Log.i("TAG","Running Thread Id For Service"+Thread.currentThread().getId());

        //   Cant stop the service Explicitily(wrong). Lifecycle methods will take place.
        // it will stop in onDestroy
onDestroy();
        stopSelf();
       //   returns integer of flag that determines behaviour of service.
        return super.onStartCommand(intent, flags, startId);
    }

/*                             Auto restart           Intent
Start Sticky                Yes                 nullIntent   // Long running --  Long running Music
                                                        it will restart when music stops. whcih song was playinh
Start Non Sticky        No                  With Intent When Started
                                                        Alarm Service(once run and not restart)
                                                        Server Data polling
                                                        No Need to restart as they are going to be triggered after every twenty mins.


Start redeliver intent   Yes                Intent
                                                        File Download(gets killed some resource-- shouldresume where file was dowanloaded)
1

Polling is the process where the computer or controlling device waits for an external device to check for its readiness or state, often with low-level hardware. For example, when a printer is connected via a parallel port, the computer waits until the printer has received the next character.
 */

}
