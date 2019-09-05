package com.tirivashe.gearschurn;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.*;

public class MyActivity extends Activity {

    private ImageView gear1Img;
    private ImageView gear2Img;

    private Gear gear1;
    private Gear gear2;

    private float currentDegree;
    private float degree;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        gear1Img = (ImageView)findViewById(R.id.imageView);
        gear2Img = (ImageView)findViewById(R.id.imageView2);

        initializeGears();
    }

    private void initializeGears(){
        gear1 = new Gear();
        gear1.setStartDegree(0);
        gear1.setEndDegree(360);

        gear2 = new Gear();
        gear2.setStartDegree(0);
        gear2.setEndDegree(-360);
    }

    public void animateGears(View view){
        final int DELAY = 1000;

        RotateAnimation ra1 = new RotateAnimation(gear1.getStartDegree(), gear1.getEndDegree(), Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra1.setDuration(DELAY);
        ra1.setFillAfter(true);
        gear1Img.startAnimation(ra1);

        RotateAnimation ra2 = new RotateAnimation(gear2.getStartDegree(), gear2.getEndDegree(), Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        ra2.setDuration(DELAY);
        ra2.setFillAfter(true);
        gear2Img.startAnimation(ra2);


    }
}
