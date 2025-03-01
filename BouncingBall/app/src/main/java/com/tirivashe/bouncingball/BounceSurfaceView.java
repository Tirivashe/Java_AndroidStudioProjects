package com.tirivashe.bouncingball;

import android.*;
import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.jar.Attributes;

public class BounceSurfaceView extends SurfaceView implements SurfaceHolder.Callback {
    private BounceThread bounceThread;

    public BounceSurfaceView (Context context, AttributeSet attrs){
        super(context, attrs);

        SurfaceHolder holder = getHolder();
        holder.addCallback(this);

        bounceThread = new BounceThread (holder);
    }

    public void surfaceCreated(SurfaceHolder holder){
        bounceThread.start();
    }

    public void surfaceChanged (SurfaceHolder holder, int format, int width, int height){

    }
    public void surfaceDestroyed (SurfaceHolder holder){
        bounceThread.endBounce();
        Thread dummyThread = bounceThread;
        bounceThread = null;
        dummyThread.interrupt();
    }
}
