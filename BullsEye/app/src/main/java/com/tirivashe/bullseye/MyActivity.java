package com.tirivashe.bullseye;

import android.app.Activity;
import android.os.Bundle;
import android.view.*;

public class MyActivity extends Activity {

    BullsEyeView bullsEyeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        bullsEyeView = new BullsEyeView(this);
        setContentView(bullsEyeView);
    }
}
