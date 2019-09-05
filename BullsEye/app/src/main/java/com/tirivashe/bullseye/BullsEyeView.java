package com.tirivashe.bullseye;
import android.content.*;
import android.graphics.*;
import android.view.*;

public class BullsEyeView extends View {

    private Paint paint;

    private int redVal;
    private int greenVal;
    private int blueVal;

    public BullsEyeView (Context context){
        super(context);

        redVal = 248;
        greenVal = 232;
        blueVal = 198;

        paint = new Paint();
    }

    public void onDraw(Canvas canvas){
        float centerX = canvas.getHeight()/2;
        float centerY = canvas.getWidth()/2;

        float radius = canvas.getWidth()/2;

        canvas.drawRGB(194, 183, 158);

        int ringRed = redVal;
        int ringGreen = greenVal;
        int ringBlue = blueVal;

        for(int i = 1; i <= 5; i++){
            paint.setStyle(Paint.Style.FILL);
            paint.setColor(Color.rgb(ringRed, ringGreen,ringBlue));
            canvas.drawCircle(centerX,centerY,radius, paint);

            ringRed -=13;
            ringGreen -= 13;
            ringBlue -= 13;
            radius -= 120;
        }
    }
}
