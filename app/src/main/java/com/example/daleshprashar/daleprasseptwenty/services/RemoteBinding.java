package com.example.daleshprashar.daleprasseptwenty.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.RemoteException;

import androidx.annotation.Nullable;

class RemoteBinding extends Service {
    private Messenger messenger= new Messenger(new RandomHandler());

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                // getrandomNumber
            }
        }).start();
        return START_STICKY;
       // return super.onStartCommand(intent, flags, startId);
    }
   public class RandomHandler extends Handler
    {
        RandomHandler()
        {

        }
        Message messageSendXXXFromProcessA = Message.obtain(null,0);
        @Override
        public void handleMessage(Message msg) {
if (msg.equals("Provide"))
{
    try {
        msg.replyTo.send(messageSendXXXFromProcessA);
    } catch (RemoteException e) {
        e.printStackTrace();
    }
}
        }
    }

    /*
    Ibinder will do start

    MessageQueue
    onStartCommand   that starts the thread
    Flag GETCOUNt


    Then  we will pass the message to the Messenger
    ---

    Service Started
    Random number
    Message
    Messenger
    ---
    Phase 2 :
    IMplementation of Another activity
     */


}
