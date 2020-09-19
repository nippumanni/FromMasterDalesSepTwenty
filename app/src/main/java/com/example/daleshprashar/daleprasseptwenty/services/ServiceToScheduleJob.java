package com.example.daleshprashar.daleprasseptwenty.services;

import android.app.job.JobParameters;
import android.app.job.JobService;
import android.util.Log;

class ServiceToScheduleJob extends JobService {
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        // if true   Something to do on main thread...
        sideJob(jobParameters);
        return false;
    }

    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        // if true.. it will restart if failed or something to do never be called.
        return false;
    }

    void sideJob(JobParameters params)
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
for (int i = 0; i<10 ; i++)
{
    Log.i("Tag","run"+ "-"+i);

    try {
        Thread.sleep(1000);
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
}
            }
        }).start();
    }
}
