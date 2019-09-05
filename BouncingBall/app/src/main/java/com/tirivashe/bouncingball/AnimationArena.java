package com.tirivashe.bouncingball;

import android.graphics.Canvas;

public class AnimationArena {
    private Ball mBall;

    public AnimationArena(){
        mBall = new Ball();
    }
    public void update (int width, int height){
        mBall.move(0,0,width,height);
    }
     public void draw (Canvas canvas){
        canvas.drawRGB(156,174,216);
        mBall.draw(canvas);
     }
}
