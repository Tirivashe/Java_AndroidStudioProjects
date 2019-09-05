package com.tirivashe.clock;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class Dial extends View {
    private float angle;
    private Paint paint;
    private int second;

    public Dial (Context context){
        super(context);
        angle = 0;

        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(150);
    }
    @Override
    protected void onDraw(Canvas canvas){
        canvas.drawRGB(248,232,198);
        int w = getMeasuredWidth();
        int h = getMeasuredHeight();
        int radius;
        if (w > h){
            radius = h/2;
        }else {
            radius = w/2;
        }
        paint.setColor(Color.rgb(126,79,43));
        canvas.drawCircle(w/2,h/2,radius,paint);

        paint.setColor(Color.rgb(0,0,0));
        canvas.drawCircle(w/2,h/2,radius/12,paint);

        angle += 1;
        if (angle > 360){
            angle = 0;
        }
        float radians = (float)(angle * (Math.PI/180));
        float stopX = (float)(w/2 + radius*Math.sin(radians));
        float stopY = (float)(h/2 - radius*Math.cos(radians));

        paint.setColor(Color.rgb(132,175,166));
        canvas.drawLine(w/2,h/2,stopX ,stopY,paint);

        if (second == 10){
            paint.setColor(Color.rgb(132,175,207));
            radians = (float)(second*(Math.PI/180)) ;
            stopX = (float)(w/2 + radius*Math.sin(radians));
            stopY = (float)(h/2 - radius*Math.cos(radians));
            canvas.drawLine(w/2,h/2,stopX ,stopY,paint);
        }else if (second == 200){
            radians = (float)(3600*(Math.PI/180)) ;
            stopX = (float)(w/2 + radius*Math.sin(radians));
            stopY = (float)(h/2 - radius*Math.cos(radians));
            paint.setColor(Color.rgb(132,175,240));
            canvas.drawLine(w/2,h/2,stopX,stopY,paint);
        }
    }
    public void update(){
        invalidate();
        second++;
    }

}