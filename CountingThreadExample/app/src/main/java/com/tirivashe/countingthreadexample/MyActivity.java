package com.tirivashe.countingthreadexample;

import android.app.Activity;
import android.os.*;
import android.view.*;
import android.widget.*;

public class MyActivity extends Activity {

    private TextView countTextView;
    private Integer count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        countTextView = (TextView) findViewById(R.id.textView);

        count = 0;

        Thread thread = new Thread(countNumbers);
        thread.start();
    }
    @Override
    protected void onStart(){
        super.onStart();
        count = 0;
    }

    private Runnable countNumbers = new Runnable(){
        private static final int DELAY = 1000;
        public void run(){
            try {
                while (true){
                    count++;
                    Thread.sleep (DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    };
    public Handler threadHandler = new Handler(){
        public void handleMessage (android.os.Message message){
            countTextView.setText(count.toString());
        }
    };
}
