package com.example.daleshprashar.daleprasseptwenty.services;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;

import com.example.daleshprashar.daleprasseptwenty.R;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

class CallJobSchedulerActivity extends AppCompatActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        setContentView(R.layout.schedule_job);
    }
    void scheduleJob(View v)
    {
        ComponentName componentName = new ComponentName(this, ServiceToScheduleJob.class);
        JobInfo jobInfo = new JobInfo.Builder(007,componentName)
                .setRequiresCharging(true)
                .setPersisted(true)
                .setPeriodic(15*60*1000)
                .build();

        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
       int resultOfJobSchedule = jobScheduler.schedule(jobInfo);
       if (resultOfJobSchedule == JobScheduler.RESULT_SUCCESS)
       {
           Log.i("tag","Job Scheduled Success");
       }else
       {
           Log.i("tag","Job Scheduled failed");

       }
    }
}
