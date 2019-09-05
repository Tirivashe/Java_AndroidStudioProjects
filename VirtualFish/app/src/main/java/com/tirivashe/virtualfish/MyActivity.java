package com.tirivashe.virtualfish;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.Handler;
import android.view.Display;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MyActivity extends Activity {

    private Thread calculateMovementThread;
    private ImageView fishImageView;
    private Fish mFish;
    private FrameLayout fishTankLayout;
    private int tankWidth, tankHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        fishTankLayout = (FrameLayout)findViewById(R.id.container);
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        tankWidth =size.x;
        tankHeight=size.y;

        int initialXPosition = 0,initialYPosition = 0;

        mFish = new Fish(initialXPosition,initialYPosition, Fish.IsSwimming, tankWidth, tankHeight);

        buildTank();
        calculateMovementThread = new Thread(calculateMovement);
        calculateMovementThread.start();
    }

    public void buildTank(){
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        ImageView foliageImageView = (ImageView)layoutInflater.inflate(R.layout.foliage_layout,null);
        foliageImageView.setX((float)0);
        foliageImageView.setY((float)0);
        foliageImageView.setAlpha((float).97);
        fishTankLayout.addView(foliageImageView,0);

        fishImageView = (ImageView)layoutInflater.inflate(R.layout.fish_image,null);
        fishImageView.setScaleX((float) .3);
        fishImageView.setScaleY((float).3);
        fishImageView.setX(mFish.x);
        fishImageView.setY(mFish.y);
        fishTankLayout.addView(fishImageView,0);
    }
    private Runnable calculateMovement = new Runnable() {
        private static final int DELAY = 200;
        public void run() {
            try{
                while (true){
                    mFish.move();
                    Thread.sleep(DELAY);
                    updateTankHandler.sendEmptyMessage(0);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    public Handler updateTankHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            fishImageView.setScaleX((float)(.3 * mFish.getFacingDirection()));
            fishImageView.setY((float) mFish.y);
            fishImageView.setX((float) mFish.x);
        }

    };
}
