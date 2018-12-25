package com.bluewebspark.dbtestproject.sohel;

import android.annotation.SuppressLint;
import android.app.job.JobParameters;
import android.app.job.JobService;

@SuppressLint("NewApi")
public class MyJobService extends JobService {
    private static final String TAG = MyJobService.class.getSimpleName();
    boolean isWorking = false;
    boolean jobCancelled = false;

    // Called by the Android system when it's time to run the job
    @Override
    public boolean onStartJob(JobParameters jobParameters) {
        S.E("Job started!");
        isWorking = true;
        // We need 'jobParameters' so we can call 'jobFinished'
        startWorkOnNewThread(jobParameters); // Services do NOT run on a separate thread
        return isWorking;
    }

    private void startWorkOnNewThread(final JobParameters jobParameters) {
        new Thread(new Runnable() {
            public void run() {
                doWork(jobParameters);
            }
        }).start();
    }

    private void doWork(JobParameters jobParameters) {
        // 10 seconds of working (1000*10ms)
        for (int i = 0; i < 1000; i++) {
            // If the job has been cancelled, stop working; the job will be rescheduled.
            if (jobCancelled)
                return;

            S.E("Job Running!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        S.E("Job finished!");
        isWorking = false;
        boolean needsReschedule = false;
        jobFinished(jobParameters, needsReschedule);
    }

    // Called if the job was cancelled before being finished
    @Override
    public boolean onStopJob(JobParameters jobParameters) {
        S.E("Job cancelled before being completed.");
        jobCancelled = true;
        boolean needsReschedule = isWorking;
        jobFinished(jobParameters, needsReschedule);
        return needsReschedule;
    }
}