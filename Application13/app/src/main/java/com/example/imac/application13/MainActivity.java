package com.example.imac.application13;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.os.Handler;
import android.os.Message;

public class MainActivity extends AppCompatActivity
{
    Handler handler = new Handler()
    {
        @Override
        public void handleMessage(Message msg)
        {
            TextView elieText = (TextView)findViewById(R.id.elieText);
            String s = "Nice Job";
            elieText.setText(s.toCharArray(), 0, s.length());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void ClickElieButton(View view)
    {

        //Never change the interface in a thread, just gather data here.
        //a handler will change the text
        Runnable r = new Runnable()
        {
            @Override
            public void run()
            {
                //Code below just waits for 10 seconds
                long futureTime = System.currentTimeMillis() + 10000;
                while(System.currentTimeMillis() < futureTime)
                {
                    //prevents multiple threads from bumping into each other, all will be synchronized
                    synchronized (this)
                    {
                        try
                        {
                            wait(futureTime - System.currentTimeMillis());
                        }
                        catch(Exception e)
                        {

                        }
                    }
                }
                //calling the handler
                handler.sendEmptyMessage(0);
            }
        };

        Thread elieThread = new Thread(r);
        elieThread.start();
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
