package com.tirivashe.beefindsfinger;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MyActivity extends Activity {

    private Thread calculateThread;
    private RelativeLayout mainLayout;

    private ImageView beeImageView, flowerImageView;

    private Flower mFlower;
    private Bee mBee;

    private int xLocation, yLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_my);

        mainLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        xLocation = 200;
        yLocation = 200;
        addFlower();
        buildBee();

        calculateThread = new Thread(calculateAction);
    }

    private void addFlower(){
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int initialXPosition = xLocation, initialYPosition = yLocation;

        mFlower = new Flower();
        mFlower.setX(initialXPosition);
        mFlower.setY(initialYPosition);

        flowerImageView = (ImageView)layoutInflater.inflate(R.layout.flower_image,null);
        flowerImageView.setX((float) mFlower.getX());
        flowerImageView.setY((float) mFlower.getY()+50);
        mainLayout.addView(flowerImageView, 0);
    }
    private void buildBee(){
        LayoutInflater layoutInflater;
        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        int initialXPosition = xLocation, initialYPosition = yLocation;
        int proportionalVelocity = 10;

        mBee = new Bee();
        mBee.setX(initialXPosition);
        mBee.setY(initialYPosition);
        mBee.setVelocity(proportionalVelocity);

        beeImageView = (ImageView)layoutInflater.inflate(R.layout.bee_image,null);
        beeImageView.setX((float) mBee.getX());
        beeImageView.setY((float) mBee.getY());
        mainLayout.addView(beeImageView,0);
    }
    @Override
    protected void onResume(){
        calculateThread.start();
        super.onResume();
    }
    @Override
    protected void onPause(){
        finish();
        super.onPause();
    }
    @Override
    protected void onDestroy(){
        finish();
        super.onDestroy();
    }
    private Runnable calculateAction = new Runnable() {
        private static final int DELAY = 200;
        public void run() {
            try{
                while (true){
                    mBee.move(xLocation,yLocation);
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    public Handler threadHandler = new Handler(){
        public  void handleMessage(android.os.Message msg){
            beeImageView.setX((float) mBee.getX());
            beeImageView.setY((float) mBee.getY());
        }
    };
    public boolean onTouchEvent(MotionEvent event){
        int touchAction = event.getActionMasked();

        switch (touchAction){
            case MotionEvent.ACTION_DOWN:
                xLocation = (int) event.getX();
                yLocation = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
                xLocation = mFlower.getX();
                yLocation = mFlower.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                xLocation = (int) event.getX();
                yLocation = (int) event.getY();
        }
        return true;
    }
}
