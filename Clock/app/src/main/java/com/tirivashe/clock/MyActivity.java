package com.tirivashe.clock;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;

public class MyActivity extends Activity {

    private Thread animationThread;
    private Dial dialView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        dialView1 = new Dial(this);
        setContentView(dialView1);
        animationThread = new Thread(runningAnimation);
        animationThread.start();
    }
    private Runnable runningAnimation = new Runnable() {
        private static final int DELAY = 1;
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
            dialView1.update();
        }
    };
    @Override
    protected void onPause(){
        super.onPause();
        threadHandler.removeCallbacks(runningAnimation);

    }
}
