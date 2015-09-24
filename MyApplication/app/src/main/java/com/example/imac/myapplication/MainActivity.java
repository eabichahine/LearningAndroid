package com.example.imac.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android .util.Log;

public class MainActivity extends AppCompatActivity
{

    private static final String TAG = "EliesMessages";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "OnCreate");
    }

    @Override
    protected void onStart()
    {
        super.onStart();
        Log.i(TAG, "OnStart");
    }

    @Override
    protected void onPause()
    {
        super.onPause();
        Log.i(TAG, "OnPause");
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        Log.i(TAG, "OnResume");
    }

    @Override
    protected void onStop()
    {
        super.onStop();
        Log.i(TAG, "OnStop");
    }

    @Override
    protected void onRestart()
    {
        super.onRestart();
        Log.i(TAG, "OnRestart");
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        Log.i(TAG, "OnDestroy");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        Log.i(TAG, "OnSaveInstanceState");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState)
    {
        super.onRestoreInstanceState(savedInstanceState);
        Log.i(TAG, "OnRestoreInstanceState");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
