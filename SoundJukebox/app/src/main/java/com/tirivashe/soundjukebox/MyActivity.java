package com.tirivashe.soundjukebox;

import android.app.Activity;
import android.os.Bundle;
import android.media.*;
import android.util.*;
import android.view.*;
import android.*;
import android.widget.ImageButton;
import android.widget.MediaController;

public class MyActivity extends Activity {

    private ImageButton bellClangBtn;
    private ImageButton funkyGongBtn;
    private ImageButton spookyCryBtn;
    private ImageButton randomHaBtn;
    private ImageButton drumSoloBtn;

    private SoundPool soundPool;
    private SparseIntArray soundMap;
    private MediaPlayer mMediaPlayer;
    private MediaController mMediaController;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        configureSounds();
        initializeJukeBoxBtns();
    }

    private void configureSounds(){
        soundPool = new SoundPool(1,AudioManager.STREAM_MUSIC,0);
        soundMap = new SparseIntArray(4);
        soundMap.put(1,soundPool.load(this,R.raw.bell_clang,1));
        soundMap.put(2,soundPool.load(this,R.raw.funky_gong,1));
        soundMap.put(3,soundPool.load(this,R.raw.spooky_cry,1));
        soundMap.put(4,soundPool.load(this,R.raw.random_ha,1));

        mMediaPlayer = MediaPlayer.create(this,R.raw.drum);
        mMediaController = new MediaController(this);
        mMediaController.setEnabled(true);
    }

    private void initializeJukeBoxBtns(){
        bellClangBtn = (ImageButton)findViewById(R.id.imageButton1);
        funkyGongBtn = (ImageButton)findViewById(R.id.imageButton2);
        spookyCryBtn = (ImageButton)findViewById(R.id.imageButton3);
        randomHaBtn = (ImageButton)findViewById(R.id.imageButton4);
        drumSoloBtn = (ImageButton)findViewById(R.id.imageButton5);

        bellClangBtn.setOnClickListener(playSoundEffect);
        funkyGongBtn.setOnClickListener(playSoundEffect);
        spookyCryBtn.setOnClickListener(playSoundEffect);
        randomHaBtn.setOnClickListener(playSoundEffect);
        drumSoloBtn.setOnClickListener(playSoundEffect);
    }

    private View.OnClickListener playSoundEffect = new View.OnClickListener() {
        @Override
        public void onClick(View btn) {
            String soundName = (String) btn.getContentDescription();

            if(soundName.contentEquals("Bell Clang")){
                soundPool.play(1,1,1,1,0,1.0f);
            }
            else if(soundName.contentEquals("Funky Gong")){
                soundPool.play(2,1,1,1,0,1.0f);
            }
            else if(soundName.contentEquals("Random Ha")){
                soundPool.play(3,1,1,1,0,1.0f);
            }
            else if(soundName.contentEquals("Spooky Cry")){
                soundPool.play(4,1,1,1,0,1.0f);
            }
            else if(soundName.contentEquals("Drum Solo")){
                mMediaController.show();
                mMediaPlayer.start();
            }
        }
    };
}
