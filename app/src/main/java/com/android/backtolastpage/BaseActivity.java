package com.android.backtolastpage;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

public class BaseActivity extends AppCompatActivity implements GestureDetector.OnGestureListener{
    GestureDetector gestureDetector;
    protected static final float FLIP_DISTANCE = 50;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);
        gestureDetector = new GestureDetector(this,this);
    }


    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        return false;
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {

    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent1, float v, float v1) {
        if(motionEvent.getX() - motionEvent1.getX() > FLIP_DISTANCE)
        {
            Toast.makeText(this, "左滑", Toast.LENGTH_SHORT).show();
            return true;
        }
        if(motionEvent1.getX() - motionEvent.getX() > FLIP_DISTANCE)
        {
            Toast.makeText(this, "右滑", Toast.LENGTH_SHORT).show();
            onBackPressed();
            return true;
        }
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }
}