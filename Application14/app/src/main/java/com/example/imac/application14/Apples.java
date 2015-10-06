package com.example.imac.application14;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Apples extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apples);

        //kicking off the service
        Intent intent = new Intent(this, EliesIntentService.class);
        startService(intent);

        Intent intent2 = new Intent(this, MyService.class);
        startService(intent2);

        Button applesButton = (Button)findViewById(R.id.applesButton);
        applesButton.setOnClickListener(
                new Button.OnClickListener()
                {
                    public void onClick(View v)
                    {
                        onButtonClick();
                    }
                }

        );
    }

    private void onButtonClick()
    {
        Intent intent = new Intent(this, Bacon.class);

        MyObject obj = new MyObject();
        obj.strValue = "Hello";
        obj.intValue = 10;
        intent.putExtra("myObject", obj);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apples, menu);
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
