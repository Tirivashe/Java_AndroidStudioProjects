package com.tirivashe.artinmotions;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.RelativeLayout;

public class MyActivity extends Activity {
    private Thread calculateMovementThread;
    private Thread drawMovementThread;

    private final int OBJECTS_N = 19;

    private int [][] currentPositions = new int[19][2];
    private int [][] finalDestination = new int [19][2];

    private ArtWorkView artWorkView;
    private RelativeLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        initialize();
        mainLayout = (RelativeLayout)findViewById(R.id.relativeLayout1);
        artWorkView = new ArtWorkView(this);
        mainLayout.addView(artWorkView,0);
        calculateMovementThread = new Thread(calculateMovement);
        drawMovementThread = new Thread(drawMovement);

        calculateMovementThread.start();
        drawMovementThread.start();
    }

    private void initialize(){
        for (int i = 0; i < OBJECTS_N; i++){
            finalDestination[i][0] = 200;
            finalDestination[i][1] = 200;

            currentPositions[i][0] = 20;
            currentPositions[i][1] = 20;
        }
    }
    public void createA(View view){
        for (int i = 0; i < OBJECTS_N; i++) {
            finalDestination[i][0] = ArtDesign.artA[i][0];
            finalDestination[i][1] = ArtDesign.artA[i][1];
        }
    }
    public void createB(View view) {
        for (int i = 0; i < OBJECTS_N; i++) {
            finalDestination[i][0] = ArtDesign.artB[i][0];
            finalDestination[i][1] = ArtDesign.artB[i][1];
        }
    }
    public void createC(View view) {
        for (int i = 0; i < OBJECTS_N; i++) {
            finalDestination[i][0] = ArtDesign.artC[i][0];
            finalDestination[i][1] = ArtDesign.artC[i][1];
        }
    }

    public Runnable calculateMovement = new Runnable() {
        private static final int DELAY = 200;
        public void run() {
            try{
                while (true){
                    for (int i = 0; i < OBJECTS_N; i++){
                        currentPositions[i][0] += (finalDestination[i][0] - currentPositions[i][0])/5;
                        currentPositions[i][1] += (finalDestination[i][1] - currentPositions[i][1])/5;
                    }
                    Thread.sleep(DELAY);
                }
            }catch (InterruptedException e){}
        }
    };

    private Runnable drawMovement = new Runnable() {
        private static final int DELAY = 200;
        public void run() {
            try{
                while (true){
                    Thread.sleep(DELAY);
                    threadHandler.sendEmptyMessage(0);
                }
            }catch (InterruptedException e){}
        }
    };

    public Handler threadHandler = new Handler(){
        public void handleMessage(android.os.Message msg){
            artWorkView.update(currentPositions);
        }
    };
}
