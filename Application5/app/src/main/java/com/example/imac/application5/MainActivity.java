package com.example.imac.application5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button elieButton = (Button) findViewById(R.id.ElieButton);
        elieButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        TextView elieText = (TextView)findViewById(R.id.ElieText);
                        String s = "Got Clicked";
                        elieText.setText(s.toCharArray(), 0, s.length());
                    }
                }
        );

        elieButton.setOnLongClickListener(
                new Button.OnLongClickListener()
                {
                    public boolean onLongClick(View v)
                    {
                        TextView elieText = (TextView)findViewById(R.id.ElieText);
                        String s = "Got Long Clicked";
                        elieText.setText(s.toCharArray(), 0, s.length());

                        //Just telling Java that the event got handled so that it does not
                        //get handled by the click listener
                        return true;
                    }
                }
        );
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
