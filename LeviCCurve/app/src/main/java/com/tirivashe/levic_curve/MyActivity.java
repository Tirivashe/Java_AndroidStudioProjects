package com.tirivashe.levic_curve;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;
import android.widget.*;

public class MyActivity extends Activity {

    private TextView levelsTV;
    private Integer level;
    private RelativeLayout relativeLayout;
    private FractalView fractalView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        relativeLayout = (RelativeLayout)findViewById(R.id.relativeLayout);
        fractalView = new FractalView(this);
        relativeLayout.addView(fractalView, 0);

        level = 1;
        levelsTV = (TextView)findViewById(R.id.textView1);
    }

    public void drawFractal(View view){
        fractalView.level = level;
        fractalView.invalidate();
    }

    public void stepUp(View view){
        if(level < 14){
            level++;
            levelsTV.setText(level.toString());
        }
    }

    public void stepDown(View view){
        if(level > 1){
            level --;
            levelsTV.setText(level.toString());
        }
    }
}
