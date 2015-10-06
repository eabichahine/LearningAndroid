package com.example.imac.application14;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class MyService extends Service
{
    private static final String TAG = "com.example.imac.application14";

    public MyService()
    {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.i(TAG, "onStartCommand method called");

        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                for(int i = 0; i < 5; ++i)
                {
                    long futureTime = System.currentTimeMillis() + 5000;
                    while(System.currentTimeMillis() < futureTime)
                    {
                        synchronized (this)
                        {
                            try
                            {
                                wait(futureTime - System.currentTimeMillis());
                                //This is where you would check for new messages or download an image
                                Log.i(TAG, "Service is doing something");
                            }
                            catch (Exception e)
                            {

                            }
                        }
                    }
                }
            }
        };

        Thread elieThread = new Thread(r);
        elieThread.start();
        //This will restart the service if it ever gets destroyed by the app
        return Service.START_STICKY;
    }

    @Override
    public void onDestroy()
    {
        Log.i(TAG, "onDestroy method called");
    }

    @Override
    public IBinder onBind(Intent intent)
    {
        return null;
    }
}