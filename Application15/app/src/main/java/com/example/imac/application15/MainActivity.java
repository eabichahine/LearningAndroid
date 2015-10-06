package com.example.imac.application15;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.imac.application15.MyService.MyLocalBinder;

public class MainActivity extends AppCompatActivity
{

    MyService elieService;
    boolean isBound = false;

    public void showTime(View v)
    {
        String currentTime = elieService.getCurrentTime();
        TextView elieText = (TextView)findViewById(R.id.elieText);
        elieText.setText(currentTime.toCharArray(), 0, currentTime.length());
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent i = new Intent(this, MyService.class);
        bindService(i, elieConnection, Context.BIND_AUTO_CREATE);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        int id = item.getItemId();

        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    //This class tells our service what to do when we connect to the service
    private ServiceConnection elieConnection = new ServiceConnection()
    {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service)
        {
            MyLocalBinder binder = (MyLocalBinder) service;
            elieService = binder.getService();
            isBound = true;
        }

        @Override
        public void onServiceDisconnected(ComponentName name)
        {
            isBound = false;
        }
    };
}
