package com.tirivashe.bouncingball;

import android.app.Activity;
import android.os.Bundle;
import android.widget.FrameLayout;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        FrameLayout frameLayout = (FrameLayout)findViewById(R.id.frameLayout);
        BounceSurfaceView bounceSurfaceView = new BounceSurfaceView(this,null);
        frameLayout.addView(bounceSurfaceView);
    }
}
