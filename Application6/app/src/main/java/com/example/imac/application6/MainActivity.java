package com.example.imac.application6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener
{

    private TextView elieMessage;
    private GestureDetectorCompat gestureDetector;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        elieMessage = (TextView)findViewById(R.id.ElieMessage);
        gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e)
    {
        String s = "onSingleTapConfirmed";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e)
    {
        String s = "onDoubleTap";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e)
    {
        String s = "onDoubleTapEvent";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e)
    {
        String s = "onDown";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e)
    {
        String s = "onShowPress";
        elieMessage.setText(s.toCharArray(), 0, s.length());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e)
    {
        String s = "onSingleTapUp";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY)
    {
        String s = "onScroll";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e)
    {
        String s = "onLongPress";
        elieMessage.setText(s.toCharArray(), 0, s.length());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY)
    {
        String s = "onFling";
        elieMessage.setText(s.toCharArray(), 0, s.length());
        return true;
    }

    //////////////////End Gestures///////////////////////



    //This is the default function that gets called when the user touches the screen
    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
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
