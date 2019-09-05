package com.tirivashe.animateddila;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MyActivity extends Activity {

    private Thread animationThread;
    private DialView dialView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        dialView = new DialView(this);
        setContentView(dialView);
        animationThread = new Thread(runningAnimation);
        animationThread.start();
    }
    private Runnable runningAnimation = new Runnable() {
        private static final int DELAY = 200;
        public void run() {
            try{
                while (true){
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    public Handler threadHandler = new Handler(){
        public void handleMessage(android.os.Message message){
            dialView.update();
        }
    };
    @Override
    protected void onPause(){
        super.onPause();
        threadHandler.removeCallbacks(runningAnimation);
    }
}
