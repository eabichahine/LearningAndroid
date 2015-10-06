package com.example.imac.application14;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

public class EliesIntentService extends IntentService
{
    private static final String TAG = "com.example.imac.application14                            ";
    public EliesIntentService()
    {
        super("EliesIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent)
    {
        //This is what the service does
        Log.i(TAG, "The service has now started");
    }
}
