package com.example.imac.application3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;
import android.widget.Button;
import android.graphics.Color;
import android.widget.EditText;
import android.content.res.Resources; //helps us compute pixels from dp
import android.util.TypedValue;  //helps us compute pixels from dp

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        //Every activity will need a layout which will be added to it.
        //you add all the views (button, textfield, etc...) to that layout in order for them to
        //show up on the screen.
        RelativeLayout eliesLayout = new RelativeLayout(this);
        eliesLayout.setBackgroundColor(Color.GREEN);

        //Creating a button
        Button redButton = new Button(this);
        String buttonText = "Log in";
        redButton.setText(buttonText.toCharArray(), 0, buttonText.length());
        redButton.setBackgroundColor(Color.RED);
        redButton.setId(1);

        RelativeLayout.LayoutParams buttonDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        //Adding a rule to the button so that it gets position in the center of the screen
        buttonDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        buttonDetails.addRule(RelativeLayout.CENTER_VERTICAL);


        //Username input
        EditText username = new EditText(this);
        username.setId(2);

        RelativeLayout.LayoutParams usernameDetails = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        usernameDetails.addRule(RelativeLayout.ABOVE, redButton.getId());
        usernameDetails.addRule(RelativeLayout.CENTER_HORIZONTAL);
        usernameDetails.setMargins(0, 0, 0, 50);

        //Convert 200 pixels to dp
        //we do this so that the username has the same size on all devices
        Resources r = getResources();
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 200,
                r.getDisplayMetrics());

        username.setWidth(px);


        //Adding the button to the layout
        eliesLayout.addView(redButton, buttonDetails);
        //Adding the button to the layout
        eliesLayout.addView(username, usernameDetails);

        //make sure the layout is added to the activity
        setContentView(eliesLayout);
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
