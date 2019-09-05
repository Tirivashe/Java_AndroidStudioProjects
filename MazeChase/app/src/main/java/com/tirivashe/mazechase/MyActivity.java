package com.tirivashe.mazechase;

import android.app.Activity;
import android.os.Bundle;
import android.content.*;
import android.graphics.drawable.AnimationDrawable;
import android.view.*;
import android.widget.*;

public class MyActivity extends Activity {

    RelativeLayout relativeLayout;
    private ImageView pig;
    private LayoutInflater layoutInflater;
    private float xPos;
    private float yPos;
    private MazeCanvas maze;
    private int cellId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);
        maze = new MazeCanvas(this);
        xPos = maze.board[0].x - 320;
        yPos = maze.board[0].y - 470;
        cellId = 0;


        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        relativeLayout.addView(maze,0);

        layoutInflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        pig = (ImageView)layoutInflater.inflate(R.layout.pig_view,null);
        pig.setBackgroundResource(R.drawable.pig_animation);

        AnimationDrawable pigAnimate = (AnimationDrawable)pig.getBackground();
        pigAnimate.start();

        pig.setX(xPos);
        pig.setY(yPos);
        pig.setScaleX(.06f);
        pig.setScaleY(.06f);
        relativeLayout.addView(pig, 1);
    }
    public void goUp(View view){
        if(maze.board[cellId].north == false){
            yPos -= 80;
            pig.setY(yPos);
            cellId -= maze.COLS;
        }
    }
    public void goLeft(View view){
        if(maze.board[cellId].west == false){
            xPos -= 80;
            pig.setX(xPos);
            cellId --;
        }
    }
    public void goRight(View view){
        if(maze.board[cellId].east == false){
            xPos += 80;
            pig.setX(xPos);
            cellId ++;
        }
    }
    public void goDown(View view){
        if(maze.board[cellId].south == false){
            yPos += 80;
            pig.setY(yPos);
            cellId += maze.COLS;
        }
    }

}